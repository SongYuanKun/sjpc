package com.syk.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TimeLineTest {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		TimeLineService timeLineService = (TimeLineService) context.getBean("timeLineService");
		timeLineService.getPublicTimeLine();
	}
}
