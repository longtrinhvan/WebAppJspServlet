package com.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.CallableStatement;
import com.webapp.connection.connect;
import com.webapp.model.productModel;

/**
 * @author DELL
 *
 */
/**
 * @author DELL
 *
 */
public class productDao {

	private static final String SELECT_PRODUCT = "SELECT *from product where producerid =?";
	private static final String PRODUCT = "SELECT *from product where idproduct =?";

	public productModel find_Product(String idproduct) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		connect conn = new connect();
		productModel productmodel = null;
		try {
			connection = conn.getConnection();
			CallableStatement statement = (CallableStatement) connection.prepareCall(PRODUCT);
			statement.setInt(1, Integer.parseInt(idproduct));
			rs = statement.executeQuery();
			while (rs.next()) {
				productmodel = new productModel();
				productmodel.setIdproduct(rs.getInt(1));
				productmodel.setNameproduct(rs.getString(2));
				productmodel.setPrice(rs.getInt(3));
				productmodel.setMarketprice(rs.getInt(4));
				productmodel.setImage(rs.getString(6));
				productmodel.setProducerid(rs.getInt(7));
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
		return productmodel;
	}

	public List<productModel> PRO_Pagination(int producerid, String page) {
		List<productModel> products = new ArrayList<>();
		List<productModel> producstInPage = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		connect conn = new connect();
		try {
			connection = conn.getConnection();
			CallableStatement statement = (CallableStatement) connection.prepareCall(SELECT_PRODUCT);
			statement.setInt(1, producerid);
			rs = statement.executeQuery();
			while (rs.next()) {
				productModel productmodel = new productModel();
				productmodel.setIdproduct(rs.getInt(1));
				productmodel.setNameproduct(rs.getString(2));
				productmodel.setPrice(rs.getInt(3));
				productmodel.setMarketprice(rs.getInt(4));
				productmodel.setImage(rs.getString(6));
				productmodel.setProducerid(rs.getInt(7));
				products.add(productmodel);
			}
			producstInPage = InPage(page, products, products.size());
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
		return producstInPage;
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

	public String producerid(int producerid) {
		return String.valueOf(producerid);
	}

	public List<productModel> InPage(String page, List<productModel> products, int total) {
		int intPage = 0;
		if (page == null) {
			intPage = 1;
		} else {
			intPage = Integer.parseInt(page);
		}
		List<productModel> paginationProduct = new ArrayList<>();
		for (int i = (intPage - 1) * 12; i < intPage * 12; i++) {
			if (i >= total) {
				return paginationProduct;
			}
			paginationProduct.add(products.get(i));
		}
		return paginationProduct;
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
