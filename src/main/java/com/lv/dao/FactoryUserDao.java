package com.lv.dao;


/**
 * @author lv
 */
public class FactoryUserDao {

	public static UserDao getUserDao() {
		return new UserDaoImpl();
	}
}
