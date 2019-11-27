package com.lv.dao;

import com.lv.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * dao层里的基本类
 * 被具体的dao类继承
 * 不能new对象
 *
 * @param <T> 针对要操作各张表映射到java工程里的Java类
 * @author lv
 */
public class BaseDao<T> {

	QueryRunner queryRunner = new QueryRunner();

	private Class<T> clazz;

	/**
	 * 用构造方法初始化clazz
	 */
	public BaseDao() {
		//getGenericSuperclass 拿到调用者父类的类型
		Type superType = this.getClass().getGenericSuperclass();
		if (superType instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) superType;
			Type[] tarry = pt.getActualTypeArguments();
			if (tarry[0] instanceof Class) {
				clazz = (Class<T>) tarry[0];
			}
		}
	}

	/**
	 * 查询数据表，取出sql语句的结果集的第一条数据，封装成一个类的对象返回
	 *
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql, Object... args) {
		Connection conn = null;
		T entity = null;
		try {
			conn = JdbcUtils.getConnection();
			entity = queryRunner.query(conn, sql, new BeanHandler<T>(clazz), args);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConn(conn);
		}
		return entity;
	}

	/**
	 * 获取多条记录的通用方法
	 *
	 * @param sql
	 * @param args
	 * @return
	 */
	public T getList(String sql, Object... args) {
		Connection conn = null;
		List<T> list = null;
		try {
			conn = JdbcUtils.getConnection();
			list = queryRunner.query(conn, sql, new BeanListHandler<T>(clazz), args);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConn(conn);
		}
		return (T) list;
	}

	/**
	 * 实现insert，update，delete通用更新方法
	 *
	 * @param sql
	 * @param args
	 * @return
	 */
	public int update(String sql, Object... args) {
		Connection conn = null;
		int rows = 0;
		try {
			conn = JdbcUtils.getConnection();
			rows = queryRunner.update(conn, sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConn(conn);
		}
		return rows;
	}

	/**
	 * 通用返回select语句的结果只有一个数值的类型的查询方法
	 *
	 * @return
	 */
	public Object getValue(String sql, Object... args) {
		Connection conn = null;
		Object obj = null;
		try {
			conn = JdbcUtils.getConnection();
			obj = queryRunner.query(conn, sql, new ScalarHandler<>(), args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConn(conn);
		}
		return obj;
	}

}
