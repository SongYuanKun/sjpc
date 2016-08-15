package com.syk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.syk.dao.UserDao;
import com.syk.service.UserService;
import com.syk.util.Pager;

import weibo4j.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

	@Override
	public int getTotleNum() {
		return userDao.list("from User").size();
	}

	public List<User> newlyList() {
		return userDao.list("from User u order by u.id").subList(0, 10);
	}

	@Override
	public List<User> haveLocationUser() {
		return userDao.list("from User u where u.location is not null");
	}

	@Override
	public Pager<User> serchUserByPager(Pager<User> up) {
		return userDao.query("from User", up);
	}

	@Override
	public User getUser(String id) {
		return userDao.get(id);
	}

}
