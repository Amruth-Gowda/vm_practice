package basics;

import static java.lang.System.out;;

public class OperatorEvalDemo {
	public static void main(String args[]) {
		new OperatorEvalDemo();
	}

	OperatorEvalDemo() {
		if (0 == 1 && 2 + 2 == 4) {
			out.println("(0 == 1 && 2 + 2 == 4) is true"); 
		} else {
			out.println("(0 == 1 && 2 + 2 == 4) is false");
		}

		out.println();

		if (2 + 2 == 4 || 0 == 1) {
			out.println("(2 + 2 == 4 || 0 == 1) is true");
		} else {
			out.println("(2 + 2 == 4 || 0 == 1) is false");
		}

		out.println();

		if (isFalse() && isTrue()) {
			out.println("(isFalse() && isTrue()) is true");
		} else {
			out.println("(isFalse() && isTrue()) is false");
		}

		out.println();

		if (isFalse() & isTrue()) {
			out.println("(isFalse() & isTrue()) is true");
		} else {
			out.println("(isFalse() & isTrue()) is false");
		}

		out.println();

		if (isTrue() || isFalse()) {
			out.println("(isTrue() || isFalse()) is true");
		} else {
			out.println("(isTrue() || isFalse()) is false");
		}

		out.println();

		if (isTrue() | isFalse()) {
			out.println("(isTrue() | isFalse()) is true");
		} else {
			out.println("(isTrue() | isFalse()) is false");
		}
	}

	boolean isTrue() {
		out.println("Executing isTrue");
		return true;
	}

	boolean isFalse() {
		out.println("Executing isFalse");
		return false;
	}
}