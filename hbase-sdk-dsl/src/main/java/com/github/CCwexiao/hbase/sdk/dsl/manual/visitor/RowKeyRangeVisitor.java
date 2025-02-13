package com.github.CCwexiao.hbase.sdk.dsl.manual.visitor;

import com.github.CCwexiao.hbase.sdk.dsl.antlr.HBaseSQLBaseVisitor;
import com.github.CCwexiao.hbase.sdk.dsl.antlr.HBaseSQLParser;
import com.github.CCwexiao.hbase.sdk.dsl.client.RowKey;
import com.github.CCwexiao.hbase.sdk.dsl.client.rowkey.RowKeyUtil;
import com.github.CCwexiao.hbase.sdk.dsl.config.HBaseSQLRuntimeSetting;
import com.github.CCwexiao.hbase.sdk.dsl.manual.HBaseSQLContextUtil;
import com.github.CCwexiao.hbase.sdk.dsl.manual.RowKeyRange;

import java.util.List;

/**
 * @author leojie 2020/11/28 11:00 上午
 */
public class RowKeyRangeVisitor extends HBaseSQLBaseVisitor<RowKeyRange> {
    private final HBaseSQLRuntimeSetting runtimeSetting;

    public RowKeyRangeVisitor(HBaseSQLRuntimeSetting runtimeSetting) {
        this.runtimeSetting = runtimeSetting;
    }

    @Override
    public RowKeyRange visitRowkeyrange_start(HBaseSQLParser.Rowkeyrange_startContext startContext) {
        RowKeyRange rowKeyRange = new RowKeyRange();

        rowKeyRange.setStart(HBaseSQLContextUtil.parseRowKey(startContext.rowKeyExp(), runtimeSetting));
        rowKeyRange.setEnd(RowKeyUtil.END_ROW);
        rowKeyRange.setRowKeyFunc(HBaseSQLContextUtil.parseRowKeyFunction(startContext.rowKeyExp(), runtimeSetting));

        return rowKeyRange;
    }

    @Override
    public RowKeyRange visitRowkeyrange_end(HBaseSQLParser.Rowkeyrange_endContext endContext) {
        RowKeyRange rowKeyRange = new RowKeyRange();

        rowKeyRange.setStart(RowKeyUtil.START_ROW);
        rowKeyRange.setEnd(HBaseSQLContextUtil.parseRowKey(endContext.rowKeyExp(), runtimeSetting));
        rowKeyRange.setRowKeyFunc(HBaseSQLContextUtil.parseRowKeyFunction(endContext.rowKeyExp(), runtimeSetting));

        return rowKeyRange;
    }

    @Override
    public RowKeyRange visitRowkeyrange_startAndEnd(HBaseSQLParser.Rowkeyrange_startAndEndContext startAndEndContext) {
        RowKeyRange rowKeyRange = new RowKeyRange();

        rowKeyRange.setStart(HBaseSQLContextUtil.parseRowKey(startAndEndContext.rowKeyExp(0), runtimeSetting));
        rowKeyRange.setEnd(HBaseSQLContextUtil.parseRowKey(startAndEndContext.rowKeyExp(1), runtimeSetting));
        rowKeyRange.setRowKeyFunc(HBaseSQLContextUtil.parseRowKeyFunction(startAndEndContext.rowKeyExp(0), runtimeSetting));

        return rowKeyRange;
    }

    @Override
    public RowKeyRange visitRowkeyrange_onerowkey(HBaseSQLParser.Rowkeyrange_onerowkeyContext onerowkeyContext) {
        RowKeyRange rowKeyRange = new RowKeyRange();
        RowKey rowKey = HBaseSQLContextUtil.parseRowKey(onerowkeyContext.rowKeyExp(), runtimeSetting);
        rowKeyRange.setStart(rowKey);
        rowKeyRange.setEnd(rowKey);
        rowKeyRange.setRowKeyFunc(HBaseSQLContextUtil.parseRowKeyFunction(onerowkeyContext.rowKeyExp(), runtimeSetting));

        return rowKeyRange;
    }

    @Override
    public RowKeyRange visitRowkeyrange_insomekeys(HBaseSQLParser.Rowkeyrange_insomekeysContext insomekeysContext) {
        RowKeyRange rowKeyRange = new RowKeyRange();
        final List<RowKey> rowKeys = HBaseSQLContextUtil.parseRowKeyList(insomekeysContext.rowKeyExp(), runtimeSetting);
        rowKeyRange.setRowKeyFunc(HBaseSQLContextUtil.parseRowKeyFunction(insomekeysContext.rowKeyExp(), runtimeSetting));
        rowKeyRange.setContainsSomeKeys(rowKeys);
        rowKeyRange.setStart(null);
        rowKeyRange.setEnd(null);
        return rowKeyRange;
    }
}
