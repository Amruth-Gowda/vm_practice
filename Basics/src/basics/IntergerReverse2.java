package basics;

public class IntergerReverse2 {

	public static void main(String[] args) {
		int xc = -8-4-6-3-8-4-7-4-1-2;
		int xb = xc;
		int num1 = 0;
		if (xb != 0) {
			System.out.println(xb);
			int count = 0;
			int countingVal = xb;
			while (countingVal != 0) {
				countingVal /= 10;
				++count;
			}

			int[] numArray = new int[count];
			int i = 0;

			boolean negativFlag = false;
			if (xb < 0) {
				negativFlag = true;
				xb *= -1;
			}

			while (xb != 0) {
				numArray[i] = xb % 10;
				xb /= 10;
				i++;
			}

			String reverseVal = "";
			for (int j : numArray) {
				reverseVal += j;
			}
			long num = Long.parseLong(reverseVal);
			if (negativFlag == true) {
				num *= -1;
			}
			System.out.println(num);
			if (num > 2147483647 || num < -2147483648) {
				num = 0;
			}
			num1 = (int) num;
		}
		System.out.println(num1);

	}

}
