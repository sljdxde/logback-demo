package infrastructure.repository;


import domain.entity.LogEntity;
import domain.repository.ILogRepository;
import org.slf4j.Logger;

public class LogRepository implements ILogRepository {

    @Override
    public void save(LogEntity logEntity, Logger logger) {
        logger.warn(logEntity.logCommendToString());
    }
}
