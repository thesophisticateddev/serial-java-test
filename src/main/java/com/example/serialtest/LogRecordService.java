package com.example.serialtest;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@Singleton
public class LogRecordService {
//    @Inject
    private final LogRecordRepository logRecordRepository;

    public LogRecordService(LogRecordRepository logRecordRepository){
        this.logRecordRepository = logRecordRepository;
    }

    public void save(String log){
        LogRecord rec = new LogRecord();
        rec.setLog(log);
        rec.setCreatedAt(LocalDateTime.now());
        logRecordRepository.save(rec);
        System.out.println("Saved");
    }

    public String get(){
        return "Gets some data";
    }


}
