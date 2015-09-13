package ilentt.ilenlab.com.conn;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {

	public ConnectionUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		return MySQLConnUtils.getMySQLConnection();
	}
	
	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
