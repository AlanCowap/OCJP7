/**
 * Simple class to demonstrate connecting to a database using JDBC 4 (since J2SE7)
 *  java.sql package 
 *  - DriverManager, Statement, ResultSet
 *  [Assumes you have appropriate drivers and DB to connect to]
 *  
 *  You may find this eclipse tutorial on connecting to a Derby DB useful, similar available for MySQL, Oracle etc.
 *  https://help.eclipse.org/luna/index.jsp?topic=%2Forg.eclipse.datatools.common.doc.user%2Fdoc%2Fhtml%2Fasc1229700386276.html
 * 
 * If using Column titles (as in this example) consider using a Contract class as typically used in Android development.
 * You may have seen this notion in the class ../inner_classes/StaticOuter.java, or check out some of my Android repos.
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
		//N.B. It is generally not good practice to hardcode login credentials or connection details. We do so here for convenience only.
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
		
		//Lets take advantage of J2SE7s try-with-resources 
		
		try(Connection conn = DriverManager.getConnection(url, username, password);
				Statement sta = conn.createStatement();
				ResultSet rs = sta.executeQuery("SELECT * FROM TestTable") ){
				//ResultSet objects are closed automatically when the Statement that generated it is closed, but we'll include it here anyway.		
			
			while(rs.next()){
				int id =  rs.getInt("IdColumn");				//SQL INTEGER ~ int
				String name= rs.getString("NameColumn");		//SQL VARCHAR ~ java.lang.String
				java.sql.Date date = rs.getDate("DateColumn");	//SQL DATE ~ java.sql.Date (which extends java.util.Date)
			}			
		} catch (SQLException e) {
			System.out.println("Oops, a problem occurred with the Database.");
		}

	}

}
