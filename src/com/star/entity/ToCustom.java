package com.star.entity;

//�ͻ��˻���
public class ToCustom {
	private String cbid;//���
	private Custom custom;//�˻��ͻ�id
	private Sell sell;//����id
	private String date;//�˻�ʱ��
	private double totalprice;//�˻��ܼ�
	
	public String getCbid() {
		return cbid;
	}
	public void setCbid(String cbid) {
		this.cbid = cbid;
	}
	public Custom getCustom() {
		return custom;
	}
	public void setCustom(Custom custom) {
		this.custom = custom;
	}
	public Sell getSell() {
		return sell;
	}
	public void setSell(Sell sell) {
		this.sell = sell;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	
}
