package com.quanglinhit.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import com.quanglinhit.entity.Student;



public class StudentModel {
	private static ArrayList<Student> listStudent;
//	public static void main(String[] args) {
//		StudentModel stuModel=new StudentModel();
//		Student stu1=new Student(2, "Đức", "ducdm@gmail.com", "123","C1702G",1);
//		stuModel.insert(stu1);
//		
//		Student stu2=stuModel.getById(1);
////		System.out.println(stu2.toString());
//		
//	}
	
	public ArrayList<Student> getList() {
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
        	Connection cnn = DAO.getConnection();
	        PreparedStatement preStt=cnn.prepareStatement("SELECT * FROM student");
	        ResultSet rs=preStt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setRollNumber(rs.getString("roll_number"));
                student.setClassName(rs.getString("class_name"));
                student.setStatus(rs.getInt("status"));
                listStudent.add(student);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR" + ex.getMessage());
        }
        return listStudent;
    }

	public void insert(Student student) {
		try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt=cnn.prepareStatement("INSERT INTO student (name, email, roll_number, class_name, status) VALUES (?, ?, ?, ?, ?)");
            preStt.setString(1, student.getName());
            preStt.setString(2, student.getEmail());
            preStt.setString(3, student.getRollNumber());
            preStt.setString(4, student.getClassName());
            preStt.setInt(5, student.getStatus());
            System.out.println(preStt.execute());
            if (preStt.execute()==true) {
				System.out.println("Insert thanh cong!");
				
			}else{
				System.out.println("Insert ko thanh cong!");
				System.out.println(preStt.execute());
			}
        } 
		catch (SQLException e) {
            System.err.println("ERROR" + e.getMessage());
        }
	}

	public void update(Student student) {
		try {
			Connection conn=DAO.getConnection();
			PreparedStatement preStt=conn.prepareStatement("UPDATE student SET name=?, email=?, roll_number=?, class_name=?, status=? where id=?");
            preStt.setString(1, student.getName());
            preStt.setString(2, student.getEmail());
            preStt.setString(3, student.getRollNumber());
            preStt.setString(4, student.getClassName());
            preStt.setInt(5, (int)student.getStatus());
            preStt.setInt(6, (int)student.getId());
            if (preStt.executeUpdate()>0) {
				System.out.println("Update danh cong");
			}else{
				System.out.println("No data!!!");
			}
		} catch (Exception e) {
			System.err.println("ERROR" + e.getMessage());
		}
	}

	public void delete(Integer id) {
		try {
			Connection conn=DAO.getConnection();
			PreparedStatement preStt=conn.prepareStatement("DELETE FROM student where id=?");
            preStt.setInt(1, id);
            if (preStt.executeUpdate()>0) {
				System.out.println("Deleted");
			}else{
				System.out.println("No data!!!");
			}
		} catch (Exception e) {
			System.err.println("ERROR" + e.getMessage());
		}
	}
	
	public Student getById(int id){
		try {
	        Connection cnn = DAO.getConnection();
	        PreparedStatement preStt=cnn.prepareStatement("SELECT * FROM student WHERE id=?");
	        preStt.setInt(1, id);
	        ResultSet rs=preStt.executeQuery();
	        if (rs.next()) {
				Student stu=new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setEmail(rs.getString("email"));
				stu.setRollNumber(rs.getString("roll_number"));
				stu.setClassName(rs.getString("class_name"));
				stu.setStatus(rs.getInt("status"));
				return stu;
			} else {
				System.out.println("No data!!!");
			}
	    }catch (SQLException e) {
	            System.err.println("ERROR" + e.getMessage());
	    }
		return null;
	}
	
	public static boolean saveFile(ArrayList<Student> listStudent, String path){
		try{
			FileOutputStream fos=new FileOutputStream(path);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(listStudent);
			oos.close();
			fos.close();
			return true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	public static ArrayList<Student> readFlie(String path){
		ArrayList<Student> listStudent=new ArrayList<>();
		try {
			FileInputStream fis=new FileInputStream(path);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object data=ois.readObject();
			listStudent= (ArrayList<Student>) data;
			ois.close();
			fis.close();
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return listStudent;
	}

}
