package com.dev.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchBo
 */
@WebServlet("/SearchBo")
public class SearchBo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		String author=request.getParameter("aut");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vib","root","1857");
			PreparedStatement pst=con.prepareStatement("Select * from books where author=?");
			PreparedStatement p=con.prepareStatement("Select count(*) as p from books");
			pst.setString(1, author);
			ResultSet rs = pst.executeQuery();
			ResultSet r = p.executeQuery();
    		PrintWriter pw = response.getWriter();
    		response.setContentType("text/html");
    		pw.println("<html><body>");
            pw.println("<table border=1 width=50% height=50%>");  
            pw.println("<tr><th>id</th><th>Book name</th><th>Author name</th><th>pages</th><th>price</th><tr>");  
            while (rs.next()) {
 
                int id = rs.getInt("id");
                String bname = rs.getString("bname");
                String authorn = rs.getString("author");
                String pages = rs.getString("pages");
                String price = rs.getString("price");
                pw.println("<tr><td>"+id+"</td><td>" + bname + "</td><td>" + authorn + "</td><td>" + pages + "</td><td>"+ price+"</td></tr>");   
            }  
            String count = r.getString("p");
            pw.println("</table>");  
            pw.println("<p> total books available ="+count);
            pw.println("</html></body>");  
            con.close();  
     

			
		}catch(Exception e) {}
	}

}
