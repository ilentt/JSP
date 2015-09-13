package ilentt.ilenlab.com.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnUtils {

	public MySQLConnUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
		String hostname = "localhost";
		String dbname = "JSPAPP";
		String username = "root";
		String password = "123456";
		return getMySQLConnection(hostname, dbname, username, password);
	}
	
	public static Connection getMySQLConnection(String hostname, String dbname, String username, String password) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String connectionURL = "jdbc:mysql://" + hostname + ":3306/" + dbname;
		Connection conn = DriverManager.getConnection(connectionURL, username, password);
		return conn;
	}
}
