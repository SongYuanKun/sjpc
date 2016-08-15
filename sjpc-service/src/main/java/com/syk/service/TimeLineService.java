package com.syk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.syk.dao.SourceDao;
import com.syk.dao.StatusDao;
import com.syk.dao.UserDao;
import com.syk.dao.VisibleDao;

import weibo4j.Location;
import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Geos;
import weibo4j.model.Source;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.User;
import weibo4j.model.Visible;
import weibo4j.model.WeiboException;

@Service("timeLineService")
public class TimeLineService {
	@Autowired
	@Qualifier("statusDao")
	private StatusDao statusDao;

	@Autowired
	@Qualifier("visibleDao")
	private VisibleDao visibleDao;

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

	@Autowired
	@Qualifier("sourceDao")
	private SourceDao sourceDao;

	@Autowired
	private Timeline tm;

	@Autowired
	private Location l;

	@Autowired
	private Geos geos;

	public void getPublicTimeLine() {

		try {
			StatusWapper statusWapper = tm.getPublicTimeline();
			Log.logInfo(statusWapper.toString());
			addStatusWapper(statusWapper);
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

	public void addStatusWapper(StatusWapper statusWapper) {
		for (Status status : statusWapper.getStatuses()) {
			String geo = status.getGeo();
			if (geo != null && !geo.equals("null")) {
				geo = geo.substring(geo.lastIndexOf("["), geo.lastIndexOf("]")).replace("[", "");
				String[] s = geo.split(",");
				geo = s[1] + "," + s[0];
				status.setLongitude(Double.valueOf(s[1]));
				status.setLatitude(Double.valueOf(s[0]));
				try {
					List<Geos> list = l.geoToAddress(geo);
					geos = list.get(0);
				} catch (WeiboException e) {
					e.printStackTrace();
				}
				status.setGeoName(geos.getProvinceName().replace("省", "") + " " + geos.getCityName().replace("市", ""));
			}

			if (statusDao.get(status.getId()) == null) {
				Visible visible = status.getVisible();
				if (visible != null) {
					if (visibleDao.get(visible.getType()) == null) {
						visibleDao.add(visible);
					}
					status.setVisibleId(visible.getType());
				}
				User user = status.getUser();
				if (user != null) {
					if (userDao.get(user.getId()) == null) {
						userDao.add(user);
					}
					status.setUserId(user.getId());
				}
				Source source = status.getSource();
				if (source != null) {
					if (sourceDao.get(source.getUrl()) == null) {
						sourceDao.add(source);
					}
					status.setSourceId(source.getUrl());
				}
				statusDao.add(status);
			}
		}
	}

	public StatusWapper getUserTimelineByUid() {
		StatusWapper statusWapper = null;
		try {
			statusWapper = tm.getUserTimeline();
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		return statusWapper;
	}

}
