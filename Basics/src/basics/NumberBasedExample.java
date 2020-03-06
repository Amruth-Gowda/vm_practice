package basics;

public class NumberBasedExample {

	public static void main(String[] args) {
		int []integers = new int[] {6,2,4,5,9,10,11,1,2,8};
		int sum =10;
		for (int i = 0; i < integers.length - 1 ; i++) {
			if((integers[i]+integers[i+1])==sum) {
				System.out.println("sum of two consecutive elements in an array is ");
				System.out.println(integers[i] + " + " + integers[i+1] + " = " + sum);
				break;
			}
			else {
				System.out.println("Couldn't find the consecutive elements in an array of sum = "+sum);
				continue;
			}
				
		}
	}

}
