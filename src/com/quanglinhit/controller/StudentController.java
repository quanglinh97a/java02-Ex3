package com.quanglinhit.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.quanglinhit.entity.Student;
import com.quanglinhit.model.StudentModel;

public class StudentController {
	StudentModel studentModel=new StudentModel();
	Student student=new Student();
	
	public void getList() {
		System.out.println("======== Student List ========");
		ArrayList<Student> listStudent=studentModel.getList();
		
		for (Student student : listStudent) {
			if (student.getStatus()==1) {
				System.out.println(">> ID: "+student.getId()
									+"\n - Name: "+student.getName()
									+"\n - Email: "+student.getEmail()
									+"\n - Roll Number: "+student.getName()
									+"\n - Class Name: "+student.getName());
				System.out.println("--------------------");
			} else {
				System.out.println("---NO DATA!!!---");
			}
		}
	}
	
	public void addStudent() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter Student information: ");
		System.out.println("Please enter name: ");
		String name=sc.nextLine();
		System.out.println("Please enter email: ");
		String email=sc.nextLine();
		System.out.println("Please enter roll number: ");
		String rollNumber=sc.nextLine();
		System.out.println("Please enter class name: ");
		String className=sc.nextLine();
		
		Student student=new Student();
		student.setName(name);
		student.setEmail(email);
		student.setRollNumber(rollNumber);
		student.setClassName(className);
		student.setStatus(1);
		studentModel.insert(student);
		System.out.println("Add Success!");
		System.out.println("--------------------");
	}

	public void editStudent() {
		while (true) {
			System.out.println("Please enter ID Student: ");
			Scanner sc=new Scanner(System.in);
			String strSearch=sc.nextLine();
			int search = 0;
			try {
				search=Integer.parseInt(strSearch);
			} catch (Exception e) {
				System.out.println("Please enter a number");
				continue;
			}
			
			System.out.println("Rewrite your name: ");
			String name=sc.nextLine();
			System.out.println("Rewrite your email: ");
			String email=sc.nextLine();
			System.out.println("Rewrite your roll number: ");
			String rollNumber=sc.nextLine();
			System.out.println("Rewrite your class name: ");
			String className=sc.nextLine();
			System.out.println("Please enter status(0 or 1)");
			String status=sc.nextLine();
			int y=0;
			try {
                y = Integer.parseInt(status);
                Student student = new Student();
                student.setId(search);
                student.setName(name);
                student.setEmail(email);
                student.setRollNumber(rollNumber);
                student.setClassName(className);
                student.setStatus(y);
                studentModel.update(student);
                break;
            } catch (java.lang.NumberFormatException e) {
                System.err.println("Please enter a number for status");
                continue;
            }
		}
	}

	public void deleteStudent() {
		while(true){
			System.out.println("Please enter ID Student: ");
			Scanner sc=new Scanner(System.in);
			String strSearch=sc.nextLine();
			int search = 0;
			try {
				search=Integer.parseInt(strSearch);
			} catch (Exception e) {
				System.out.println("Please enter a number");
				continue;
			}
			studentModel.delete(search);
			break;
		}
	}

	public void saveFile() {
		ArrayList<Student> listStudent=studentModel.getList();
		System.out.println(listStudent);
		boolean test=studentModel.saveFile(listStudent, "e:\\data.txt");
		if (test==true) {
			System.out.println("Save file successfully");
		}else{
			System.out.println("Save file failed");
		}
	}

	public void readFile() {
		ArrayList<Student> listStudent=StudentModel.readFlie("e:\\data.txt");
		System.out.println("===== Student List =====");
		for (Student stu:listStudent) {
			System.out.println(stu);
		}
	}

}
