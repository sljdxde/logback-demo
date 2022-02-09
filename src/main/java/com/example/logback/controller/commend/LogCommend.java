package com.example.logback.controller.commend;

public class LogCommend {

    private String xid;

    private String name;

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "LogCommend{" +
                "xid='" + xid + '\'' +
                ", name='" + name + '\'' +
                ", statusId='" + statusId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String statusId;

    private String message;
}
