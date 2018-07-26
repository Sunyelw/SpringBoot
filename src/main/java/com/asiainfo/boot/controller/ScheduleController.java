package com.asiainfo.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 项目名称:   pinkstone
 * 包:        com.asiainfo.boot.controller
 * 类名称:     ScheduleController
 * 类描述:     定时执行
 * @author:     huangyang
 * 创建时间:   2018/7/25 21:05
 */
@Component
public class ScheduleController {

	@Value("${time.schedule}")
	int timeSeconds;

	private static int ONE = 1;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Scheduled(fixedRateString = "${time.schedule}")
	public void printCurrentTime(){
		System.out.println(ONE++ * timeSeconds + "");
		System.out.println(dateFormat.format(new Date()));
	}

}
