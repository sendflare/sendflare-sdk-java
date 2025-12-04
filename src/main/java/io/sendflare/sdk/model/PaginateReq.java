package io.sendflare.sdk.model;

/**
 * Pagination request entity
 */
public class PaginateReq {
    private int page;
    private int pageSize;

    public PaginateReq() {
    }

    public PaginateReq(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
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
}

