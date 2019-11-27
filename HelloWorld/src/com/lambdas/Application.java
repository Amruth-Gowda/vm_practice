package com.lambdas;

import java.util.Arrays;
import java.util.List;

public class Application {

	public static void main(String[] args) {

//		SumInterface sumVar = (a, b) -> a + b;
//		System.out.println("Sum of numbers: " + sumVar.add(10, 12));

		List<Car> cars = Arrays.asList(new Car("honda", 25000, "blue"), new Car("hundayi", 35000, "red"),
				new Car("suzuki", 95000, "green"), new Car("benz", 80000, "blue"), new Car("audi", 45000, "green"),
				new Car("nissan", 65000, "yellow"), new Car("mg", 55000, "blue"));

		System.out.println("Printing cars based on the price range...");
		displayBasedOnPrice(cars, 70000, 87000);

		System.out.println("Printing cars based on the color..");
		displayBasedOnColor(cars, "green");

	}
	
	public static void displayBasedOnPrice(List<Car> cars, int low, int high) {
		for (Car c : cars) {
			if (c.getPrice() < high && c.getPrice() > low) {
				System.out.println(c);
			}
		}
	}

	public static void displayBasedOnColor(List<Car> cars, String color) {
		for (Car c : cars) {
			if (c.getColor().equals(color)) {
				System.out.println(c);
			}
		}
	}
}

