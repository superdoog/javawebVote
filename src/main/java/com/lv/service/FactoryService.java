package com.lv.service;

/**
 * @author lv
 */
public class FactoryService {

	public static UserService getUserService() {
		return new UserServiceImpl();
	}
}
