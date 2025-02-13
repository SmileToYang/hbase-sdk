package com.github.CCweixiao.hbase.sdk.hql.filter;

import com.github.CCweixiao.hbase.sdk.common.exception.HBaseOperationsException;
import com.github.CCweixiao.hbase.sdk.common.util.ObjUtil;
import com.github.CCwexiao.hbase.sdk.dsl.antlr.HBaseSQLBaseVisitor;
import com.github.CCwexiao.hbase.sdk.dsl.antlr.HBaseSQLParser;
import com.github.CCwexiao.hbase.sdk.dsl.antlr.HBaseSQLParser.*;
import com.github.CCwexiao.hbase.sdk.dsl.config.HBaseColumnSchema;
import com.github.CCwexiao.hbase.sdk.dsl.config.HBaseSQLRuntimeSetting;
import com.github.CCwexiao.hbase.sdk.dsl.config.HBaseTableConfig;
import com.github.CCwexiao.hbase.sdk.dsl.manual.HBaseSQLContextUtil;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author leojie 2020/11/28 2:34 下午
 */
public class FilterVisitor extends HBaseSQLBaseVisitor<Filter> {
    private HBaseTableConfig hBaseTableConfig;
    private Map<String, Object> para;
    private HBaseSQLRuntimeSetting runtimeSetting;

    public FilterVisitor(HBaseTableConfig hBaseTableConfig,
                         Map<String, Object> para, HBaseSQLRuntimeSetting runtimeSetting) {
        this.hBaseTableConfig = hBaseTableConfig;
        this.para = para;
        this.runtimeSetting = runtimeSetting;
    }

    @Override
    public Filter visitOrcondition(HBaseSQLParser.OrconditionContext ctx) {
        final List<ConditioncContext> conditioncContextList = ctx.conditionc();

        List<Filter> filters = new ArrayList<>();
        for (ConditioncContext conditioncContext : conditioncContextList) {
            filters.add(conditioncContext.accept(this));
        }

        return new FilterList(FilterList.Operator.MUST_PASS_ONE, filters);
    }

    @Override
    public Filter visitAndcondition(AndconditionContext ctx) {
        final List<ConditioncContext> conditioncContextList = ctx.conditionc();

        List<Filter> filters = new ArrayList<>();
        for (ConditioncContext conditioncContext : conditioncContextList) {
            filters.add(conditioncContext.accept(this));
        }

        return new FilterList(FilterList.Operator.MUST_PASS_ALL, filters);
    }

    @Override
    public Filter visitConditionwrapper(ConditionwrapperContext ctx) {
        return ctx.conditionc().accept(this);
    }

    @Override
    public Filter visitEqualvar(EqualvarContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();
        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil.parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        Object object = HBaseSQLContextUtil.parsePara(varContext, para);

        return constructFilter(hbaseColumnSchema, CompareFilter.CompareOp.EQUAL, object);
    }

    @Override
    public Filter visitEqualconstant(EqualconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        final ConstantContext constantContext = ctx.constant();
        final HBaseColumnSchema hBaseColumnSchema = HBaseSQLContextUtil.parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        final Object obj = HBaseSQLContextUtil.parseConstant(hBaseColumnSchema, constantContext, runtimeSetting);
        return constructFilter(hBaseColumnSchema, CompareFilter.CompareOp.EQUAL, obj);
    }

    @Override
    public Filter visitIsnullc(IsnullcContext ctx) {
        CidContext cidContext = ctx.cid();
        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        return constructFilter(hbaseColumnSchema, CompareFilter.CompareOp.EQUAL,
                new byte[0], true);
    }

    @Override
    public Filter visitIsnotnullc(IsnotnullcContext ctx) {
        CidContext cidContext = ctx.cid();
        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        return constructFilter(hbaseColumnSchema, CompareFilter.CompareOp.NOT_EQUAL,
                new byte[0], true);
    }

    @Override
    public Filter visitNotequalconstant(NotequalconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        ConstantContext constantContext = ctx.constant();

        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        Object object = HBaseSQLContextUtil.parseConstant(hbaseColumnSchema,
                constantContext, runtimeSetting);

        return constructFilter(hbaseColumnSchema, CompareFilter.CompareOp.NOT_EQUAL, object);
    }

