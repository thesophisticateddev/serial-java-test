package com.example.serialtest;

import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class TestService {

    @Inject
    private LogRecordService logRecordService;

    @Scheduled(fixedDelay = "10s")
    public void schedService(){
        System.out.println("Cron service here");
        System.out.println("Data: ----" + logRecordService.get());

    }
}
