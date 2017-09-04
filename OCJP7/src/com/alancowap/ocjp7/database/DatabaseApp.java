/**
 * Simple class to demonstrate connecting to a database using JDBC 4 (since J2SE7)
 *  java.sql package 
 *  - DriverManager, Statement, ResultSet
 *  [Assumes you have appropriate drivers and DB to connect to]
 * 
 * @author Alan Cowap
 *
 */

package com.alancowap.ocjp7.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseApp {

	public static void main(String[] args) {
		System.out.println("Welcome to Database App");

		//Let's by default connect to this MySQL database
		String url = "jdbc:mysql://localhost:3306/TestDB";
		String username = "root";
		String password = "";		

		//Let the user specify the login credentials if they wish
		if(3 == args.length){
			url = args[0];
			username = args[1];
			password = args[2];
		}else{
			System.out.printf("Connecting to default DB with: url username password: <%s> <%s> <%s>\n", url, username, password);
			System.out.println("Alternatively you can use: DatabaseApp <database url> <username> <password>");
		}
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("SELECT * FROM TestTable");
			while(rs.next()){
				System.out.println("Test id: " + rs.getInt("IdColumn"));
				System.out.println("Test name: " + rs.getString("NameColumn"));
			}
			
		} catch (SQLException e) {
			System.out.println("Oops, a problem occurred with the Database.");
		}

	}

}
