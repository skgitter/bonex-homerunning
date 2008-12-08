package com.bonex.sys.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bonex.sys.util.StringUtil;
import com.bonex.sys.util.XMLReader;

public class ExtBaseDao {
	
	/**
	 * SQL连接
	 */
	private Connection connection;

	/**
	 * Statement
	 */
	private Statement statement;

	/**
	 * DB的路径
	 */
	private String dbConfig;

	/**
	 * @return the conn
	 */
	public Connection getConnection() throws Exception{
		if (connection == null) {
			String dbConfig = getDbConfig();
			if (StringUtil.isEmpty(dbConfig)) {
				throw new Exception("不能访问数据库！不能找到DB配置文件！");
			} else {
				XMLReader xmlReader = new XMLReader(dbConfig);
				String dbPath = xmlReader.getDBPath();
				String dbAccessFileName = xmlReader.getDBAccessFilename();
				//String dbUser = xmlReader.getDBUsername();
				//String dbPass = xmlReader.getDBPassword();
				if (StringUtil.isEmpty(dbAccessFileName)) {
					throw new Exception("不能访问数据库！DB配置文件错误！");
				}
				dbPath = dbPath + File.pathSeparator + dbAccessFileName;
				String url = "jdbc:odbc:driver={Microsoft Access Driver "
					+ "(*.mdb)};DBQ=" + dbPath;
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				setConnection(DriverManager.getConnection(url));
			}
		}
		return connection;
	}

	/**
	 * @param conn the conn to set
	 */
	public void setConnection(Connection conn) {
		this.connection = conn;
	}

	/**
	 * @return the preparedStatement
	 */
	public Statement getStatement() throws Exception {
		if (getConnection() == null) {
			throw new Exception("DB连接不能为空");
		}
		if (this.statement == null) {
			this.statement = getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.FETCH_FORWARD);
		}
		return statement;
	}

	/**
	 * @param preparedStatement the preparedStatement to set
	 */
	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	/**
	 * @return the dBPath
	 */
	public String getDbConfig() {
		return dbConfig;
	}

	/**
	 * @param path the dBPath to set
	 */
	public void setDbConfig(String configPath) {
		this.dbConfig = configPath;
	};

	/**
	 * 用SQL查询
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public ResultSet queryBySql(String sql) throws Exception{
		ResultSet rs = null;
		Statement stmt = getStatement();
		if (stmt != null) {
			stmt.executeQuery(sql);
			rs = stmt.getResultSet();
		}
		return rs;
	}
	
	/**
	 * 用SQL更新
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public int updateBySql(String sql) throws Exception{
		int executed = 0;
		Statement stmt = getStatement();
		if (stmt != null) {
			stmt.executeUpdate(sql);
			executed = stmt.getUpdateCount();
		}
		return executed;
	}
	
	/**
	 * 用SQL删除
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public int deleteBySql(String sql) throws Exception{
		int executed = 0;
		Statement stmt = getStatement();
		if (stmt != null) {
			stmt.execute(sql);
			executed = stmt.getUpdateCount();
		}
		return executed;
	}
	
	/**
	 * 用SQL执行
	 */
	public int executeBySql(String sql) throws Exception{
		int executed = 0;
		Statement stmt = getStatement();
		if (stmt != null) {
			stmt.execute(sql);
			executed = stmt.getUpdateCount();
		}
		return executed;
	}
	
	/**
	 * 初始化
	 * @throws Exception
	 */
	public void init() throws Exception {
		if (StringUtil.isEmpty(getDbConfig())) {
			throw new Exception("无法获得DB连接！找不到配置文件");
		}
		getConnection();
		getStatement();
	}
}
