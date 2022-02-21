package com.example.logback.domain.factory;

import com.example.logback.domain.entity.LogEntity;

public interface ILoggerPolicy {

    void save(LogEntity logEntity);


}
