package com.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.webapp.connection.connect;
import com.webapp.model.billModel;

public class billDao {
	private static final String INSERT_BILL= "INSERT INTO bill(idbill,iduserbuy,fullnamebuy,totalproduct,totalMoney,datebuy)VALUES(?,?,?,?,?,?)";
	public void insertBill(billModel bill) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connect conn = new connect();
		try {
			connection = conn.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_BILL);
			preparedStatement.setInt(1, bill.getIdbill());
			preparedStatement.setInt(2, bill.getIduserbuy());
			preparedStatement.setString(3, bill.getFullnamebuy());
			preparedStatement.setInt(4, bill.getTotalproduct());
			preparedStatement.setInt(5, bill.getTotalMoney());
			preparedStatement.setDate(6, bill.getDatebuy());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	private static void printSQLException(SQLException ex) {
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
