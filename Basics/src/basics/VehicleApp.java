package basics;

public class VehicleApp {

	public static void main(String[] args) {
		
		Car car = new Car();
		System.out.println("Topspeed of the normal car is "+car.topSpeed+"kms");
		System.out.println("object s location car "+car);
		
		Car car1 = new Car();
		System.out.println("Topspeed of the normal car is "+car1.topSpeed+"kms");
		System.out.println("object s location car1 "+car1);
		
		System.out.println();
		SingletonCar s = SingletonCar.getInstance();
		System.out.println("Topspeed of the singleton car is s "+s.getTopSpeed()+"kms");
		System.out.println("object s location "+s);
		
		System.out.println();
		SingletonCar t = SingletonCar.getInstance();
		System.out.println("Topsppeed of the singleton car is t "+t.getTopSpeed()+"kms");
		System.out.println("object s location "+s);
		
		System.out.println();
		System.out.println("increasing the topspeed of object "+t);
		t.setTopSpeed(t.getTopSpeed()+100);
		
		System.out.println("Topspeed of the singleton car is s "+s.getTopSpeed()+"kms");
		System.out.println("Topspeed of the singleton car is t "+t.getTopSpeed()+"kms");
	}

}
