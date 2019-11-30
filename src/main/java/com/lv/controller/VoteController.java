package com.lv.controller;

import com.lv.model.Vote;
import com.lv.service.FactoryVoteService;
import com.lv.service.VoteService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lv
 */
public class VoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoteService voteService = FactoryVoteService.getVoteService();

	/**
	 * 获取投票对象，注入到页面
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getVote(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Vote vote = voteService.get(1);
		req.setAttribute("vote",vote);
		req.getRequestDispatcher("/vote.jsp").forward(req,resp);

	}

	private void updateVote(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Vote vote = voteService.get(1);
		boolean choice = Boolean.parseBoolean(req.getParameter("piao"));
		int sum = vote.getsum();
		if (choice) {
			sum++;
		}
		vote.setsum(sum);

		int row = voteService.updateVote(vote);
		if (row > 0) {
			resp.sendRedirect(req.getContextPath() + "/vote.jsp");
		} else {
			resp.sendRedirect(req.getContextPath() + "/error.jsp");
		}

	}

	private void viewVote(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
