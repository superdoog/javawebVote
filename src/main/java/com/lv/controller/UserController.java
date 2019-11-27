package com.lv.controller;

import com.lv.model.User;
import com.lv.service.FactoryService;
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
	private UserService userService = FactoryService.getUserService();

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

	private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> list = userService.getListAll();
		req.setAttribute("userList", list);
		req.getRequestDispatcher("/admin.jsp").forward(req,resp);
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	private void updateVote(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	private void viewVote(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
