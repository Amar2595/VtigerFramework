package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class DataFromDataBaseJDBC {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
Driver driverRef = new Driver();
DriverManager.registerDriver(driverRef);
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teachers_info","root","root");
Statement stat = con.createStatement();
String SelectQuery = "select * from teachers;";
ResultSet result = stat.executeQuery(SelectQuery);
while(result.next())
{
	System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
}
con.close();
	}

}
