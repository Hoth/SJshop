package com.SJshop.member;

public class Member {
	public int mNum;
	public String mName;
	public String mId;
	public String mPw;
	public String mPw2;
	public String mAddress;
	public String mMileage;
	public String sCount; //구매내역 보기 위한 구매횟수
	

	public int getmNum() {
		return mNum;
	}
	public void setmNum(int mNum) {
		this.mNum = mNum;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmPw2() {
		return mPw2;
	}
	public void setmPw2(String mPw2) {
		this.mPw2 = mPw2;
	}
	public String getmAddress() {
		return mAddress;
	}
	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}
	public String getmMileage() {
		return mMileage;
	}
	public void setmMileage(String mMileage) {
		this.mMileage = mMileage;
	}
	public String getsCount() {
		return sCount;
	}
	public void setsCount(String sCount) {
		this.sCount = sCount;
	}
}
