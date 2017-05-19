package com.dm.stu.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class MyBaseTimer {


	@Scheduled(cron = "0/60 * * * * ?")
	public void timerCron() {
	}
}