package com.syk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.syk.dao.StatusDao;
import com.syk.service.StatusService;
import com.syk.util.Pager;

import weibo4j.model.Status;

@Service("statusService")
public class StatusServiceImpl implements StatusService {

	@Autowired
	@Qualifier("statusDao")
	private StatusDao statusDao;

	@Override
	public int getTotleNum() {
		return statusDao.list("from Status").size();
	}

	@Override
	public List<Status> newlyList() {
		List<Status> status = statusDao.list("from Status s order by s.createdAt desc").subList(0, 10);
		for (Status s : status) {
			System.out.println(s);
		}

		return status;
	}

	@Override
	public List<Status> haveGeoStatus() {
		return statusDao.list("from Status s where s.geoName is not null");

	}

	@Override
	public Pager<Status> pagerListByUser(String uid, Pager<Status> pager) {
		return statusDao.query("from Status s left join fetch s.source where s.userId="+uid, pager);
	}

	

}
