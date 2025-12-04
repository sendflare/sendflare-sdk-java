package io.sendflare.sdk.model;

/**
 * Pagination response entity
 */
public class PaginateResp {
    private int page;
    private int pageSize;
    private long totalCount;

    public PaginateResp() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}

