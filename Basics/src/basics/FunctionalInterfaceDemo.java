package basics;

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		Sample e = (a, b) -> (a-- * ++a + --b * b++);
		System.out.println(e.sum(4, 5));
	}

	@FunctionalInterface
	interface Sample {
		public int sum(int a, int b);
	}
}
