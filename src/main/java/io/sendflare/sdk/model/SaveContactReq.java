package io.sendflare.sdk.model;

import java.util.Map;

/**
 * Save contact request entity
 */
public class SaveContactReq {
    private String appId;
    private String emailAddress;
    private Map<String, String> data;

    public SaveContactReq() {
    }

    public SaveContactReq(String appId, String emailAddress, Map<String, String> data) {
        this.appId = appId;
        this.emailAddress = emailAddress;
        this.data = data;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}

