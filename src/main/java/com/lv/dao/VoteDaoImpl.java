package com.lv.dao;

import com.lv.model.Vote;

public class VoteDaoImpl extends BaseDao implements VoteDao {


	@Override
	public int updateVote(Vote vote) {
		String sql = "update `vote` set `sum`=? , `detail`=? where id = ?";
		return super.update(sql, vote.getsum(), vote.getDetail());
	}

	@Override
	public Vote getVote(int id) {
		String sql = "select `sum`,`detail` where `id`=?";
		return (Vote) super.get(sql, id);
	}
}
