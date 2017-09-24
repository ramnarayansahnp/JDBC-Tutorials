package ram.dayOne;
import java.sql.*;
public class ScrollableResultSet {

	public static void main(String[] args) 
	{
		try{
			 
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/ram","root","root");  
			  
			 
Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
			ResultSet rs=stmt.executeQuery("select * from Table001");  
			  
			//getting the record of 3rd row  
			rs.absolute(3);  
			System.out.println(rs.getString(1)+" "+rs.getString(2));  
			  
			con.close();  
		}catch(Exception e){}
		

	}

}
