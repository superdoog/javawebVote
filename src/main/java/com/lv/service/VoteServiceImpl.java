package com.lv.service;

import com.lv.dao.FactoryVoteDao;
import com.lv.dao.VoteDao;
import com.lv.model.Vote;

/**
 * @author lv
 */
public class VoteServiceImpl implements VoteService{
	VoteDao voteDao = FactoryVoteDao.getVoteDao();


	@Override
	public int updateVote(Vote vote) {
		return voteDao.updateVote(vote);
	}

	@Override
	public Vote get(int id) {
		return voteDao.getVote(id);
	}
}
