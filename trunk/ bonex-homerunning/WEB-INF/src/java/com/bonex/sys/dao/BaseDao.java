package com.bonex.sys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.bonex.sys.Entity.BaseEntity;
import com.bonex.sys.util.Constants;
import com.bonex.sys.util.StringUtil;
import com.bonex.sys.util.XMLReader;

abstract public class BaseDao implements Dao {

	private BaseEntity entity;

	private Connection conn;

	private PreparedStatement prst;

	private String DBPath;

	/**
	 * @return the dBPath
	 */
	public String getDBPath() {
		return DBPath;
	}

	/**
	 * @param path
	 *            the dBPath to set
	 */
	public void setDBPath(String path) {
		DBPath = path;
	}

	/**
	 * @return the entity
	 */
	public BaseEntity getEntity() {
		return entity;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	public void setEntity(BaseEntity entity) {
		this.entity = entity;
	}

	/**
	 * @return the conn
	 */
	public Connection getConn() {
		if (null == conn) {
			try {
				String url = "jdbc:odbc:driver={Microsoft Access Driver "
						+ "(*.mdb)};DBQ=" + getDBPath();
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conn = DriverManager.getConnection(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	/**
	 * @param conn
	 *            the conn to set
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public BaseDao() {

	}

	public BaseDao(String path) {
		setDBPath(path);
	}

	/**
	 * 
	 */
	public void close() {
		try {
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the prst
	 */
	public PreparedStatement getPrst() {
		return prst;
	}

	/**
	 * @param prst
	 *            the prst to set
	 */
	public void setPrst(PreparedStatement prst) {
		this.prst = prst;
	}

	public ResultSet sqlAction(String sql) {
		try {
			XMLReader xmlReader = new XMLReader(sql);
			String sqlfile = xmlReader.getSQLFile(sql);
			xmlReader = new XMLReader(sqlfile);
			String action = xmlReader.getNodeContent("action");
			if (StringUtil.isEmpty(action)) {
				return null;
			} else if (Constants.DB_ACTION_SQL.equals(action)) {
				Statement stmt = getConn().createStatement();
				String sqlContent = xmlReader.getNodeContent("sql-content");
				if (!StringUtil.isEmpty(sqlContent))
					stmt.execute(sqlContent);
				ResultSet rs = stmt.getResultSet();
				return rs;
			} else {
				List<String> actionId = xmlReader.getNodesByName("field");
				List<String> valueOfThem = xmlReader.getNodesByName("value");
				List<String> addtionOption = xmlReader.getNodesByName("option");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * 根据SQL问返回ResultSet
	 */
	public ResultSet queryBySql(String sql) {
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = this.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.FETCH_FORWARD);
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
