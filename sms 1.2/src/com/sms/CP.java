package com.sms;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	static Connection con;
	public static Connection createC() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			String userName="root";
			String password="Boomer#5678";
			String url="jdbc:mysql://localhost:3306/student_manage";
			
			con=DriverManager.getConnection(url,userName, password);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
