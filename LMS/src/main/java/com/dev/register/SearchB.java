package com.dev.register;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

	}

}
