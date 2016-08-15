package com.syk.dao.impl;

import org.springframework.stereotype.Repository;

import com.syk.dao.VisibleDao;

import weibo4j.model.Visible;

@Repository("visibleDao")
public class VisibleDaoImpl extends BaseDaoImpl<Visible> implements VisibleDao {

}
