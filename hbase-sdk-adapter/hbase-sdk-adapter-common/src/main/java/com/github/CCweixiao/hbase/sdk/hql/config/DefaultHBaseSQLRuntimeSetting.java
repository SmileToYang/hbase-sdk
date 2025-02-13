package com.github.CCweixiao.hbase.sdk.hql.config;

import com.github.CCweixiao.hbase.sdk.hql.rowkeytextfunc.HexBytesRowKeyTextFunc;
import com.github.CCweixiao.hbase.sdk.hql.rowkeytextfunc.IntRowKeyTextFunc;
import com.github.CCweixiao.hbase.sdk.hql.rowkeytextfunc.LongRowKeyTextFunc;
import com.github.CCweixiao.hbase.sdk.hql.rowkeytextfunc.StringRowKeyTextFunc;
import com.github.CCwexiao.hbase.sdk.dsl.client.rowkeytextfunc.RowKeyTextFunc;
import com.github.CCwexiao.hbase.sdk.dsl.config.HBaseSQLRuntimeSetting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leojie 2020/11/28 1:01 下午
 */
public class DefaultHBaseSQLRuntimeSetting extends HBaseSQLRuntimeSetting {
    public DefaultHBaseSQLRuntimeSetting(){
        super();
    }

    @Override
    protected List<RowKeyTextFunc> buildAllRowKeyTextFuncList() {
        List<RowKeyTextFunc> rowKeyTextFuncList = new ArrayList<>(4);
        rowKeyTextFuncList.add(new IntRowKeyTextFunc());
        rowKeyTextFuncList.add(new LongRowKeyTextFunc());
        rowKeyTextFuncList.add(new StringRowKeyTextFunc());
        rowKeyTextFuncList.add(new HexBytesRowKeyTextFunc());
        return rowKeyTextFuncList;
    }
}
