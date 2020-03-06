package basics;

public class IntegerReverse {

	public static void main(String[] args) {
		// input = 1534236469

		int val = -1534236469;
		System.out.println(val);
		
		int reversedVal = 0;
		String strval = "" + val;
		int strLen = strval.length();
		String revVal = "";

		int j = 0;

		if (val > 0)
			j = 0;
		else
			j = 1;

		String numArray[] = new String[20];
		for (int i = j; i < strLen; i++) {
			numArray[strLen - i] = strval.valueOf(strval.charAt(i));
		}
		
		for (String string : numArray) {
			if (string != null) {
				revVal += string;
			}
		}
		System.out.println(revVal);
	}

}
