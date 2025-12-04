package io.sendflare.sdk.model;

/**
 * Delete a contact request entity
 */
public class DeleteContactReq {
    private String emailAddress;
    private String appId;

    public DeleteContactReq() {
    }

    public DeleteContactReq(String emailAddress, String appId) {
        this.emailAddress = emailAddress;
        this.appId = appId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}

