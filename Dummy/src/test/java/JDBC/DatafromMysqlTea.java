package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatafromMysqlTea {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
Driver d = new Driver();
DriverManager.registerDriver(d);
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tea","root","root");
Statement stat =con.createStatement();
String Query = "select * from tea;";
ResultSet r = stat.executeQuery(Query);
while(r.next())
{
	System.out.println(r.getInt(1)+"\t"+r.getString(2)+"\t"+r.getString(3)+"\t"+r.getString(4));
	
}
System.out.println("Take tea and get refresh");
con.close();
	}

}
