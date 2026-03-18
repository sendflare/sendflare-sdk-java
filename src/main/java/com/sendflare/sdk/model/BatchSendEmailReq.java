package com.sendflare.sdk.model;

/**
 * Batch Send Email request entity
 */
public class BatchSendEmailReq {
    private String from;
    private String to;
    private String subject;
    private String body;

    public BatchSendEmailReq() {
    }

    public BatchSendEmailReq(String from, List<String> to, String subject, String body, List<String> cc, List<String> bcc, List<String> replyTo) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.cc = cc;
        this.bcc = bcc;
        this.replyTo = replyTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public List<String> getCC() {
        return cc;
    }

    public void setCC(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getBCC() {
        return bcc;
    }

    public void setBCC(List<String> bcc) {
        this.bcc = bcc;
    }
}

