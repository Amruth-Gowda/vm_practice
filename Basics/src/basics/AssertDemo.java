package basics;

public class AssertDemo {

	public static void main(String[] args) {
		int value = 19;
		assert value >= 20 : "Under weight";
		System.out.println("The value: " + value);
	}
}
