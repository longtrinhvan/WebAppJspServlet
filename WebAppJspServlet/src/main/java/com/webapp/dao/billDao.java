package com.webapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.webapp.connection.connect;

public class billDao {
	private static final String INSERT_BILL= "INSERT INTO bill(idbill,iduserbuy,fullnamebuy,totalproduct,totalMoney,datebuy)VALUES(null,?,?,?,?,?)";
	public void insertBill(int Iduserbuy,String Fullnamebuy,int Totalproduct,int TotalMoney, Date Datebuy) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connect conn = new connect();
		try {
			connection = conn.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_BILL);
			preparedStatement.setInt(1, Iduserbuy);
			preparedStatement.setString(2,Fullnamebuy);
			preparedStatement.setInt(3, Totalproduct);
			preparedStatement.setInt(4, TotalMoney);
			preparedStatement.setDate(5, Datebuy);
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
