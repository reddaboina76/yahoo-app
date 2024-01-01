package com.yahoo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private String pwd;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		
		System.out.println("Registered Credentials Entered");
		System.out.println("Register Started");
		String Name = req.getParameter("name");
		String UserName = req.getParameter("UserName");
		String Password = req.getParameter("pwd");
		String MobileNumber = req.getParameter("mbl");
		String City = req.getParameter("city");
		String Country = req.getParameter("country");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver class is loaded!!");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yahoouser", "root", "root");
			System.out.println("connection is established!!");

			PreparedStatement ps = con.prepareStatement(
					"insert into yahooregistration(MAILID,NAME,MOBILE,CITY,COUNTRY,PASSWORD) values(?,?,?,?,?,?)");
			ps.setString(1, UserName);
			ps.setString(2, Name);
			ps.setString(3, pwd);
			ps.setString(4, MobileNumber);
			ps.setString(5, City);
			ps.setString(6, Country);


			con.close();
			System.out.println("data stored");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}