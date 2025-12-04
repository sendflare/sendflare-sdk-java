package io.sendflare.sdk.model;

/**
 * Get Contact list request entity
 */
public class ListContactReq extends PaginateReq {
    private String appId;

    public ListContactReq() {
    }

    public ListContactReq(String appId, int page, int pageSize) {
        super(page, pageSize);
        this.appId = appId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}

