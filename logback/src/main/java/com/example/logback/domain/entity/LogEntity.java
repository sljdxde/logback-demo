package com.example.logback.domain.entity;

import com.example.logback.controller.commend.LogCommend;
import com.example.logback.domain.factory.ILoggerPolicy;

public class LogEntity {
    LogCommend logCommend;

    public LogEntity(LogCommend logCommend) {
        this.logCommend = logCommend;
    }

    public void save(ILoggerPolicy policy) {
        policy.save(this);
    }

    public String logCommendToString() {
        return logCommend.toString();
    }
}
