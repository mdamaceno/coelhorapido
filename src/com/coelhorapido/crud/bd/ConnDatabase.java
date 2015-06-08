package com.coelhorapido.crud.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDatabase {
	public static Connection connection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/coelhorapido";
		String user = "root";
		String password = "marco";

		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
	
	public static void main(String[] args) {
		try {
			connection();
			System.out.println("Conexão bem sucedida");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
