package basics;

public class SumOfSquareNumber {
	
	public static int sumOfSquareNumber(int[] arr2) {
		if(arr2.length != 0) {
			int totalSum=0;
			for(int i=0; i<arr2.length; i++) {
				int j = (int)Math.sqrt(arr2[i]);
				if(arr2[i]==(j*j)) {
					totalSum += j;
				}
			}
			if(totalSum!=0)
				return totalSum;
			else
				return 0;
		}
		else {
			return -1;	
		}
		
	}
}
