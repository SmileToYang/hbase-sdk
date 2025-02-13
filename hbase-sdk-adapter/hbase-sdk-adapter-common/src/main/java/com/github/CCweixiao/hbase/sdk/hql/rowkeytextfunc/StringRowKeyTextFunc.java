package com.github.CCweixiao.hbase.sdk.hql.rowkeytextfunc;

import com.github.CCweixiao.hbase.sdk.hql.rowkey.StringRowKey;
import com.github.CCwexiao.hbase.sdk.dsl.client.RowKey;
import com.github.CCwexiao.hbase.sdk.dsl.client.rowkeytextfunc.RowKeyTextFunc;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * @author leojie 2020/11/28 12:47 下午
 */
public class StringRowKeyTextFunc implements RowKeyTextFunc {
    @Override
    public RowKey func(String text) {
        return new StringRowKey(text);
    }

    @Override
    public RowKey convert(byte[] row) {
        return new StringRowKey(Bytes.toString(row));
    }

    @Override
    public Object reverse(RowKey rowKey) {
        byte[] bytes = rowKey.toBytes();
        return Bytes.toString(bytes);    }

    @Override
    public String funcName() {
        return RowKeyFunctionNameEnum.STRING_KEY.getFunctionName();
    }

    @Override
    public String desc() {
        return "use string as rowKey.";
    }

}
