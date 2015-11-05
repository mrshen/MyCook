package com.mrshen.cvapp.scut.persistent.dao;

public class FoodEntity extends BaseDao{
	private int dishId;
	private String dishName;
	private String dishPicUrl;
	private String dishVideoAddr;
	private String dishIntr;
	private String dishStep;
	//	1 for yuecai, 0 for others
	private int type;
	
	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDishPicUrl() {
		return dishPicUrl;
	}

	public void setDishPicUrl(String dishPicUrl) {
		this.dishPicUrl = dishPicUrl;
	}

	public String getDishVideoAddr() {
		return dishVideoAddr;
	}

	public void setDishVideoAddr(String dishVideoAddr) {
		this.dishVideoAddr = dishVideoAddr;
	}

	public String getDishIntr() {
		return dishIntr;
	}

	public void setDishIntr(String dishIntr) {
		this.dishIntr = dishIntr;
	}

	public String getDishStep() {
		return dishStep;
	}

	public void setDishStep(String dishStep) {
		this.dishStep = dishStep;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public FoodEntity(
			int dishId, 
			String dishName, 
			String dishPicUrl,
			String dishVideoAddr,
			String dishIntr,
			String dishStep,
			int type) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.dishPicUrl = dishPicUrl;
		this.dishVideoAddr = dishVideoAddr;
		this.dishIntr = dishIntr;
		this.dishStep = dishStep;
		this.type = type;
	}

	public FoodEntity() {
		super();
	}
	
}
