package com.syk.dao.impl;

import org.springframework.stereotype.Repository;

import com.syk.dao.StatusDao;

import weibo4j.model.Status;

@Repository("statusDao")
public class StatusDaoImpl extends BaseDaoImpl<Status> implements StatusDao{

}
