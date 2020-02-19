package basics;

public class SingletonCar {

	private static SingletonCar singletonCarInstance = null;

	private int topSpeed;

	private SingletonCar() {
		topSpeed = 300;
	}

	public static SingletonCar getInstance() {
		if (singletonCarInstance == null) {
			singletonCarInstance = new SingletonCar();
		}
		return singletonCarInstance;
	}

	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}
}
