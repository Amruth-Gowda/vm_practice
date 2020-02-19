package basics;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressionDemo {

	public static void main(String[] args) {
		System.out.println(Sum.add(10, 11));

		Greet g = (s) -> System.out.println("Hello " + s);
		g.Hello("Alok");
	}

	interface Sum {
		static int add(int a, int b) {
			return a + b;
		}
	}
	
	interface Greet {
		public void Hello(String s);
	}
}
