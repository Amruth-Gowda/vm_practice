package com.lambdas;

import java.util.Arrays;
import java.util.List;

public class FuncInterfaceApp {

	public static void main(String[] args) {

		List<Car> cars = Arrays.asList(new Car("honda", 25000, "blue"), new Car("hundayi", 35000, "red"),
				new Car("suzuki", 95000, "green"), new Car("benz", 80000, "blue"), new Car("audi", 45000, "green"),
				new Car("nissan", 65000, "yellow"), new Car("mg", 55000, "blue"));

		System.out.println("Printing cars based on the color...");
		printCars(cars, new Condition() {

			@Override
			public boolean test(Car c) {
				if (c.getColor().equals("blue"))
					return true;
				return false;
			}
		});

		System.out.println("Printing cars based on the prince range..");
		printCars(cars, new Condition() {

			@Override
			public boolean test(Car c) {
				if (c.getPrice() > 55000 && c.getPrice() < 70000)
					return true;
				return false;
			}
		});
	}

	public static void printCars(List<Car> cars, Condition condition) {
		for (Car c : cars) {
			if (condition.test(c))
				c.printCar();
			;
		}
	}

}

@FunctionalInterface
interface Condition {
	public boolean test(Car c);
}
