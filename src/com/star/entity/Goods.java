package com.star.entity;

//商品信息表
public class Goods {
	private String gid;//编号
	private String name;//商品名称
	private GoodsType goodType;//商品类别的对象
	//private String tid;//类别编号
	private String unit;//单位
	private double pin;//进价
	private double pout;//售价
	private int amount;//库存
	
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GoodsType getGoodType() {
		return goodType;
	}
	public void setGoodType(GoodsType goodType) {
		this.goodType = goodType;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPin() {
		return pin;
	}
	public void setPin(double pin) {
		this.pin = pin;
	}
	public double getPout() {
		return pout;
	}
	public void setPout(double pout) {
		this.pout = pout;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	

}
