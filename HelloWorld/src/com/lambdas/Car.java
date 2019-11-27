package com.lambdas;

public class Car {
	private String name;
	private int price;
	private String color;

	public Car(String name, int price, String color) {
		super();
		this.name = name;
		this.price = price;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public void printCar() {
		 System.out.println(this);
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + ", color=" + color + "]";
	}
}
