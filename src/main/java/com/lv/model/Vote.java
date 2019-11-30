package com.lv.model;

public class Vote {

	/**
	 * 投票编号
	 */
	private int id;

	/**
	 * 投票人数
	 */
	private int sum;

	/**
	 * 投票信息
	 */
	private int detail;

	public Vote(int id, int sum, int detail) {
		this.id = id;
		this.sum = sum;
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

	public int getsum() {
		return sum;
	}

	public void setsum(int sum) {
		this.sum = sum;
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
				", sum=" + sum +
				", detail=" + detail +
				'}';
	}
}
