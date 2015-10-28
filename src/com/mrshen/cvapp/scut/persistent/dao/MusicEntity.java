package com.mrshen.cvapp.scut.persistent.dao;

public class MusicEntity extends BaseDao{
	private int id;
	private String name;
	private String addr;
	//	1:国语 2:港台 3:外语
	private int type;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MusicEntity(int id, String name, String addr, int type) {
		super();
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.type = type;
	}
	public MusicEntity() {
		super();
	}
}
