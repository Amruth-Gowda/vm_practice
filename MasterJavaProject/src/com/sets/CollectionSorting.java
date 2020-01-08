package com.sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.model.Student;

public class CollectionSorting {
	public static void main(String... args) {
		Set<Student> students = new HashSet<Student>();
		
		Student student = new Student("Abhishek", 65);
		Student student1 = new Student("Amruth", 95);
		Student student2 = new Student("Harika", 85);
		Student student3 = new Student("Srinkant", 80);
		Student student4 = new Student("Srinitha", 90);
		Student student5 = new Student("Vivian", 75);
		Student student6 = new Student("Vishnu", 83);
		Student student7 = new Student("Naveena", 70);
		
		students.add(student);
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);
		students.add(student6);
		students.add(student7);
		
		for(Student obj: students) {
			System.out.println(obj);
		}
		
		List<Student> myList = new ArrayList<Student>(students);
		Collections.sort(myList);
		
		System.out.println("After sorting the list");
		
		for(Student obj: myList) {
			System.out.println(obj.getName());
		}
		
		
	}
}
