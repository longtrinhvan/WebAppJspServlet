package com.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.CallableStatement;
import com.webapp.connection.connect;
import com.webapp.model.commentModel;
import com.webapp.model.replyModel;
import com.webapp.model.userModel;

/**
 * @author DELL
 *
 */
/**
 * @author DELL
 *
 */
public class commentDao {

	private static final String SELECT_COMMENT = "SELECT idcomment,idproductcomment ,idusercomment ,textcomment , datecomment ,username,fullname from comment,user where comment.idproductcomment =? and comment.idusercomment = user.iduser and statusid=1 ORDER BY idcomment ASC LIMIT ?,?";
	public List<commentModel> Comment(int idproductcomment, int minLocation, int maxLocation,
			int maxLocationreply) {
		List<commentModel> comments = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		connect conn = new connect();
		try {
			connection = conn.getConnection();
			CallableStatement statement = (CallableStatement) connection.prepareCall(SELECT_COMMENT);
			statement.setInt(1, idproductcomment);
			statement.setInt(2, minLocation);
			statement.setInt(3, maxLocation);
			rs = statement.executeQuery();
			while (rs.next()) {
				commentModel comm = new commentModel();
				comm.setIdcomment(rs.getInt("idcomment"));
				comm.setIdusercomment(rs.getInt("idusercomment"));
				comm.setTextcomment(rs.getString("textcomment"));
				comm.setDatecomment(rs.getDate("datecomment"));

				userModel user = new userModel();
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				comm.setUsermodel(user);
				List<replyModel> replys = new ArrayList<>();
				replys= replyDao.ReplyInPage(rs.getInt("idcomment"),0,maxLocationreply);
				comm.setReplymodel(replys);
				comments.add(comm);
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
		return comments;
	}

	/* Pagination */

	public String locationPage(String page) {
		if (page == null) {
			return "0";
		}
		int locationPage = 0;
		if ((Integer.parseInt(page) % 5) > 0) {
			locationPage = Integer.parseInt(page) % 5;
		} else if ((Integer.parseInt(page) % 5) == 0) {
			locationPage = 5;
		}
		return String.valueOf(locationPage - 1);
	}

	public String idproductcomment(String idproductcomment) {
		return idproductcomment;
	}

	public List<commentModel> CommentInPage(int idproductcomment, String page, int minLocationreply,
			int maxLocationreply) {
		int minLocation = 0;
		int maxLocation = 0;
		if (page == null ||page.equals("0")) { 
			maxLocation = 5;
		} else {
			maxLocation = Integer.parseInt(page) * 5;
		}
		minLocation = maxLocation - 5;
		return Comment(idproductcomment, minLocation, maxLocation,maxLocationreply);
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
