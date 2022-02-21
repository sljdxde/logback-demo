package com.example.logback.application.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseEventService<T> {
    @Autowired
    protected ApplicationEventPublisher applicationEventPublisher;

    abstract void save(T t);
}
