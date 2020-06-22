package com.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.CallableStatement;
import com.webapp.connection.connect;
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
public class replyDao {

	private static final String SELECT_REPLY = "SELECT idreply,idcommentreply ,iduserreply ,textreply , datereply ,username,fullname,roleid from reply,user where reply.idcommentreply =? and reply.iduserreply = user.iduser ORDER BY idreply ASC LIMIT ?,?";

	public static List<replyModel> Reply(int idcommentreply,int minLocationreply , int maxLocationreply) {
		List<replyModel> replys = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		connect conn = new connect();
		try {
			connection = conn.getConnection();
			CallableStatement statement = (CallableStatement) connection.prepareCall(SELECT_REPLY);
			statement.setInt(1, idcommentreply);
			statement.setInt(2, minLocationreply);
			statement.setInt(3, maxLocationreply);
			rs = statement.executeQuery();
			while (rs.next()) {
				replyModel reply = new replyModel();
				reply.setIdreply(rs.getInt("idreply"));
				reply.setIdcommentreply(rs.getInt("idcommentreply"));
				reply.setIduserreply(rs.getInt("iduserreply"));
				reply.setTextreply(rs.getString("textreply"));
				reply.setDatereply(rs.getDate("datereply"));

				userModel user = new userModel();
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setRoleid(rs.getInt("roleid"));
				reply.setUsermodel(user);
				replys.add(reply);
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
		return replys;
	}
	
	public List<replyModel> Reply1(int idcommentreply, int maxLocationrepl) {
		List<replyModel> replys = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		connect conn = new connect();
		try {
			connection = conn.getConnection();
			CallableStatement statement = (CallableStatement) connection.prepareCall(SELECT_REPLY);
			statement.setInt(1, idcommentreply);
			statement.setInt(2, maxLocationrepl);
			rs = statement.executeQuery();
			while (rs.next()) {
				replyModel reply = new replyModel();
				reply.setIdreply(rs.getInt("idreply"));
				reply.setIdcommentreply(rs.getInt("idcommentreply"));
				reply.setIduserreply(rs.getInt("iduserreply"));
				reply.setTextreply(rs.getString("textreply"));
				reply.setDatereply(rs.getDate("datereply"));

				userModel user = new userModel();
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setRoleid(rs.getInt("roleid"));
				reply.setUsermodel(user);
				replys.add(reply);
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
		return replys;
	}
	public boolean deleteReply(int id) throws SQLException {
		boolean rowDeleted;

		Connection connection = null;
		connect conn = new connect();
		PreparedStatement preparedStatement = null;
		connection = conn.getConnection();
		preparedStatement = connection.prepareStatement("DELETE FROM reply WHERE idreply=?");
		preparedStatement.setInt(1, id);
		rowDeleted = preparedStatement.executeUpdate() > 0;
		return rowDeleted;

	}
	
	public void insertReplyComment() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connect conn = new connect();
		try {
			connection = conn.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO reply(idreply,idcommentreply,iduserreply,textreply,datereply) VALUES(5,1,4,'Dạ còn tùy vào từng dòng chip cụ thể nữa anh nhé, anh vui lòng cho em thêm thông tin cụ thể về model(tên) sản phẩm anh đang quan tâm để em có thể hỗ trợ tốt hơn ạ Mong phản hồi từ anh.','2015-12-25 15:30:00')");
//			preparedStatement.setString(1, pro.getNameproduct());
//			preparedStatement.setInt(2, pro.getPrice());
//			preparedStatement.setInt(3, pro.getMarketprice());
//			preparedStatement.setInt(4, pro.getStatusid());
//			preparedStatement.setString(5, pro.getImage());
//			preparedStatement.setInt(6, pro.getProducerid());
//			preparedStatement.setInt(7, pro.getTotal());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
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

	public static List<replyModel> ReplyInPage(int idcommentreply ,int minLocationreply,int maxLocationreply) {
		return Reply(idcommentreply ,minLocationreply,maxLocationreply);
	}
	public List<replyModel> ReplyInPage1(int idcommentreply ,int minLocationreply,int maxLocationreply) {
		return Reply(idcommentreply ,minLocationreply, maxLocationreply);
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
