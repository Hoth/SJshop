package com.SJshop.shoppingList;

public class ShoppingList {
	public int sNum;//PK
	public int mNum;//구매자No.
	public int mCount; //쇼핑횟수(한번에 여러개 구매했을 때)
	public String Date;
	public int gNum;//구매한상품No.
	public String gPrice;//개별 상품 가격
	public String gColor;//상품 색상
	
	
	public int getsNum() {
		return sNum;
	}
	public void setsNum(int sNum) {
		this.sNum = sNum;
	}
	
	public int getmNum() {
		return mNum;
	}
	public void setmNum(int mNum) {
		this.mNum = mNum;
	}
	
	public void setmCount(int mCount) {
		this.mCount = mCount;
	}
	public int getmCount() {
		return mCount;
	}
	
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	public int getgNum() {
		return gNum;
	}
	public void setgNum(int gNum) {
		this.gNum = gNum;
	}
	
	public String getgPrice() {
		return gPrice;
	}
	public void setgPrice(String gPrice) {
		this.gPrice = gPrice;
	}
	
	public String getgColor() {
		return gColor;
	}
	public void setgColor(String gColor) {
		this.gColor = gColor;
	}
	
}
