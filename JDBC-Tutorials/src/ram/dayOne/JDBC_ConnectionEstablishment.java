package ram.dayOne;
import java.sql.*;
public class JDBC_ConnectionEstablishment
{

	public static void main(String[] args) 
	{
		boolean create,insert = true,retrive;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/ram","root","root");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement(); 
			
			stmt.execute("drop table Table001");
			System.out.println("table drop if exits..");
			Thread.sleep(4000);
			
			create=stmt.execute("create table Table001(id int,name varchar(225))");
			System.out.println("Table created Successfully..!");
			
			Thread.sleep(2000);
			if(create==false)  
			{
				insert=stmt.execute("insert into Table001 values(112,'suman')");
				insert=stmt.execute("insert into Table001 values(110,'Rocky')");
				Thread.sleep(15000);
				System.out.println("Data inserted Successfully...!");
			}
			if(insert==false)
			{
				System.out.println("retriving data from data base..");
				Thread.sleep(4000);
				/* retrive=stmt.execute("select * from Table001");
				System.out.println("Retrived success.."+retrive);*/
				ResultSet rs=stmt.executeQuery("select * from Table001");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"--"+rs.getString(2));
				}
			}
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}  

	}

}
