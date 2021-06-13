package com.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Modify extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		out.println("modify servlet");
		
		int roll=Integer.parseInt(req.getParameter("st_roll"));
		String name=req.getParameter("st_name");
		int phone=Integer.parseInt(req.getParameter("st_phone"));
		String address=req.getParameter("st_address");
		
		Connection con=CP.createC();
		
		String q="update students set Name=?, PhoneNo=?, Address=? where Roll=? ";
		
		try {
			PreparedStatement pstmt=con.prepareStatement(q);
			
			pstmt.setString(1, name);
			pstmt.setInt(2, phone);
			pstmt.setString(3, address);
			pstmt.setInt(4, roll);
			
			pstmt.executeUpdate();	
			
			res.sendRedirect("Modify.html");			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
