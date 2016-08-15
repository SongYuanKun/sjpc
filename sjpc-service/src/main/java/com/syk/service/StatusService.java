package com.syk.service;

import java.util.List;

import com.syk.util.Pager;

import weibo4j.model.Status;

public interface StatusService {
	public int getTotleNum();

	public List<Status> newlyList();

	public List<Status> haveGeoStatus();
	
	public Pager<Status> pagerListByUser(String uid,Pager<Status> pager);
}
