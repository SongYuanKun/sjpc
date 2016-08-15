package com.syk.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.syk.util.Pager;

import weibo4j.model.Status;

@Service
public interface SearchService {

	Pager<Status> searchList(Map<String, Object> map, Pager<Status> pager);
	
	
}
