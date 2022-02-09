package com.example.logback.infrastructure.repository;

import com.example.logback.domain.entity.LogEntity;
import com.example.logback.domain.repository.ILogRepository;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LogRepository implements ILogRepository {

    @Override
    public void save(LogEntity logEntity, Logger logger) {
        logger.warn(logEntity.logCommendToString());
    }
}
