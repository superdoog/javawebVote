package com.lv.dao;

/**
 * @author lv
 */
public class FactoryVoteDao {

	public static VoteDao getVoteDao(){
		return new VoteDaoImpl();
	}
}
