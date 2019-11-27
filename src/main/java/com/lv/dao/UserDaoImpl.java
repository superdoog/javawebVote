package com.lv.dao;


import com.lv.model.User;

import java.util.List;

/**
 * @author lv
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
	@Override
	public int save(User user) {
		String sql = "insert into `users`(`username`,`pasword`,`qualification` )value(?,?,?)";
		return super.update(sql, user.getUsername(), user.getPasword(), user.getQualification());
	}

	@Override
	public int deleteUserById(int id) {
		String sql = "delete from `users` where `id`=?";
		return super.update(sql, id);
	}

	@Override
	public int updateUserById(User user) {
		String sql = "update `users` set `username`=?,`pasword`=?,`qualification`=?  where `id`=?";
		return super.update(sql, user.getUsername(), user.getPasword(), user.getQualification(), user.getId());
	}

	@Override
	public User get(int id) {
		String sql = "select `id`,`username`,`pasword`,`qualification` from `users` where `id`=?";
		return super.get(sql, id);
	}

	@Override
	public List<User> getListAll() {
		String sql = "select `id`,`username`,`pasword`,`qualification` from `users`";
		return (List<User>) super.getList(sql);
	}

	@Override
	public long getCountByName(String username) {
		String sql = "select count(`id`) from `users` where `username`=?";
		return (long) super.getValue(sql,username);
	}
}
