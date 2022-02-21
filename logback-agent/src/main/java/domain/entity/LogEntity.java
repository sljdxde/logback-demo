package domain.entity;


import commend.LogCommend;
import domain.factory.ILoggerPolicy;

public class LogEntity {
    LogCommend logCommend;

    public LogEntity(LogCommend logCommend) {
        this.logCommend = logCommend;
    }

    public void save(ILoggerPolicy policy) {
        policy.save(this);
    }

    public String logCommendToString() {
        return logCommend.toString();
    }
}
