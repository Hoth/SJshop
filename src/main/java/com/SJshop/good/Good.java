package com.SJshop.good;

public class Good {
	public int gNum; //PK
	public String gName;//상품이름
	public String gPrice;//가격
	public String gMainImg;//대표사진
	public String gMainDetail;//대표내용
	public String gImg;//글이미지
	public String gDetail;//글내용
	public int gCount;//주문량
	public int gStock;//재고수
	public int cNum;//카테고리넘버
	//public String gColor;//����
	
	public int getgNum() {
		return gNum;
	}
	public void setgNum(int gNum) {
		this.gNum = gNum;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getgPrice() {
		return gPrice;
	}
	public void setgPrice(String gPrice) {
		this.gPrice = gPrice;
	}
	public String getgMainImg() {
		return gMainImg;
	}
	public void setgMainImg(String gMainImg) {
		this.gMainImg = gMainImg;
	}
	public String getgMainDetail() {
		return gMainDetail;
	}
	public void setgMainDetail(String gMainDetail) {
		this.gMainDetail = gMainDetail;
	}
	public String getgImg() {
		return gImg;
	}
	public void setgImg(String gImg) {
		this.gImg = gImg;
	}
	public String getgDetail() {
		return gDetail;
	}
	public void setgDetail(String gDetail) {
		this.gDetail = gDetail;
	}
	public int getgCount() {
		return gCount;
	}
	public void setgCount(int gCount) {
		this.gCount = gCount;
	}
	public int getgStock() {
		return gStock;
	}
	public void setgStock(int gStock) {
		this.gStock = gStock;
	}
	public int getcNum() {
		return cNum;
	}
	public void setcNum(int cNum) {
		this.cNum = cNum;
	}
	
}
