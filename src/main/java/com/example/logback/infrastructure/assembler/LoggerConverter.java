package com.example.logback.infrastructure.assembler;

import com.example.logback.domain.entity.LogEntity;

public class LoggerConverter {

    public String logEntityToString(LogEntity logEntity) {
        return logEntity.logCommendToString();
    }
}
