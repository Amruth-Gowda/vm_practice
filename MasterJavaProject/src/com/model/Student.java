package com.model;

public class Student implements Comparable<Student> {
	String name;
	int marks;

	public Student() {
		super();
	}

	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + "]";
	}

	@Override
	public int compareTo(Student obj) {
		if (this.marks < obj.marks)
			return 1;
		else if (this.marks > obj.marks)
			return -1;
		return 0;
	}

}
