package com.star.entity;

//��Ʒ��Ϣ��
public class Goods {
	private String gid;//���
	private String name;//��Ʒ����
	private GoodsType goodType;//��Ʒ���Ķ���
	//private String tid;//�����
	private String unit;//��λ
	private double pin;//����
	private double pout;//�ۼ�
	private int amount;//���
	
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
