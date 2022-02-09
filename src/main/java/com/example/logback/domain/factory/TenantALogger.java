package com.example.logback.domain.factory;

import com.example.logback.domain.entity.LogEntity;
import com.example.logback.domain.repository.ILogRepository;
import com.example.logback.infrastructure.repository.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TenantALogger implements ILoggerPolicy {

    Logger logger = LoggerFactory.getLogger(TenantALogger.class);

    @Override
    public void save(LogEntity logEntity) {
        ILogRepository logRepository = new LogRepository();
        logRepository.save(logEntity, logger);
    }
}
