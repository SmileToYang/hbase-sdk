package com.github.CCweixiao.example;

import com.github.CCweixiao.HBaseAdminTemplate;

/**
 * @author leojie 2021/6/9 5:54 下午
 */
public class MergeHBaseTableRegionsSample {
    public static void main(String[] args) {
        HBaseAdminTemplate adminTemplate = new HBaseAdminTemplate(args[0], args[1]);
        boolean mergeRes = adminTemplate.mergeTableSmallRegions(args[2], Integer.parseInt(args[3]), Integer.parseInt(args[4]));
        System.out.println("merge successfully or not " + mergeRes);
    }
}
