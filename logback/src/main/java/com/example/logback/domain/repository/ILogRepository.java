package com.example.logback.domain.repository;


import com.example.logback.domain.entity.LogEntity;
import org.slf4j.Logger;

public interface ILogRepository {

    void save(LogEntity logEntity, Logger logger);
}
