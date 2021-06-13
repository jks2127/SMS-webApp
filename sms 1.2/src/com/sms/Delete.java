package com.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<h1>delete servlet</h1>");
		
		int roll=Integer.parseInt(req.getParameter("st_roll"));
		
		Connection con=CP.createC();
		
		String q="delete from students where Roll=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setInt(1,roll);
			pstmt.executeUpdate();
			
			res.sendRedirect("Delete.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
