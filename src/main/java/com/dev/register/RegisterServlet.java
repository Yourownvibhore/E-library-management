package com.dev.register;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bname=request.getParameter("book");
		String author=request.getParameter("author");
		String pages=request.getParameter("pages");
		String price=request.getParameter("price");
		RequestDispatcher dispatcher=null;
//		PrintWriter out=response.getWriter();
//		out.print(uname);
//		out.print(upwd);
//		out.print(email);
//		out.print(mobile);
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vib","root","1857");
			PreparedStatement pst=con.prepareStatement("insert into books(bname,author,pages,price) values(?,?,?,?)");
			pst.setString(1, bname);
			pst.setString(2, author);
			pst.setString(3, pages );
			pst.setString(4, price );
			pst.executeUpdate();
			dispatcher=request.getRequestDispatcher("addbook.html");
			dispatcher.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
