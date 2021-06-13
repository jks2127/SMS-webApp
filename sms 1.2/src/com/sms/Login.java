package com.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
			out.println("<h2>hello this is login servlet</h2>");
		Credentials cred=new Credentials();	
		
		cred.setUserName(req.getParameter("user_name"));
		cred.setPassword(req.getParameter("user_pswd"));
		
		Connection con=CP.createC();
		
		
		try {
			String q="select * from login";

			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery(q);
			
			if(rs.next()) {
				String usr=rs.getString(1);
				String pswd=rs.getString(2);
				
				if(cred.getUserName().equals(usr) && cred.getPassword().equals(pswd) ) {
					out.println("<h1>login success</h1>");
					res.sendRedirect("Options.html");
					
				}else {
					out.println("<h3>Wrong username and password combination</h3>");
					out.println("<a href='index.html'><button>Try again</button></a>");
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
