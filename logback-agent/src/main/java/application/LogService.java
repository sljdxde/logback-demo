package application;

import commend.LogCommend;
import domain.entity.LogEntity;
import domain.factory.ILoggerPolicy;
import domain.factory.LoggerPolicyContext;

public class LogService {

    public void save(LogCommend logCommend) {
        LogEntity logEntity = new LogEntity(logCommend);
        ILoggerPolicy policy = LoggerPolicyContext.getPolicy(logCommend);
        logEntity.save(policy);
    }
}
