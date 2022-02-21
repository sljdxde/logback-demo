package com.example.logback.domain.event.listener;

import com.example.logback.domain.event.LogEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LogEventListener implements ApplicationListener<LogEvent> {
    @Override
    public void onApplicationEvent(LogEvent event) {
        System.out.println(this.getClass().getName() + " on event listener...");
        event.save();
    }
}
