package com.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Add")
public class Add extends HttpServlet{
	private static final long serialVersionUID = 8458211563686707083L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=res.getWriter();
		
		StudentData st=new StudentData();
		
		st.setRoll(Integer.parseInt(req.getParameter("st_roll")));
		st.setName(req.getParameter("st_name"));
		st.setPhone(Integer.parseInt(req.getParameter("st_phone")));
		st.setAddress(req.getParameter("st_address"));
		
		Connection con=CP.createC();
		String q="insert into students values(?,?,?,?)";
		try {
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setInt(1, st.getRoll());
			pstmt.setString(2, st.getName());
			pstmt.setInt(3, st.getPhone());
			pstmt.setString(4, st.getAddress());
			
			pstmt.executeUpdate();
			out.println("<h3>Student info added successfully</h3>" + "<a href='Add.html'><button>Go back</button></a>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
