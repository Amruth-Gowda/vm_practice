package basics;

import java.util.ArrayList;
import java.util.List;

public class StreamsDemo2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for(int i=0; i <100; i++) {
			list.add("ab"+i+"ba"+i);
		}
		list.stream()
		.filter(s->s.contains("2") )
		.forEach(System.out::println);
	}

}
