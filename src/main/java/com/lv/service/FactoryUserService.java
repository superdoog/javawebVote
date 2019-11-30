package com.lv.service;

/**
 * @author lv
 */
public class FactoryUserService {

	public static UserService getUserService() {
		return new UserServiceImpl();
	}
}
