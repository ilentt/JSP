package ilentt.ilenlab.com.utils;

import ilentt.ilenlab.com.beans.Account;
import ilentt.ilenlab.com.beans.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

	public DBUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static Account findUser(Connection conn, String username, String password) throws SQLException, ClassNotFoundException {
		String sql = "SELECT a.UserName, a.PassWord, a.Gender FROM Account a " +
				"WHERE a.UserName = ? AND a.PassWord = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, username);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			String gender = rs.getString("Gender");
			Account account = new Account();
			account.setUsername(username);
			account.setPassword(password);
			account.setGender(gender);
			return account;
		}
		return null;
	}
	
	public static Account findUser(Connection conn, String username) throws SQLException {
		String sql = "SELECT a.UserName, a.PassWord, a.Gender FROM Account a " +
				"WHERE a.UserName = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, username);
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			String password = rs.getString("PassWord");
			String gender = rs.getString("Gender");
			Account account = new Account();
			account.setUsername(username);
			account.setPassword(password);
			account.setGender(gender);
			return account;
		}
		return null;
	}
	
	public static List<Product> getProduct(Connection conn) throws SQLException {
		String sql = "SELECT p.Code, p.Name, p.Price FROM Product p";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Product> products = new ArrayList<Product>();
		if(rs.next()) {
			String code = rs.getString("Code");
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			Product p = new Product();
			p.setCode(code);
			p.setName(name);
			p.setPrice(price);
			products.add(p);
			return products;
		}
		return null;
	}
	
	public static Product findProduct(Connection conn, String code) throws SQLException, ClassNotFoundException {
		String sql = "SELECT p.Code, p.Name, p.Price FROM Product p WHERE p.Code = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, code);
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			Product p = new Product(code, name, price);
			return p;
		}
		return null;
	}
	
	public static void updateProduct(Connection conn, Product p) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE Product SET Name = ?, Price = ? WHERE Code = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, p.getName());
		pstm.setDouble(2, p.getPrice());
		pstm.setString(3, p.getCode());
		pstm.executeUpdate();
	}
	
	public static void insertProduct(Connection conn, Product p) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO Product(Code, Name, Price) VALUES(?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, p.getCode());
		pstm.setString(2, p.getName());
		pstm.setDouble(3, p.getPrice());
		pstm.executeUpdate();
	}
	
	public static void deleteProduct(Connection conn, Product p) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM Product p WHERE p.Code = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, p.getCode());
		pstm.executeUpdate();
	}
}
