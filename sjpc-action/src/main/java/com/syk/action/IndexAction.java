package com.syk.action;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.syk.service.StatusService;
import com.syk.service.UserService;

import weibo4j.model.Status;
import weibo4j.model.User;

@Controller
@Scope(value = "prototype")
public class IndexAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 77934289612601969L;

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Autowired
	@Qualifier("statusService")
	private StatusService statusService;

	@Autowired
	@Qualifier("provinceMap")
	private HashMap<String, Integer> statusProvinceMap;

	@Autowired
	@Qualifier("provinceMap")
	private HashMap<String, Integer> userProvinceMap;

	@Override
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		//获取数据库中所有的微博用户数量
		actionContext.put("userNum", userService.getTotleNum());
		//获取数据库中所有的微博数量
		actionContext.put("statusNum", statusService.getTotleNum());
		//获取数据库中最新的微博信息
		actionContext.put("newlyStatus", statusService.newlyList());
		//获取数据库中最新的用户信息
		actionContext.put("newlyUser", userService.newlyList());
		//获取数据库中所有微博的发布地区信息
		actionContext.put("statusProvinceMap", statusMap());
		//获取数据库中所有微博用户的地区信息
		actionContext.put("userProvinceMap", userMap());
		return SUCCESS;
	}
	
	/**
	 * 将数据库中的微博地区信息进行分类提取
	 * @return 微博地区信息，格式为json
	 */
	private String statusMap() {
		List<Status> list = statusService.haveGeoStatus();
		for (Status s : list) {
			String ss = s.getGeoName().substring(0, s.getGeoName().indexOf(" "));
			try{
			statusProvinceMap.put(ss, statusProvinceMap.get(ss) + 1);
			}catch(NullPointerException e){
				continue;
			}
		}
		Gson gson = new Gson();
		return gson.toJson(statusProvinceMap);
	}

	/**
	 * 将微博用户的地区信息分类提取
	 * @return 微博用户的地区信息，格式为json
	 */
	private String userMap() {
		List<User> list = userService.haveLocationUser();
		for (User s : list) {
			String ss = null;
			try {
				ss = s.getLocation().substring(0, s.getLocation().indexOf(" "));
			} catch (IndexOutOfBoundsException e) {
				ss = s.getLocation();
			}
			try {
				userProvinceMap.put(ss, userProvinceMap.get(ss) + 1);
			} catch (NullPointerException e) {
				continue;
			}
		}
		Gson gson = new Gson();
		return gson.toJson(userProvinceMap);

	}
}
