package com.star.entity;

//�ɹ���Ϣ��
public class Stock {
	private String sid;//���
	private Custom custom;//�ͻ���Ϣ�Ķ���
	//private String cid;//��Ӧ�̱��
	private String date;//�ɹ�ʱ��
	private Double totalprice;//�ɹ��ܼ�
	private String buyer;//�ɹ���
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public Custom getCustom() {
		return custom;
	}
	public void setCustom(Custom custom) {
		this.custom = custom;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	
}
