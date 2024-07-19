package com.lbi.model;

import java.util.Arrays;

public class Criteria {
	
	// ���� ������	
	private int pageNum;
	
	// �� ������ �� ������ �Խù� ��
	private int amount;
	
	// �˻� Ű����
	private String keyword;
	
	// �˻� Ÿ��
	private String type;

	// �˻� Ÿ�� �迭
	private String[] typeArr;
	
	// �⺻ ������ -> �⺻ ���� : pageNum = 1, amount = 10
	public Criteria() {
		this(1,10);
	}

	// ������ => ���ϴ� pageNum, amount
	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		this.typeArr = type.split("");
	}

	public String[] getTypeArr() {
		return typeArr;
	}

	public void setTypeArr(String[] typeArr) {
		this.typeArr = typeArr;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", keyword=" + keyword + ", type=" + type
				+ ", typeArr=" + Arrays.toString(typeArr) + "]";
	}

}
