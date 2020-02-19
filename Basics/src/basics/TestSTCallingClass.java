package basics;

public class TestSTCallingClass {

	public static void main(String[] args) {
//		TestST st = new TestST(); //throws error because of the private constructors
		TestST st2 = TestST.getInstance();
	}

}
