package com.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;
import com.webapp.connection.connect;
import com.webapp.model.userModel;

public class userDao {

	private static final String SELECT_FUNCT_USER_NAME = "{?= call FUNCTION_findNameUser(?)}";
	private static final String SELECT_PRO_USER = "{call PROCEDURE_findUser(?)}";
	private static final String INSERT_USER = "{call PROCEDURE_InsertUser(?,?,?)}";

	public int findNameUser(String userName) {
		Connection connection = null;
		connect conn = new connect();
		try {
			connection = conn.getConnection();
			CallableStatement statement = (CallableStatement) connection.prepareCall(SELECT_FUNCT_USER_NAME);
			statement.setString(2, userName);
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
			} catch (SQLException e) {
				return 0;
			}
		}
		return 0;
	}

	public userModel findUser(String userName) {
		userModel  usermodel =null;
		Connection connection = null;
		connect conn = new connect();
		ResultSet rs = null;
		try {
			connection = conn.getConnection();
			CallableStatement statement = (CallableStatement) connection.prepareCall(SELECT_PRO_USER);
			statement.setString(1, userName);
			rs = statement.executeQuery();	
			while (rs.next()) {
				usermodel = new userModel();
				usermodel.setIduser(rs.getInt(1));
				usermodel.setUsername(rs.getString(2));
				usermodel.setPassword(rs.getString(3));
				usermodel.setFullname(rs.getString(4));
				usermodel.setStatusid(rs.getInt(5));
				usermodel.setRoleid(rs.getInt(6));
			}
			return usermodel;
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
		return null;
	}

	public int InsertUser(String userName, String passWord, String fullName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connect conn = new connect();
		try {
			connection = conn.getConnection();
			CallableStatement statement = (CallableStatement) connection.prepareCall(INSERT_USER);
			statement.setString(1, userName);
			statement.setString(2, passWord);
			statement.setString(3, fullName);
			statement.execute();
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
