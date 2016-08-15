package com.syk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.syk.service.StartService;
import com.syk.service.TimeLineService;

@Component
public class StartServiceImpl implements StartService {
	@Autowired
	@Qualifier("timeLineService")
	private TimeLineService timeLineService;

	@Override
	public void startSearch() {
		int a = (int) (Math.random() * 10);
		for (int i = 0; i < a * a * 1000 + a * 10; i++) {
		}
		timeLineService.getPublicTimeLine();
	}
}
