package basics;

import java.util.ArrayList;
import java.util.List;

public class StreamsDemo {

	public static void main(String[] args) {
		List<Integer> sampleList = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			sampleList.add(i);
		}
		sampleList.stream()
		.filter(s -> (s % 2 == 0))
		.filter(s -> (s % 5 == 0))
		.forEach(System.out::println);
	}

}
