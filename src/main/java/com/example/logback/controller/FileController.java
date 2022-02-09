package com.example.logback.controller;

import com.example.logback.application.event.LogEventService;
import com.example.logback.application.service.LogService;
import com.example.logback.controller.commend.LogCommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    LogService logService;
    @Autowired
    LogEventService logEventService;

    @PostMapping("/logSave")
    public void logSave(@RequestBody LogCommend logCommend) {
        logService.save(logCommend);
    }

    @PostMapping("/logEventSave")
    public void logEventSave(@RequestBody LogCommend logCommend) {
        logEventService.save(logCommend);
    }
}
