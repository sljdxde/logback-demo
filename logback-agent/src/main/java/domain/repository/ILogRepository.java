package domain.repository;


import domain.entity.LogEntity;
import org.slf4j.Logger;

public interface ILogRepository {

    void save(LogEntity logEntity, Logger logger);
}
