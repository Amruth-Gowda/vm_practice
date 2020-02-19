package basics;

public class ClassCompareExample {
	
	public static void main(String ...args) {
		Car car = new Car();
		Car car1 = new Car(200);
		
		System.out.println(car.equals(car1));//false
	}
}
