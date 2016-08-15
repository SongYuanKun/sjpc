package com.syk.dao.impl;

import org.springframework.stereotype.Repository;

import com.syk.dao.UserDao;

import weibo4j.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}
