package io.sendflare.sdk.model;

import java.util.List;

/**
 * Get Contact list response entity
 */
public class ListContactResp extends PaginateResp {
    private List<Map<String, String>> list;

    public ListContactResp() {
    }

    public List<Map<String, String>> getList() {
        return list;
    }

    public void setList(List<Map<String, String>> list) {
        this.list = list;
    }
}

