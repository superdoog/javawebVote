package com.lv.service;

import com.lv.dao.FactoryUserDao;
import com.lv.dao.UserDao;
import com.lv.model.User;

import java.util.List;

/**
 * @author lv
 */
public class UserServiceImpl implements UserService {

	UserDao userDao = FactoryUserDao.getUserDao();

	@Override
	public int save(User user) {
		return userDao.save(user);
	}

	@Override
	public int deleteUserById(int id) {
		return userDao.deleteUserById(id);
	}

	@Override
	public int updateUserById(User user) {
		return userDao.updateUserById(user);
	}

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Override
	public List<User> getListAll() {
		return userDao.getListAll();
	}

	@Override
	public long getCountByName(String username) {
		return userDao.getCountByName(username);
	}

}
