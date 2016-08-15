package com.syk.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.syk.service.UserService;
import com.syk.util.Pager;

import weibo4j.model.User;

@Controller
@Scope(value = "prototype")
public class ContactsAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7935492844728426058L;

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Override
	public String execute() throws Exception {
		Pager<User> up = new Pager<>();
		up.setiDisplayLength(10);
		userService.serchUserByPager(up);
		ServletActionContext.getContext().put("pager", up);
		return SUCCESS;

	}

}
