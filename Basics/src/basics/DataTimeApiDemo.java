package basics;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DataTimeApiDemo {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		
	}

}
