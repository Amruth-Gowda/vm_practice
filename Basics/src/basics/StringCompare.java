package basics;

public class StringCompare {

	public static void main(String[] args) {
		String a = "abc";
		String c = "abc";
		String b = new String("abc");
		String d = new String("abc");
		
		System.out.println((a==c));//true
		System.out.println(a==b);//false
		System.out.println(b==d);//false
		System.out.println(a.equals(b));//true
		System.out.println((b.equals(d)));//true
		System.out.println(b.equals(c));//true
	}

}
