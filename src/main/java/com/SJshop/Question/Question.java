package com.SJshop.Question;

public class Question {
	int qNum;
	String qName;
	public int getqNum() {
		return qNum;
	}
	public void setqNum(int qNum) {
		this.qNum = qNum;
	}
	public String getqName() {
		return qName;
	}
	public void setqName(String qName) {
		this.qName = qName;
	}
	@Override
	public String toString() {
		return "Question [qNum=" + qNum + ", qName=" + qName + "]";
	}
	
}
