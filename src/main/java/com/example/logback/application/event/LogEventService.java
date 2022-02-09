package com.example.logback.application.event;

import com.example.logback.controller.commend.LogCommend;
import com.example.logback.domain.event.LogEvent;
import com.example.logback.domain.factory.ILoggerPolicy;
import com.example.logback.domain.factory.LoggerPolicyContext;
import org.springframework.stereotype.Service;

@Service
public class LogEventService extends BaseEventService<LogCommend> {

    /**
     * 模拟消息发送成功后得到反馈
     * @param logCommend
     */
    public void save(LogCommend logCommend) {
        ILoggerPolicy policy = LoggerPolicyContext.getPolicy(logCommend);
        LogEvent logEvent = new LogEvent(this, logCommend, policy);
        super.applicationEventPublisher.publishEvent(logEvent);
    }

}
