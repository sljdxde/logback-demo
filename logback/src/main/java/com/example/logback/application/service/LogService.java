package com.example.logback.application.service;

import com.example.logback.controller.commend.LogCommend;
import com.example.logback.domain.entity.LogEntity;
import com.example.logback.domain.factory.ILoggerPolicy;
import com.example.logback.domain.factory.LoggerPolicyContext;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    public void save(LogCommend logCommend) {
        LogEntity logEntity = new LogEntity(logCommend);
        ILoggerPolicy policy = LoggerPolicyContext.getPolicy(logCommend);
        logEntity.save(policy);
    }
}
