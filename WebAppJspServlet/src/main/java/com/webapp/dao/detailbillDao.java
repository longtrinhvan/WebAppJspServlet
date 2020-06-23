package com.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.webapp.connection.connect;
import com.webapp.model.detailbillModel;

public class detailbillDao {
	private static final String INSERT_DETAILBILL = "INSERT INTO detailbill(iddetailbill,idbill,idproductbuy,nameproductbuy,totalproduct,totalMoneypro)VALUES(?,?,?,?,?,?)";

	public void insertDetailBill(detailbillModel detailBill) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connect conn = new connect();
		try {
			connection = conn.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_DETAILBILL);
			preparedStatement.setInt(1, detailBill.getIddetailbill());
			preparedStatement.setInt(2, detailBill.getIdbill());
			preparedStatement.setInt(3, detailBill.getIdproductbuy());
			preparedStatement.setString(4, detailBill.getNameproductbuy());
			preparedStatement.setInt(5, detailBill.getTotalproduct());
			preparedStatement.setInt(6, detailBill.getTotalMoneypro());
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public List<detailbillModel> insertListDetailBill(List<detailbillModel> detailBill) throws SQLException {

		for (detailbillModel dlM : detailBill) {
			insertDetailBill(dlM);
		}

		return null;
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