    @Override
    public Filter visitNotequalvar(NotequalvarContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();
        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        Object object = HBaseSQLContextUtil.parsePara(varContext, para);

        return constructFilter(hbaseColumnSchema, CompareFilter.CompareOp.NOT_EQUAL, object);
    }

    @Override
    public Filter visitLessvar(LessvarContext ctx) {

        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        Object object = HBaseSQLContextUtil.parsePara(varContext, para);

        return constructFilter(hbaseColumnSchema, CompareFilter.CompareOp.LESS, object);
    }

    @Override
    public Filter visitLessconstant(LessconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        ConstantContext constantContext = ctx.constant();

        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        Object object = HBaseSQLContextUtil.parseConstant(hbaseColumnSchema,
                constantContext, runtimeSetting);

        return constructFilter(hbaseColumnSchema, CompareFilter.CompareOp.LESS, object);

    }

    @Override
    public Filter visitLessequalconstant(LessequalconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        ConstantContext constantContext = ctx.constant();

        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        Object object = HBaseSQLContextUtil.parseConstant(hbaseColumnSchema,
                constantContext, runtimeSetting);

        return constructFilter(hbaseColumnSchema, CompareFilter.CompareOp.LESS_OR_EQUAL,
                object);
    }

    @Override
    public Filter visitLessequalvar(LessequalvarContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        Object object = HBaseSQLContextUtil.parsePara(varContext, para);
        return constructFilter(hbaseColumnSchema, CompareFilter.CompareOp.LESS_OR_EQUAL, object);
    }

    @Override
    public Filter visitGreaterconstant(GreaterconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        ConstantContext constantContext = ctx.constant();

        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        Object object = HBaseSQLContextUtil.parseConstant(hbaseColumnSchema,
                constantContext, runtimeSetting);

        return constructFilter(hbaseColumnSchema, CompareFilter.CompareOp.GREATER, object);
    }

    @Override
    public Filter visitGreatervar(GreatervarContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        Object object = HBaseSQLContextUtil.parsePara(varContext, para);
        return constructFilter(hbaseColumnSchema, CompareFilter.CompareOp.GREATER, object);
    }


    @Override
    public Filter visitGreaterequalvar(GreaterequalvarContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        Object object = HBaseSQLContextUtil.parsePara(varContext, para);
        return constructFilter(hbaseColumnSchema, CompareFilter.CompareOp.GREATER_OR_EQUAL,
                object);
    }

    @Override
    public Filter visitGreaterequalconstant(GreaterequalconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        ConstantContext constantContext = ctx.constant();

        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        Object object = HBaseSQLContextUtil.parseConstant(hbaseColumnSchema,
                constantContext, runtimeSetting);

        return constructFilter(hbaseColumnSchema, CompareFilter.CompareOp.GREATER_OR_EQUAL,
                object);
    }


    @Override
    public Filter visitIsnotmissingc(IsnotmissingcContext ctx) {
        CidContext cidContext = ctx.cid();
        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        return constructFilter(hbaseColumnSchema, CompareFilter.CompareOp.GREATER_OR_EQUAL,
                new byte[0], true);
    }

    @Override
    public Filter visitIsmissingc(IsmissingcContext ctx) {
        CidContext cidContext = ctx.cid();
        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        return constructFilter(hbaseColumnSchema, CompareFilter.CompareOp.LESS,
                new byte[0], false);
    }

    private static Filter constructFilter(HBaseColumnSchema hBaseColumnSchema,
                                          CompareFilter.CompareOp compareOp, Object object) {
        ObjUtil.checkIsNull(hBaseColumnSchema);

        byte[] value = hBaseColumnSchema.getTypeHandler().toBytes(hBaseColumnSchema.getType(), object);
        return constructFilter(hBaseColumnSchema, compareOp, value, true);
    }

    private static Filter constructFilter(HBaseColumnSchema hBaseColumnSchema,
                                          CompareFilter.CompareOp compareOp,
                                          byte[] value,
                                          boolean filterIfMissing) {
        ObjUtil.checkIsNull(hBaseColumnSchema);
        ObjUtil.checkIsNull(compareOp);
        ObjUtil.checkIsNull(value);

        byte[] familyBytes = Bytes.toBytes(hBaseColumnSchema.getFamily());
        byte[] qualifierBytes = Bytes.toBytes(hBaseColumnSchema.getQualifier());


        SingleColumnValueFilter singleColumnValueFilter = new SingleColumnValueFilter(
                familyBytes, qualifierBytes, compareOp, value);
        singleColumnValueFilter.setFilterIfMissing(filterIfMissing);
        return singleColumnValueFilter;
    }


