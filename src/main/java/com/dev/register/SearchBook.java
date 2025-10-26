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

import com.mysql.cj.jdbc.result.ResultSetMetaData;

/**
 * Servlet implementation class SearchBook
 */
@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		String author=request.getParameter("aut");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vib","root","1857");
			PreparedStatement pst=con.prepareStatement("Select * from books where author=?");
			pst.setString(1, author);
			ResultSet rs = pst.executeQuery();
		    System.out.println("id\t\t Book name\t\t author name\t\t pages \t\t price");
		    
            // Condition check
//            while (rs.next()) {
// 
//                int id = rs.getInt("id");
//                String bname = rs.getString("bname");
//                String authorn = rs.getString("author");
//                String pages = rs.getString("author");
//                String price = rs.getString("author");
//                System.out.println(id + "\t\t" + bname
//                                   + "\t\t" + authorn + "\t\t" + pages+ "\t\t" + price);
//            }
           
//			
		    ResultSetMetaData rsmd=rs.getMetaData();  
		    int total=rsmd.getColumnCount();  
		    out.print("<tr>");  
		    for(int i=1;i<=total;i++)  
		    {  
		    out.print("<th>"+rsmd.getColumnName(i)+"</th>");  
		    }  
		      
		    out.print("</tr>");  
		                  
		    /* Printing result */  
		      
		    while(rs.next())  
		    {  
		    out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");  
		                      
		    }  
		      
		    out.print("</table>");  
			
		}catch(Exception e) {}
	}

}
