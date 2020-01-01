package com.srf.beans;

public class StudentResultHold {

	private Float avg;
	private Integer sub1;
	private Integer sub2;
	private Integer sub3;
	private StudentDataHold sdh;
	private String res;
	public Float getAvg() {
		return avg;
	}
	public void setAvg(Float avg) {
		this.avg = avg;
	}
	public Integer getSub1() {
		return sub1;
	}
	public void setSub1(Integer sub1) {
		this.sub1 = sub1;
	}
	public Integer getSub2() {
		return sub2;
	}
	public void setSub2(Integer sub2) {
		this.sub2 = sub2;
	}
	public Integer getSub3() {
		return sub3;
	}
	public void setSub3(Integer sub3) {
		this.sub3 = sub3;
	}
	public StudentDataHold getSdh() {
		return sdh;
	}
	public void setSdh(StudentDataHold sdh) {
		this.sdh = sdh;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
}
