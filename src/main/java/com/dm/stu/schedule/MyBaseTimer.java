package com.dm.stu.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.dm.stu.enums.IDType;
import com.dm.stu.service.SerialNumberService;

@Configuration
@EnableScheduling
public class MyBaseTimer {

	@Autowired
	SerialNumberService serialNumberService;

	@Scheduled(cron = "0/60 * * * * ?")
	public void timerCron() {
		System.out.println(serialNumberService.init(IDType.USER));
	}
}