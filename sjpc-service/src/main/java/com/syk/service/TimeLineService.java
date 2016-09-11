package com.syk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.syk.dao.StatusDao;
import com.syk.utils.Html2String;
import com.syk.utils.ParserString2List;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.WeiboException;

@Service("timeLineService")
public class TimeLineService {
	private List<String> userIds = new ArrayList<>();

	@Autowired
	@Qualifier("statusDao")
	private StatusDao statusDao;

	@Autowired
	private Timeline tm;

	public List<String> getUserIds() {
		return userIds;
	}

	// 获取公共微博
	public void savePublicTimeLine() {
		try {
			// 获取公共微博
			StatusWapper statusWapper = tm.getPublicTimeline();
			// Log.logInfo(statusWapper.toString());
			for (Status status : statusWapper.getStatuses()) {
				this.userIds.add(status.getUser().getId());
			}
			// 保存到数据库
			int ss = statusDao.saveStatusList(statusWapper.getStatuses());
			Log.logInfo("public time line num:" + ss);
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

	public void saveUserStatus() {
		List<Status> statuses = new ArrayList<>();
		for (String userId : userIds) {
			Html2String h2s = Html2String.newInstance(userId);
			statuses.addAll(ParserString2List.getList(userId, h2s.getSource()));
		}
		int ss = statusDao.saveStatusList(statuses);
		Log.logInfo("user id status num:" + ss);
	}
}
