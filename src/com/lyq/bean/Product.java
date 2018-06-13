package com.lyq.bean;

/**
 * ��Ʒ
 * @author Li YongQiang
 *
 */
public class Product {
	public static final int PAGE_SIZE = 2;
	// ���
	private int id;
	// ����
	private String name;
	// �۸�
	private double price;
	// ����
	private int num;
	// ��λ
	private String unit;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
