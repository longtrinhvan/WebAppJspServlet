package com.webapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;
import com.webapp.connection.connect;

public class detailbillDao {
	private static final String INSERT_DETAILBILL = "{call PROCEDURE_InsertDetailbill(?,?,?,?,?)}";

	public int insertDetailBill(int idbillI,int idproductbuyI,String nameproductbuyI,int totalproductI,int totalMoneyproI) throws SQLException {
		Connection connection = null;
		connect conn = new connect();
		try {
			connection = conn.getConnection();
			CallableStatement statement = (CallableStatement) connection.prepareCall(INSERT_DETAILBILL);
			statement.setInt(1, idbillI);
			statement.setInt(2, idproductbuyI);
			statement.setString(3,nameproductbuyI);
			statement.setInt(4, totalproductI);
			statement.setInt(5, totalMoneyproI);
			statement.execute();
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				return 0;
			}
		}
		return 0;
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
