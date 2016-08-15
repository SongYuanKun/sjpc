package com.syk.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.syk.dao.StatusDao;
import com.syk.service.SearchService;
import com.syk.util.Pager;

import weibo4j.model.Status;

@Service
public class SearchServiceImpl implements SearchService {
	@Autowired
	@Qualifier("statusDao")
	private StatusDao statusDao;
	
	@Override
	public Pager<Status> searchList(Map<String, Object> map,Pager<Status> pager) {
		String text = (String) map.get("text");
		String startDate = (String) map.get("start");
		String endDate = (String) map.get("end");
	    String hql = "from Status s where 1 = 1";
	   if(StringUtils.isNotBlank(text)){
		   hql+=" and s.text like :text";
		   map.put("text", "%"+text+"%");
	   }
	   if(StringUtils.isNotBlank(startDate)){
		   hql+=" and s.startDate >= :startDate";
		   try {
			map.put("startDate", new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	   }
	   if(StringUtils.isNotBlank(endDate)){
		   hql+=" and s.endDate <= :endDate";
		   try {
			map.put("endDate", new SimpleDateFormat("yyyy-MM-dd").parse(endDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	   }
		return statusDao.query(hql, null, map, pager);

	}
}
