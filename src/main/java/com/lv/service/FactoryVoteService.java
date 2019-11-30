package com.lv.service;

public class FactoryVoteService {

	public static VoteService getVoteService(){
		return new VoteServiceImpl();
	}
}
