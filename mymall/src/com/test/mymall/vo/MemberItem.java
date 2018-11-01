package com.test.mymall.vo;

public class MemberItem {
	private int No;
	private int memberNo;
	private int itemNo;
	private String orderDate;
	public int getNo() {
		return No;
	}
	public void setNo(int no) {
		No = no;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
}
