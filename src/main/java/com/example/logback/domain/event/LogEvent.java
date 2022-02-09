package com.example.logback.domain.event;

import com.example.logback.controller.commend.LogCommend;
import com.example.logback.domain.entity.LogEntity;
import com.example.logback.domain.factory.ILoggerPolicy;
import org.springframework.context.ApplicationEvent;

public class LogEvent extends ApplicationEvent {
    private final LogCommend logCommend;
    private final ILoggerPolicy policy;

    public LogEvent(Object source, LogCommend logCommend, ILoggerPolicy policy) {
        super(source);
        this.logCommend = logCommend;
        this.policy = policy;
    }

    public void save() {
        System.out.println("Save event...");
        policy.save(new LogEntity(this.logCommend));
    }
}
