package com.lv.controller;


import com.lv.model.User;
import com.lv.service.FactoryUserService;
import com.lv.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author lv
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = FactoryUserService.getUserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置字符集
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8")
		;
		//获取提交url,截取出处理方法
		String mn = req.getServletPath();
		mn = mn.substring(1, mn.length() - 4);

		try {
			//反射获取方法实体
			Method method = this.getClass().getDeclaredMethod(mn, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询所以用户信息
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> list = userService.getListAll();
		req.setAttribute("userList", list);
		req.getRequestDispatcher("/admin.jsp").forward(req, resp);
	}

	/**
	 * 删除用户
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		int rows = userService.deleteUserById(id);
		if (rows > 0) {
			resp.sendRedirect(req.getContextPath() + "/query.udo");
		} else {
			resp.sendRedirect(req.getContextPath() + "/error.jsp");
		}
	}

	/**
	 * 跳转到修改页面
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		User user = userService.get(id);
		req.setAttribute("user", user);
		req.getRequestDispatcher("/update.jsp").forward(req, resp);
	}

	/**
	 * 修改用户信息
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updatedo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		User oldUser = userService.get(id);

		String oldUsername = oldUser.getUsername();
		String newUsername = req.getParameter("username");

		long count = userService.getCountByName(newUsername);

		if (!oldUsername.equals(newUsername) && count > 0) {
			req.setAttribute("note", newUsername + ",该名字已被占用，请换一个名字！");
			req.getRequestDispatcher("/update.udo?id=" + id).forward(req, resp);
			return;
		}
		oldUser.setUsername(newUsername);
		oldUser.setPasword(req.getParameter("pasword"));
		oldUser.setQualification(Boolean.parseBoolean(req.getParameter("qualification")));

		int rows = userService.updateUserById(oldUser);
		if (rows > 0) {
			resp.sendRedirect(req.getContextPath() + "/query.udo");
		} else {
			resp.sendRedirect(req.getContextPath() + "/error.jsp");
		}

	}

	/**
	 * 增加用户
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		user.setUsername(req.getParameter("username"));
		String name = user.getUsername();
		long rows = userService.getCountByName(name);
		if (rows > 0) {
			req.setAttribute("note", name + ",该名字已被占用，请换一个名字！");
			req.getRequestDispatcher("/add.jsp").forward(req, resp);
			return;
		}

		user.setPasword(req.getParameter("pasword"));
		user.setQualification(false);

		int row = userService.save(user);
		if (row > 0) {
			resp.sendRedirect(req.getContextPath() + "/admin.jsp");
		} else {
			resp.sendRedirect(req.getContextPath() + "/error.jsp");
		}
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}



}
