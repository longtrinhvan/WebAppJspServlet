package com.webapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;
import com.webapp.connection.connect;

public class billDao {
	private static final String INSERT_BILL= "{call PROCEDURE_InsertBill(?,?,?,?,?,?)}";
	private static final String SELECT_FUNCT_Id_USER_BUY= "{?= call FUNCTION_findBillwithIdUser(?)}";
	private static final String UPDATE_STATUS_BILL= "{call PROCEDURE_updateStatusBill(?,?)}";
	public int insertBill(int Iduserbuy,String Fullnamebuy,int Totalproduct,int TotalMoney, Date Datebuy , int statusbill) throws SQLException {
		Connection connection = null;
		connect conn = new connect();
		try {
			connection = conn.getConnection();
			CallableStatement statement = (CallableStatement) connection.prepareCall(INSERT_BILL);
			statement.setInt(1, Iduserbuy);
			statement.setString(2,Fullnamebuy);
			statement.setInt(3, Totalproduct);
			statement.setInt(4, TotalMoney);
			statement.setDate(5, Datebuy);
			statement.setInt(6, statusbill);
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

	public int updateStatusBill(int idBill, int StatusBill) {
		Connection connection = null;
		connect conn = new connect();
		try {
			connection = conn.getConnection();
			CallableStatement statement = (CallableStatement) connection.prepareCall(UPDATE_STATUS_BILL);
			statement.setInt(1, idBill);
			statement.setInt(2, StatusBill);
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
	
	public int FUNCTION_findBillwithIdUser(int  idUser) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connect conn = new connect();
		try {
			connection = conn.getConnection();
			CallableStatement statement = (CallableStatement) connection.prepareCall(SELECT_FUNCT_Id_USER_BUY);
			statement.setInt(2, idUser);
			statement.registerOutParameter(1, java.sql.Types.INTEGER);
			statement.execute();
			int id = statement.getInt(1);
			return id;
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
