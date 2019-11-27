package com.lv.model;

public class Vote {

	/**
	 * 投票编号
	 */
	private int id;

	/**
	 * 投票人数
	 */
	private int option;

	/**
	 * 投票信息
	 */
	private int detail;

	public Vote(int id, int option, int detail) {
		this.id = id;
		this.option = option;
		this.detail = detail;
	}

	public Vote() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public int getDetail() {
		return detail;
	}

	public void setDetail(int detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Vote{" +
				"id=" + id +
				", option=" + option +
				", detail=" + detail +
				'}';
	}
}
