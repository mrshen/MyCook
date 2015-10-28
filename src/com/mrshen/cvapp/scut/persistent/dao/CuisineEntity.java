package com.mrshen.cvapp.scut.persistent.dao;

public class CuisineEntity extends BaseDao{
	private int dishId;
	private String dishName;
	private String dishVideoAddr;
	private String dishDesc;
	//	1 for yuecai, 0 for others
	private int type;
	public int getId() {
		return dishId;
	}
	public void setId(int id) {
		this.dishId = id;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getDishVideoAddr() {
		return dishVideoAddr;
	}
	public void setDishVideoAddr(String dishVideoAddr) {
		this.dishVideoAddr = dishVideoAddr;
	}
	public String getDishDesc() {
		return dishDesc;
	}
	public void setDishDesc(String dishDesc) {
		this.dishDesc = dishDesc;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public CuisineEntity(int id, String dishName, String dishVideoAddr, String dishDesc, int type) {
		super();
		this.dishId = id;
		this.dishName = dishName;
		this.dishVideoAddr = dishVideoAddr;
		this.dishDesc = dishDesc;
		this.type = type;
	}
	public CuisineEntity() {
		super();
	}
	
}