    @Override
    public Filter visitNotmatchconstant(NotmatchconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        ConstantContext constantContext = ctx.constant();

        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        Object object = HBaseSQLContextUtil.parseConstant(hbaseColumnSchema,
                constantContext, runtimeSetting);

        return constructFilterWithRegex(hbaseColumnSchema, CompareFilter.CompareOp.NOT_EQUAL,
                object);
    }

    @Override
    public Filter visitNotmatchvar(NotmatchvarContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        Object object = HBaseSQLContextUtil.parsePara(varContext, para);

        return constructFilterWithRegex(hbaseColumnSchema, CompareFilter.CompareOp.NOT_EQUAL,
                object);
    }

    @Override
    public Filter visitMatchvar(MatchvarContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        Object object = HBaseSQLContextUtil.parsePara(varContext, para);

        return constructFilterWithRegex(hbaseColumnSchema, CompareFilter.CompareOp.EQUAL,
                object);
    }

    @Override
    public Filter visitMatchconstant(MatchconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        ConstantContext constantContext = ctx.constant();

        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        Object object = HBaseSQLContextUtil.parseConstant(hbaseColumnSchema,
                constantContext, runtimeSetting);

        return constructFilterWithRegex(hbaseColumnSchema, CompareFilter.CompareOp.EQUAL,
                object);
    }

    private static Filter constructFilterWithRegex(
            HBaseColumnSchema hbaseColumnSchema, CompareFilter.CompareOp compareOp,
            Object object) {
        ObjUtil.checkIsNull(hbaseColumnSchema);
        ObjUtil.checkIsNull(compareOp);
        ObjUtil.checkIsNull(object);

        if (compareOp != CompareFilter.CompareOp.EQUAL && compareOp != CompareFilter.CompareOp.NOT_EQUAL) {
            throw new HBaseOperationsException("only EQUAL or NOT_EQUAL can use regex match. compareOp = "
                    + compareOp);
        }
        if (object.getClass() != String.class) {
            throw new HBaseOperationsException("only string can use regex match. object = " + object);
        }
        if (hbaseColumnSchema.getType() != String.class) {
            throw new HBaseOperationsException("only string can use regex match. hbaseColumnSchema = "
                    + hbaseColumnSchema);
        }

        byte[] familyBytes = Bytes.toBytes(hbaseColumnSchema.getFamily());
        byte[] qualifierBytes = Bytes.toBytes(hbaseColumnSchema.getQualifier());

        RegexStringComparator regexStringComparator = new RegexStringComparator(
                (String) object);

        SingleColumnValueFilter singleColumnValueFilter = new SingleColumnValueFilter(
                familyBytes, qualifierBytes, compareOp, regexStringComparator);
        singleColumnValueFilter.setFilterIfMissing(true);

        return singleColumnValueFilter;
    }

    @Override
    public Filter visitNotinconstantlist(NotinconstantlistContext ctx) {
        CidContext cidContext = ctx.cid();
        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);

        ConstantListContext constantListContext = ctx.constantList();
        List<ConstantContext> constantContextList = constantListContext
                .constant();
        List<Object> list = HBaseSQLContextUtil.parseConstantList(hbaseColumnSchema,
                constantContextList, runtimeSetting);

