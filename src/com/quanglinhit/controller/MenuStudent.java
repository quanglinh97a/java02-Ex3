package com.quanglinhit.controller;

import java.util.Scanner;

import com.quanglinhit.entity.Student;

public class MenuStudent {

	public static void main(String[] args) {
        MenuStudent menu = new MenuStudent();
        menu.createMenu();
    }
	
	public void createMenu() {
		while (true) {
			System.out.println("\t=====Student Manager=====");
			System.out.println("1. Student List");
			System.out.println("2. Add Student");
			System.out.println("3. Edit Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Export data to file");
			System.out.println("6. Import data from file");
			System.out.println("7. Exit");
			System.out.println("Choose [1-7]: ");
			Scanner sc = new Scanner(System.in);
			String strChoise = sc.nextLine();
			int choise=0;
			try {
				choise= Integer.parseInt(strChoise);
				System.out.println();
				if (choise<0 || choise>7) {
					throw new NumberFormatException("Please choise number from 1 to 7! ");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please choise a number!");
				continue;
			}
			
			StudentController studentContrl=new StudentController();
			switch (choise) {
				case 1: studentContrl.getList(); break;
				case 2: studentContrl.addStudent(); break;
				case 3: studentContrl.editStudent(); break;
				case 4: studentContrl.deleteStudent(); break;
				case 5: studentContrl.saveFile(); break;
				case 6: studentContrl.readFile(); break;
				case 7: System.exit(0);
				default: System.out.println("Please choise number from 1 to 7."); continue;
			}
		}

	}
}
