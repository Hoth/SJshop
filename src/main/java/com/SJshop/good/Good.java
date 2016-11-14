package com.SJshop.good;

public class Good {
  public String gnum;//물건번호
  public String name;//물건이름
  public String detail;//물건 설명
  public long price;//물건 단가
  public String img;//물건 이미지 파일의 이름
  
public String getGnum() {
	return gnum;
}
public void setGnum(String gnum) {
	this.gnum = gnum;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDetail() {
	return detail;
}
public void setDetail(String detail) {
	this.detail = detail;
}
public long getPrice() {
	return price;
}
public void setPrice(long price) {
	this.price = price;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
}