        return constructFilterForContain(hbaseColumnSchema,
                CompareFilter.CompareOp.NOT_EQUAL, list, FilterList.Operator.MUST_PASS_ALL);
    }

    @Override
    public Filter visitNotinvarlist(NotinvarlistContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        Object object = HBaseSQLContextUtil.parsePara(varContext, para);

        return constructFilterForContain(hbaseColumnSchema,
                CompareFilter.CompareOp.NOT_EQUAL, (List<Object>) object,
                FilterList.Operator.MUST_PASS_ALL);
    }

    @Override
    public Filter visitInvarlist(InvarlistContext ctx) {
        CidContext cidContext = ctx.cid();
        VarContext varContext = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        Object object = HBaseSQLContextUtil.parsePara(varContext, para);

        return constructFilterForContain(hbaseColumnSchema, CompareFilter.CompareOp.EQUAL,
                (List<Object>) object, FilterList.Operator.MUST_PASS_ONE);
    }

    @Override
    public Filter visitInconstantlist(InconstantlistContext ctx) {
        CidContext cidContext = ctx.cid();
        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);

        ConstantListContext constantListContext = ctx.constantList();
        List<ConstantContext> constantContextList = constantListContext
                .constant();
        List<Object> list = HBaseSQLContextUtil.parseConstantList(hbaseColumnSchema, constantContextList, runtimeSetting);

        return constructFilterForContain(hbaseColumnSchema, CompareFilter.CompareOp.EQUAL,
                list, FilterList.Operator.MUST_PASS_ONE);
    }

    private static Filter constructFilterForContain(
            HBaseColumnSchema hbaseColumnSchema, CompareFilter.CompareOp compareOp,
            List<Object> list, FilterList.Operator operator) {
        ObjUtil.checkIsNull(hbaseColumnSchema);
        ObjUtil.checkIsNull(compareOp);
        ObjUtil.checkIsNull(list);
        ObjUtil.checkIsNull(operator);

        List<Filter> filters = new ArrayList<>();
        for (Object obj : list) {
            filters.add(constructFilter(hbaseColumnSchema, compareOp, obj));
        }

        return new FilterList(operator, filters);
    }

    @Override
    public Filter visitNotbetweenconstant(NotbetweenconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);

        List<ConstantContext> constantContextList = ctx.constant();

        List<Object> list = HBaseSQLContextUtil.parseConstantList(hbaseColumnSchema,
                constantContextList, runtimeSetting);

        Filter startFilter = constructFilter(hbaseColumnSchema, CompareFilter.CompareOp.LESS,
                list.get(0));
        Filter endFilter = constructFilter(hbaseColumnSchema,
                CompareFilter.CompareOp.GREATER, list.get(1));

        return new FilterList(FilterList.Operator.MUST_PASS_ONE, Arrays.asList(startFilter, endFilter));
    }

    @Override
    public Filter visitNotbetweenvar(NotbetweenvarContext ctx) {
        CidContext cidContext = ctx.cid();
        List<VarContext> varContextList = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        List<Object> list = HBaseSQLContextUtil.parseParaList(varContextList, para);

        Filter startFilter = constructFilter(hbaseColumnSchema, CompareFilter.CompareOp.LESS,
                list.get(0));
        Filter endFilter = constructFilter(hbaseColumnSchema,
                CompareFilter.CompareOp.GREATER, list.get(1));

        return new FilterList(FilterList.Operator.MUST_PASS_ONE, Arrays.asList(startFilter, endFilter));
    }

    @Override
    public Filter visitBetweenvar(BetweenvarContext ctx) {
        CidContext cidContext = ctx.cid();
        List<VarContext> varContextList = ctx.var();

        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);
        List<Object> list = HBaseSQLContextUtil.parseParaList(varContextList, para);

        Filter startFilter = constructFilter(hbaseColumnSchema,
                CompareFilter.CompareOp.GREATER_OR_EQUAL, list.get(0));
        Filter endFilter = constructFilter(hbaseColumnSchema,
                CompareFilter.CompareOp.LESS_OR_EQUAL, list.get(1));

        return new FilterList(FilterList.Operator.MUST_PASS_ALL, Arrays.asList(startFilter, endFilter));
    }

    @Override
    public Filter visitBetweenconstant(BetweenconstantContext ctx) {
        CidContext cidContext = ctx.cid();
        HBaseColumnSchema hbaseColumnSchema = HBaseSQLContextUtil
                .parseHBaseColumnSchema(hBaseTableConfig, cidContext);

        List<ConstantContext> constantContextList = ctx.constant();

        List<Object> list = HBaseSQLContextUtil.parseConstantList(hbaseColumnSchema,
                constantContextList, runtimeSetting);

        Filter startFilter = constructFilter(hbaseColumnSchema,
                CompareFilter.CompareOp.GREATER_OR_EQUAL, list.get(0));
        Filter endFilter = constructFilter(hbaseColumnSchema,
                CompareFilter.CompareOp.LESS_OR_EQUAL, list.get(1));

        return new FilterList(FilterList.Operator.MUST_PASS_ALL, Arrays.asList(startFilter, endFilter));
    }

}
