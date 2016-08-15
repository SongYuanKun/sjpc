package com.syk.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.syk.service.StatusService;
import com.syk.service.UserService;
import com.syk.util.Pager;

import weibo4j.model.Status;

@Controller
@Scope(value = "prototype")
public class ProfileAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2458741111696738281L;

	@Autowired
	@Qualifier("statusService")
	private StatusService statusService;

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	public String getUserStatusList() throws Exception {
		Pager<Status> sp = new Pager<>();
		ActionContext context = ActionContext.getContext();
		Map<String, Object> parameterMap = context.getParameters();
		String[] ids = (String[]) parameterMap.get("id");
		sp.setiDisplayLength(10);
		statusService.pagerListByUser(ids[0], sp);
		context.put("pager", sp);
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> parameterMap = context.getParameters();
		String[] ids = (String[]) parameterMap.get("id");
		if (ids == null) {
			return ERROR;
		}
		context.put("user", userService.getUser(ids[0]));
		return SUCCESS;
	}

}
