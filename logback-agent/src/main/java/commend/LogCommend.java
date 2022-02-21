package commend;

import sun.rmi.runtime.Log;
import utils.SnowIdUtils;

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

    public void setMessage(String message) {
        this.message = message;
    }

    private String statusId;

    private String message;

    @Override
    public String toString() {
        return "LogCommend{" +
                "xid='" + xid + '\'' +
                ", name='" + name + '\'' +
                ", statusId='" + statusId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public LogCommend(){}

    public LogCommend(Object arg0, String name) {
        this.xid = SnowIdUtils.uniqueLong().toString();
        this.name = name;
        this.message = arg0.toString();
        // todo
        this.statusId = "0";
    }
}
