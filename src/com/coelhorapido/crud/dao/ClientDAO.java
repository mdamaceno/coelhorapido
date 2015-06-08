package com.coelhorapido.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coelhorapido.crud.bd.ConnDatabase;
import com.coelhorapido.crud.model.Client;

public class ClientDAO {
	public void create(Client client) throws ClassNotFoundException,
			SQLException {
		String sql = "INSERT INTO clients (name, address, gender, email, password) "
				+ "VALUES (?,?,?,?,?);";

		Connection con = ConnDatabase.connection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, client.getName());
		ps.setString(2, client.getAddress());
		ps.setInt(3, client.getGender());
		ps.setString(4, client.getEmail());
		ps.setString(5, client.getPassword());

		ps.execute();
		ps.close();
		con.close();
	}

	public void destroy(Client client) throws ClassNotFoundException,
			SQLException {
		String sql = "DELETE FROM clients WHERE id = ?;";

		Connection con = ConnDatabase.connection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setLong(1, client.getId());

		ps.execute();
		ps.close();
		con.close();
	}

	public void update(Client client) throws ClassNotFoundException,
			SQLException {
		String sql = "UPDATE clients SET name=?, address=?, gender=?, email=?, password=? WHERE id=?;";

		Connection con = ConnDatabase.connection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, client.getName());
		ps.setString(2, client.getAddress());
		ps.setInt(3, client.getGender());
		ps.setString(4, client.getEmail());
		ps.setString(5, client.getPassword());
		ps.setLong(6, client.getId());

		ps.execute();
		ps.close();
		con.close();
	}

	public List<Client> index() throws ClassNotFoundException, SQLException {
		List<Client> lstClient = new ArrayList<Client>();

		String sql = "SELECT * FROM clients;";

		Connection con = ConnDatabase.connection();
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Client client = new Client();
			client.setId(rs.getLong("id"));
			client.setName(rs.getString("name"));
			client.setAddress(rs.getString("address"));
			client.setGender(rs.getInt("gender"));
			client.setEmail(rs.getString("email"));
			client.setPassword(rs.getString("password"));

			lstClient.add(client);
		}

		ps.close();
		con.close();

		return lstClient;
	}
}
