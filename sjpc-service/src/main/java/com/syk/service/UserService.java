package com.syk.service;

import java.util.List;

import com.syk.util.Pager;

import weibo4j.model.User;

public interface UserService {
	public int getTotleNum();

	public List<User> newlyList();

	public List<User> haveLocationUser();

	public Pager<User> serchUserByPager(Pager<User> up);
	
	public User getUser(String id);
}
