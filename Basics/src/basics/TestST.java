package basics;

public class TestST {
	private static TestST testST;

	private TestST() {
		System.out.println("TestST: private Constructor triggered by the method insde the class");
	}

	public static TestST getInstance() {
		if (testST == null) {
			testST = new TestST();
		}
		return testST;
	}
}
