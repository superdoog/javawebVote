package com.lv.dao;

import com.lv.model.Vote;

/**
 * @author lv
 */
public interface VoteDao {

	/**
	 * 修改投票
	 *
	 */
	int updateVote(Vote vote);

	/**
	 * 通过id返回一个vote对象
	 * @param id
	 * @return
	 */
	Vote getVote(int id);

}
