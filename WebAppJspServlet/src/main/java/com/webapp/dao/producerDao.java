package com.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.CallableStatement;
import com.webapp.connection.connect;
import com.webapp.model.producerModel;

public class producerDao {
	public List<producerModel> SelectAll() {
		List<producerModel> producers = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		connect conn = new connect();
		try {
			connection = conn.getConnection();
			CallableStatement statement = (CallableStatement) connection.prepareCall("select *from producer");
			rs = statement.executeQuery();
			while (rs.next()) {
				producerModel pro = new producerModel();
				pro.setIdproducer(rs.getInt(1));
				pro.setNameproducer(rs.getString(2));
				producers.add(pro);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
		return producers;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
