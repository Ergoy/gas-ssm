package com.star.entity;

//�û�ʵ��
public class User {
	private String uid;//id
	private String name;//����
	private String pwd;//����
	private int level;//level
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid=uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
