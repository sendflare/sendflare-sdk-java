package io.sendflare.sdk.model;

import java.util.List;

/**
 * Get Contact list response entity
 */
public class ListContactResp extends PaginateResp {
    private List<ContactItem> data;

    public ListContactResp() {
    }

    public List<ContactItem> getData() {
        return data;
    }

    public void setData(List<ContactItem> data) {
        this.data = data;
    }
}

