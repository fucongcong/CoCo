package com.clothesmake.user.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestJob {

    @Scheduled(cron = "0/5 * * * * *")
    public void test() {
        System.out.printf("task job");
    }
}