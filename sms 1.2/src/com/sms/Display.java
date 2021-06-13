package com.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		
		PrintWriter out=res.getWriter();
		out.println("<h2>display serrvlet</h2>");
		
		Connection con=CP.createC();
		String q="select * from students";
		
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(q);
			out.println("<table>");
			while(rs.next()) {
				out.println("<tr>" + "<td>");
				out.println(rs.getInt(1));
				out.println("</td>" + "<td>");
				out.println(rs.getString(2));
				out.println("</td>" + "<td>");
				out.println(rs.getInt(3));
				out.println("</td>" + "<td>");
				out.println(rs.getString(4));
				out.println("</td>"+"</tr>");
			}
			out.println("</table>");
			out.println("<a href="+ " Options.html" + "><button>Go Back</button></a>");

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
