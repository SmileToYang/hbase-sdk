package com.github.CCwexiao.hbase.sdk.dsl.config;

import com.github.CCweixiao.hbase.sdk.common.exception.HBaseOperationsException;
import com.github.CCweixiao.hbase.sdk.common.util.ClassUtil;
import com.github.CCweixiao.hbase.sdk.common.util.ObjUtil;
import com.github.CCweixiao.hbase.sdk.common.util.StringUtil;
import com.github.CCwexiao.hbase.sdk.dsl.client.rowkeytextfunc.RowKeyTextFunc;
import com.github.CCwexiao.hbase.sdk.dsl.literal.LiteralInterpreter;
import com.github.CCwexiao.hbase.sdk.dsl.literal.interpreter.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leojie 2020/11/28 11:07 上午
 */
public abstract class HBaseSQLRuntimeSetting {
    /**
     * scan 缓存大小
     */
    private int scanCachingSize = 20;

    /**
     * delete batch size
     */
    private int deleteBatchSize = 50;

    /**
     * 确定扫描是否可以使用查询的限制来计算缓存大小
     */
    private boolean intelligentScanSize;

    /**
     * row key函数列表
     */
    private final Map<String, RowKeyTextFunc> buildInRowKeyTextFuncCache = new HashMap<>();

    private final Map<Class<?>, LiteralInterpreter> literalInterpreterCache = new HashMap<>();
    private final Map<Class<?>, LiteralInterpreter> buildInLiteralInterpreterCache = new HashMap<>();

    public HBaseSQLRuntimeSetting() {
        List<LiteralInterpreter> buildInLiteralInterpreterList = new ArrayList<>();
        buildInLiteralInterpreterList.add(new BooleanInterpreter());
        buildInLiteralInterpreterList.add(new ByteInterpreter());
        buildInLiteralInterpreterList.add(new CharInterpreter());
        buildInLiteralInterpreterList.add(new DateInterpreter());
        buildInLiteralInterpreterList.add(new DoubleInterpreter());
        buildInLiteralInterpreterList.add(new FloatInterpreter());
        buildInLiteralInterpreterList.add(new IntegerInterpreter());
        buildInLiteralInterpreterList.add(new LongInterpreter());
        buildInLiteralInterpreterList.add(new ShortInterpreter());
        buildInLiteralInterpreterList.add(new StringInterpreter());
        buildInLiteralInterpreterList.add(new HexBytesInterpreter());
        for (LiteralInterpreter interpreter : buildInLiteralInterpreterList) {
            Class<?> type = ClassUtil.tryConvertToBoxClass(interpreter.getTypeCanInterpret());
            buildInLiteralInterpreterCache.put(type, interpreter);
        }
        List<RowKeyTextFunc> buildInRowKeyTextFuncList = buildAllRowKeyTextFuncList();
        if (buildInRowKeyTextFuncList != null && !buildInRowKeyTextFuncList.isEmpty()) {
            for (RowKeyTextFunc func : buildInRowKeyTextFuncList) {
                buildInRowKeyTextFuncCache.put(func.funcName(), func);
            }
        }
    }

    /**
     * 构造所有的rowKey转换函数
     */
   protected abstract List<RowKeyTextFunc> buildAllRowKeyTextFuncList();


    /**
     * 输入row key转换的函数名，如：intkey, stringkey, longkey, hexkey等
     * @param funcName 函数名
     * @return 返回rowKey处理的函数
     */
    public RowKeyTextFunc findRowKeyTextFunc(String funcName) {
        if(StringUtil.isBlank(funcName)){
            throw new HBaseOperationsException("please input a function name.");
        }

        if (buildInRowKeyTextFuncCache.containsKey(funcName)) {
            return buildInRowKeyTextFuncCache.get(funcName);
        }

        throw new HBaseOperationsException("can not find func for " + funcName);
    }

    public Object interpret(Class type, String literalValue){
        ObjUtil.checkIsNull(type);
        ObjUtil.checkIsNull(literalValue);
        Class<?> tempType = ClassUtil.tryConvertToBoxClass(type);

        if(literalInterpreterCache.containsKey(tempType)){
            return literalInterpreterCache.get(tempType).interpret(literalValue);
        }

        if(buildInLiteralInterpreterCache.containsKey(tempType)){
            return buildInLiteralInterpreterCache.get(tempType).interpret(literalValue);
        }

        Object result = null;
        if(tempType.isEnum()){
            result = Enum.valueOf(type, literalValue);
        }
        ObjUtil.checkIsNull(result);

        return result;
    }

    public int getScanCachingSize() {
        return scanCachingSize;
    }

    public void setScanCachingSize(int scanCachingSize) {
        this.scanCachingSize = scanCachingSize;
    }

    public int getDeleteBatchSize() {
        return deleteBatchSize;
    }

    public void setDeleteBatchSize(int deleteBatchSize) {
        this.deleteBatchSize = deleteBatchSize;
    }

    public boolean isIntelligentScanSize() {
        return intelligentScanSize;
    }

    public void setIntelligentScanSize(boolean intelligentScanSize) {
        this.intelligentScanSize = intelligentScanSize;
    }

    public void setLiteralInterpreterCache(List<LiteralInterpreter> literalInterpreterList){
        if (literalInterpreterList != null) {
            for (LiteralInterpreter interpreter : literalInterpreterList) {
                Class<?> type = ClassUtil.tryConvertToBoxClass(interpreter.getTypeCanInterpret());
                literalInterpreterCache.put(type, interpreter);
            }
        }
    }
}
