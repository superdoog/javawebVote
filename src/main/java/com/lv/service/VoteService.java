package com.lv.service;

import com.lv.model.Vote;

public interface VoteService {

	/**
	 * 修改vote
	 * @param vote
	 * @return
	 */
	int updateVote(Vote vote);

	/**
	 * 用ID获取vote对象
	 * @param id
	 * @return
	 */
	Vote get(int id);
}
