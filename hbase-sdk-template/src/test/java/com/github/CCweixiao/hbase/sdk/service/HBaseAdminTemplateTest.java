package com.github.CCweixiao.hbase.sdk.service;

import org.junit.Before;
import org.junit.Test;

/**
 * @author leojie 2022/11/4 20:52
 */
public class HBaseAdminTemplateTest extends AbstractHBaseTemplateTest {

    @Before
    public void init() {
        super.initIHBaseAdminTemplate();
    }

    @Test
    public void testListTableNames() {
        System.out.println(adminTemplate.listTableNames());
    }

    @Test
    public void testListTableDescList() {
        System.out.println(adminTemplate.listTableDesc());
    }

    @Test
    public void testCreateTable() {}
}
