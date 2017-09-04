package com.quanglinhit.controller;

import java.util.Scanner;

import com.quanglinhit.entity.Student;
import com.quanglinhit.model.StudentModel;

public class StudentController {
	StudentModel studentModel=new StudentModel();
	Student student=new Student();
	Scanner sc=new Scanner(System.in);
	
	public void getList() {
		
		if (studentModel.getList().isEmpty()) {
			System.out.println("---NO DATA!!!---");
		}
		else{
			System.out.println("Students Information");
			for (Student stu : studentModel.getList()) {
				System.out.println("ID: "+stu.getId());
				System.out.println("Name: "+stu.getName());
				System.out.println("Email: "+stu.getEmail());
			}
			System.out.println("--------------------");
		}
		
	}
	
	// Lấy dữ liệu người dùng
	// Validate dữ liệu
	// Lưu thông tin
	public void addStudent() {
		System.out.println("Please enter Student information: ");
		System.out.println("Enter name: ");
		String name=sc.nextLine();
		System.out.println("Enter email: ");
		String email=sc.nextLine();
		
		Student student=new Student();
		student.setId(System.currentTimeMillis());
		student.setName(name);
		student.setEmail(email);
		
		studentModel.insert(student);
		System.out.println("Add Success!");
		System.out.println("--------------------");
	}

	public void editStudent() {
		System.out.println("Please enter ID Student.");
		
		String strSearch=sc.nextLine();
		long search = 0;
		try {
			search=Long.parseLong(strSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Please enter ID with long data type!");
		}
		if (student.getId()==search) {
			System.out.println("ID: "+student.getId());
			System.out.println("Name: "+student.getName());
			System.out.println("Email: "+student.getEmail());
			System.out.println("--------------------");
			System.out.println("Rewrite your name: ");
			String name=sc.nextLine();
			System.out.println("Rewrite your email: ");
			String email=sc.nextLine();
			student.setName(name);
			student.setEmail(email);
			System.out.println("---UPLOAD SUCCESSFUL!---");
		}else{
			System.out.println("---NO DATA!!!---");
		}
		studentModel.update(student);
		System.out.println("--------------------");
	}

	public void deleteStudent() {
		System.out.println("Please enter ID Student.");

		String strsearch=sc.nextLine();
		long search=0;
		try {
			search=Long.parseLong(strsearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Please enter ID with long data type!");
		}
		if (student.getId()==search) {
			System.out.println("ID: "+student.getId());
			System.out.println("Name: "+student.getName());
			System.out.println("Email: "+student.getEmail());
			System.out.println("---DELETE SUCCESSFUL!---");
			studentModel.delete(student);
		}else{
			System.out.println("---NO DATA!!!---");
		}
		System.out.println("--------------------");
	}

}
