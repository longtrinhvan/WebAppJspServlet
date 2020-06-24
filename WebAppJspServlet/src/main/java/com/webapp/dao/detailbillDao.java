package com.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.webapp.connection.connect;

public class detailbillDao {
	private static final String INSERT_DETAILBILL = "INSERT INTO detailbill(iddetailbill,idbill,idproductbuy,nameproductbuy,totalproduct,totalMoneypro)VALUES(null,?,?,?,?,?)";

	public void insertDetailBill(int Idbill,int Idproductbuy, String Nameproductbuy, int Totalproduct, int TotalMoneypro) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connect conn = new connect();
		try {
			connection = conn.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_DETAILBILL);
			preparedStatement.setInt(1, Idbill);
			preparedStatement.setInt(2, Idproductbuy);
			preparedStatement.setString(3, Nameproductbuy);
			preparedStatement.setInt(4, Totalproduct);
			preparedStatement.setInt(5, TotalMoneypro);
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
