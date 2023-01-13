package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDBUtil {
	
	private static boolean isSuccess; 
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static List<Customer> validate(String userName, String password){
		ArrayList<Customer> cus = new ArrayList<>();
		
		//validate database
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM customer WHERE username = '"+userName+"' AND password = '"+password+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				int idcustomer = rs.getInt(1);
				String name = rs.getNString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String userU = rs.getString(5);
				String passU = rs.getString(6);
				
				Customer c = new Customer(idcustomer, name, email, phone,userU,passU);
				cus.add(c);
				
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return cus;
	}
	
	public static boolean insertcustomer(String name, String email, String phone, String username, String password) {
		
		
		//create database connection
		
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "INSERT INTO customer VALUES (0,'"+name+"','"+email+"','"+phone+"','"+username+"','"+password+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static boolean updatecustomer(String id,String name, String email, String phone, String username, String password) {
		

		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "UPDATE customer SET name = '"+name+"', email = '"+email+"',phone = '"+phone+"', username = '"+username+"', password  = '"+password+"'"
					+ "WHERE idcustomer = '"+id+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	public static List<Customer> getCustomerDetails(String Id){
		
		ArrayList<Customer> cus = new ArrayList<>();
		
		int convertedId = Integer.parseInt(Id);
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM customer WHERE idcustomer = '"+convertedId+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);
				
				Customer c = new Customer(id,name,email,phone,username,password) ;
					cus.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cus;
	}
	public static boolean deleteCustomer(String id) {
		
		int conId = Integer.parseInt(id);
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "DELETE FROM customer WHERE idcustomer = '"+conId+"'";
			int r = stmt.executeUpdate(sql);
			
			if (r > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
}
