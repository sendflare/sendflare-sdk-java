package com.sendflare.sdk.model;

import java.util.List;

/**
 * Send Email request entity
 */
public class SendEmailReq {
    private String from;
    private String to;
    private String subject;
    private String body;
    private List<String> cc;
    private List<String> bcc;
    private List<String> replyTo;

    public SendEmailReq() {
    }

    public SendEmailReq(String from, String to, String subject, String body, List<String> cc, List<String> bcc, List<String> replyTo) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.cc = cc;
        this.bcc = bcc;
        this.replyTo = replyTo;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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

    public List<String> getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(List<String> replyTo) {
        this.replyTo = replyTo;
    }
}

