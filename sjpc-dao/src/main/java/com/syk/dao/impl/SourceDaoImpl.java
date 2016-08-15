package com.syk.dao.impl;

import org.springframework.stereotype.Repository;

import com.syk.dao.SourceDao;

import weibo4j.model.Source;

@Repository("sourceDao")
public class SourceDaoImpl extends BaseDaoImpl<Source> implements SourceDao {

}
