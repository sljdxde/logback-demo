package domain.factory;


import domain.entity.LogEntity;
import domain.repository.ILogRepository;
import infrastructure.repository.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultLogger implements ILoggerPolicy {

    Logger logger = LoggerFactory.getLogger(DefaultLogger.class);

    @Override
    public void save(LogEntity logEntity) {
        ILogRepository logRepository = new LogRepository();
        logRepository.save(logEntity, logger);
    }
}
