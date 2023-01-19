package jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class App1 {
	
	public static void main(String[] args) throws IOException, SQLException {
		
		
		Properties props=App1.getDbProperies();
		
		Connection con=DriverManager.getConnection(props.getProperty("url"),props.getProperty("user"),props.getProperty("password"));
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from film");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		
		
		
		
	}
	
	public static Properties getDbProperies() throws IOException {
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\MPawar\\Desktop\\mahesh\\learnings\\java\\git_projects\\JDBC\\jdbc_1\\workspace\\JDBC-Apps","db.properties"));
		Properties dbprops=new Properties();
		dbprops.load(fis);
		return dbprops;
	}

}
