package com.star.entity;

//�ɹ��˻���
public class Provider {
	private String pbid;//���
	private Custom custom;//�˻��ͻ�id
	private Stock stock;//����id
	private String date;//�˻�ʱ��
	private double totalprice;//�˻��ܼ�
	
	public String getPbid() {
		return pbid;
	}
	public void setPbid(String pbid) {
		this.pbid = pbid;
	}
	public Custom getCustom() {
		return custom;
	}
	public void setCustom(Custom custom) {
		this.custom = custom;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
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
