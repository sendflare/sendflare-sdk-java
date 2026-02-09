package com.sendflare.sdk.model;

import java.util.List;
import java.util.Map;

/**
 * Get Contact list response entity
 */
public class ListContactResp {
    // CommonResponse fields
    private String requestId;
    private int code;
    private boolean success;
    private String message;
    private long ts;
    
    // Data wrapper with pagination and list
    private ContactListData data;

    public ListContactResp() {
    }

    // CommonResponse getters and setters
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    // Data getter and setter
    public ContactListData getData() {
        return data;
    }

    public void setData(ContactListData data) {
        this.data = data;
    }

    /**
     * Nested data structure containing pagination and contact list
     */
    public static class ContactListData {
        // PaginateResp fields
        private int page;
        private int pageSize;
        private long totalCount;
        
        // Contact list
        private List<Map<String, String>> list;

        public ContactListData() {
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

        public List<Map<String, String>> getList() {
            return list;
        }

        public void setList(List<Map<String, String>> list) {
            this.list = list;
        }
    }
}

