package basics;

interface Bi {
	void add();
}

interface C {
	void add();
}

public class InterfaceExample1 implements Bi, C {
	public void add() {
	}

	public static void main(String[] args) {
		InterfaceExample1 a = new InterfaceExample1();
		Bi b = new InterfaceExample1();
		C c = new InterfaceExample1();
		System.out.println(b instanceof Bi);
		if (b instanceof Bi && c instanceof C) {
			System.out.println("b");
		}

		if (a instanceof Bi && a instanceof C) {
			System.out.println("c");
		}
	}
}
