package com.github.CCweixiao.hbase.sdk.common.query;

import java.util.List;

/**
 * @author leojie 2022/11/5 10:31
 */
public class ScanQueryParamsBuilder {
    private final String familyName;
    private final List<String> columnNames;
    private final String startRow;
    private final boolean inclusiveStartRow;
    private final String stopRow;
    private final boolean inclusiveStopRow;
    private final long timestamp;
    private final long minTimestamp;
    private final long maxTimestamp;
    private final int readVersions;
    private final boolean reversed;
    private final int caching;
    private final int batch;

    private final long maxResultSize;
    private final int limit;
    private final IHBaseFilter filter;
    private final boolean cacheBlocks;

    public ScanQueryParamsBuilder(Builder builder) {
        this.familyName = builder.familyName;
        this.columnNames = builder.columnNames;
        this.startRow = builder.startRow;
        this.inclusiveStartRow = builder.inclusiveStartRow;
        this.stopRow = builder.stopRow;
        this.inclusiveStopRow = builder.inclusiveStopRow;
        this.timestamp = builder.timestamp;
        this.minTimestamp = builder.minTimestamp;
        this.maxTimestamp = builder.maxTimestamp;
        this.readVersions = builder.readVersions;
        this.reversed = builder.reversed;
        this.caching = builder.caching;
        this.batch = builder.batch;
        this.maxResultSize = builder.maxResultSize;
        this.limit = builder.limit;
        this.filter = builder.filter;
        this.cacheBlocks = builder.cacheBlocks;
    }

    public static class Builder {
        private String familyName;
        private List<String> columnNames;
        private String startRow;
        private boolean inclusiveStartRow;
        private String stopRow;
        private boolean inclusiveStopRow;
        private long timestamp;
        private long minTimestamp;
        private long maxTimestamp;
        private int readVersions;
        private boolean reversed;
        private int caching;
        private int batch;

        private long maxResultSize;
        private int limit;
        private IHBaseFilter filter;
        private boolean cacheBlocks;

        public Builder() {

        }

        public Builder familyName(String familyName) {
            this.familyName = familyName;
            return this;
        }

        public Builder columnNames(List<String> columnNames) {
            this.columnNames = columnNames;
            return this;
        }

        public Builder startRow(String startRow) {
            this.startRow = startRow;
            return this;
        }

        public Builder inclusiveStartRow(boolean inclusiveStartRow) {
            this.inclusiveStartRow = inclusiveStartRow;
            return this;
        }

        public Builder stopRow(String stopRow) {
            this.stopRow = stopRow;
            return this;
        }

        public Builder inclusiveStopRow(boolean inclusiveStopRow) {
            this.inclusiveStopRow = inclusiveStopRow;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder minTimestamp(long minTimestamp) {
            this.minTimestamp = minTimestamp;
            return this;
        }

        public Builder maxTimestamp(long maxTimestamp) {
            this.maxTimestamp = maxTimestamp;
            return this;
        }

        public Builder readVersions(int readVersions) {
            this.readVersions = readVersions;
            return this;
        }

        public Builder reversed(boolean reversed) {
            this.reversed = reversed;
            return this;
        }

        public Builder caching(int caching) {
            this.caching = caching;
            return this;
        }

        public Builder batch(int batch) {
            this.batch = batch;
            return this;
        }

        public Builder limit(int limit) {
            this.limit = limit;
            return this;
        }

        public Builder maxResultSize(long maxResultSize) {
            this.maxResultSize = maxResultSize;
            return this;
        }

        public Builder filter(IHBaseFilter filter) {
            this.filter = filter;
            return this;
        }

        public Builder cacheBlocks(boolean cacheBlocks) {
            this.cacheBlocks = cacheBlocks;
            return this;
        }

        public ScanQueryParamsBuilder build() {
            return new ScanQueryParamsBuilder(this);
        }
    }

    public String getFamilyName() {
        return familyName;
    }

    public List<String> getColumnNames() {
        return columnNames;
    }

    public String getStartRow() {
        return startRow;
    }

    public boolean isInclusiveStartRow() {
        return inclusiveStartRow;
    }

    public String getStopRow() {
        return stopRow;
    }

    public boolean isInclusiveStopRow() {
        return inclusiveStopRow;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public long getMinTimestamp() {
        return minTimestamp;
    }

    public long getMaxTimestamp() {
        return maxTimestamp;
    }

    public int getReadVersions() {
        return readVersions;
    }

    public boolean isReversed() {
        return reversed;
    }

    public int getCaching() {
        if (caching <= 0) {
            return 1000;
        }
        return caching;
    }

    public int getBatch() {
        if (batch <= 0) {
            return 100;
        }
        return batch;
    }

    public long getMaxResultSize() {
        return maxResultSize;
    }

    public int getLimit() {
        if (limit <= 0) {
            return 1000;
        }
        return limit;
    }

    public IHBaseFilter getFilter() {
        return filter;
    }

    public boolean isCacheBlocks() {
        return cacheBlocks;
    }
}
