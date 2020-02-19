package basics;

class A {
	A() {
		System.out.println("Class A: constructor execution...");
	}

	static {
		System.out.println("class A: static block 1 execution...");
	}
	{
		System.out.println("class A: instance block 1 execution..");
	}
	static {
		System.out.println("class A: static block 2 execution..");
	}
	{
		System.out.println("class A: instance block 2 execution..");
	}
}

class B extends A {
	B() {
		System.out.println("Class B: constructor execution...");
	}

	static {
		System.out.println("class B: static block 1 execution...");
	}
	{
		System.out.println("class B: instance block 1 execution..");
	}
	static {
		System.out.println("class B: static block 2 execution..");
	}
	{
		System.out.println("class B: instance block 2 execution..");
	}
}

public class InitializerBlocksExample {

	public static void main(String[] args) {
		B b = new B();
	}

}
