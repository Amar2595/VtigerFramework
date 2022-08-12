package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteupdateNonSQl {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tea","root","root");
		Statement stat =con.createStatement();
		String Query = "insert into tea(lemontea,milktea,cofee,badammilk)values('kalanamak','masala','black','kachabadam');";
		String Query1= "Delete from tea where cup=9;";
		int r = stat.executeUpdate(Query);
		int r1 = stat.executeUpdate(Query1);
		if(r==1)
		{
		System.out.println("one tea is crated");		
		}else {
		System.out.println("Tea is empty ''soorry");
		}
		if (r1==2) {
			System.out.println("deleted");
		}
		con.close();}}