package basics;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationsDemo {

	public static void main(String[] args) {

		System.out.println(Day.Monday);
		Vector<String> vList = new Vector<>();
		vList.add("Sunday");
		vList.add("Monday");
		vList.add("Tuesday");
		vList.add("Wednesday");
		vList.add("Thursday");
		vList.add("Firday");
		vList.add("Saturday");
		Enumeration<String> a = vList.elements();
		
		while(a.hasMoreElements()) {
			System.out.println(a.nextElement());
		}
	}

	public enum Day {
		Sunday, Monday, Tuesday, Wednesday, Thursday, Firday, Saturday
	}

}
