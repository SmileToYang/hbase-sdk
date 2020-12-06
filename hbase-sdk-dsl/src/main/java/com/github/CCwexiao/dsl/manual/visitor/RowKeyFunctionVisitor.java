package com.github.CCwexiao.dsl.manual.visitor;

import com.github.CCwexiao.dsl.auto.HBaseSQLBaseVisitor;
import com.github.CCwexiao.dsl.auto.HBaseSQLParser;
import com.github.CCwexiao.dsl.client.rowkeytextfunc.RowKeyTextFunc;
import com.github.CCwexiao.dsl.config.HBaseSQLRuntimeSetting;

/**
 * @author leojie 2020/11/28 11:02 上午
 */
public class RowKeyFunctionVisitor extends HBaseSQLBaseVisitor<RowKeyTextFunc> {
    private final HBaseSQLRuntimeSetting runtimeSetting;

    public RowKeyFunctionVisitor(HBaseSQLRuntimeSetting runtimeSetting) {
        this.runtimeSetting = runtimeSetting;
    }

    @Override
    public RowKeyTextFunc visitRowkey_FuncConstant(HBaseSQLParser.Rowkey_FuncConstantContext ctx) {
        String funcName = ctx.funcname().getText();
        return runtimeSetting.findRowKeyTextFunc(funcName);
    }

    @Override
    public RowKeyTextFunc visitRowkey_Wrapper(HBaseSQLParser.Rowkey_WrapperContext ctx) {
        return ctx.rowKeyExp().accept(this);
    }
}
