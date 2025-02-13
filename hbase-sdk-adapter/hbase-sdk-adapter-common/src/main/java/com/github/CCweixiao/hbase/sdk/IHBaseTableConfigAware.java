 package com.github.CCweixiao.hbase.sdk;

import com.github.CCwexiao.hbase.sdk.dsl.config.HBaseTableConfig;

/**
 * @author leojie 2020/11/28 9:05 下午
 */
public interface IHBaseTableConfigAware {
    /**
     * 获取HBaseTableConfig对象
     *
     * @return HBaseTableConfig
     */
    HBaseTableConfig getHBaseTableConfig();

    /**
     * 设置HBaseTableConfig对象
     *
     * @param hbaseTableConfig HBaseTableConfig对象
     */
    void setHBaseTableConfig(HBaseTableConfig hbaseTableConfig);
}
