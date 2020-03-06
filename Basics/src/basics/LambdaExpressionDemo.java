package basics;

public class LambdaExpressionDemo {

	public static void main(String[] args) {
		System.out.println(Sum.add(10, 11));

		Greet g = (s) -> System.out.println("Hello " + s);
		g.Hello("Alok");

		ArraySum arraySum = (numArray) -> {
			int sum = 0;
			for (int num : numArray)
				sum += num;
			return sum;
		};

		int[] numberArray = new int[] { 1, 3, 4, 5, 6, 7, 8, 10 };
		System.out.println(arraySum.sumOfArray(numberArray));
	}

	interface Sum {
		static int add(int a, int b) {
			return a + b;
		}
	}

	interface Greet {
		public void Hello(String s);
	}

	interface ArraySum {
		public int sumOfArray(int array[]);
	}
}
