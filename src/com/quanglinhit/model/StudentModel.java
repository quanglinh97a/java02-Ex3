package com.quanglinhit.model;

import java.util.ArrayList;
import java.util.Scanner;

import com.quanglinhit.entity.Student;

public class StudentModel {
	private static ArrayList<Student> listStudent;
	
	public ArrayList<Student> getList() {
		return listStudent;
	}

	public void insert(Student student) {
		if (listStudent==null) {
			listStudent=new ArrayList<Student>();
		}
		listStudent.add(student);
	}

	public void update(Student student) {
		listStudent.add(student);
	}

	public void delete(Student student) {
		listStudent.remove(student);
		
	}
	
	public static void main(String[] args) {
		listStudent=new ArrayList<Student>();
		Student stu1=new Student(12301, "Đức", "ducdm@gmail.com");
		Student stu2=new Student(12302, "Nam", "namcaca@gmail.com");
		Student stu3=new Student(12303, "Chiến", "chientruong@gmail.com");
		Student stu4=new Student(12304, "Tuấn", "tuantienty@gmail.com");
		listStudent.add(stu1); listStudent.add(stu2);
		listStudent.add(stu3); listStudent.add(stu4);
	}
}
