package com.bonex.sys.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bonex.sys.Entity.BaseEntity;
import com.bonex.sys.dao.BaseEditDao;
import com.bonex.sys.util.DaoUtil;
import com.bonex.sys.Entity.帳簿Entity;

public class 帳簿DaoImpl extends BaseEditDao {

	public 帳簿DaoImpl(String path) {
		super(path);
	}

	/**
	 * 
	 */
	public List<BaseEntity> query(BaseEntity baseEntity) {
		List<BaseEntity> resultList = new ArrayList<BaseEntity>();
		帳簿Entity queryEntity = (帳簿Entity) baseEntity;
		String tableName = DaoUtil.formatTableName(queryEntity);
		String sql = "SELECT * FROM " + tableName + " WHERE 削除="
				+ DaoUtil.formatDeleteFalse(queryEntity.getIsDel());
		try {
			PreparedStatement prst = getConn().prepareStatement(sql);
			ResultSet rs = prst.executeQuery();
			while (rs.next()) {
				帳簿Entity itemEntity = new 帳簿Entity();
				itemEntity.setGeneralId(rs.getLong("入出庫ID"));
				itemEntity.setId(rs.getLong("番号"));
				itemEntity.setOutgoing(rs.getString("支出"));
				itemEntity.setIncoming(rs.getString("収入"));
				itemEntity.setDate(rs.getDate("発生日"));
				itemEntity.setComment(rs.getString("内容"));
				itemEntity.setKanjyoKamokuId(rs.getLong("勘定科目ID"));
				resultList.add(itemEntity);
			}
			rs.close();
			prst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}

	public int delete(BaseEntity baseEntity) {
		int deleted = 0;
		帳簿Entity deleteEntity = (帳簿Entity) baseEntity;
		String tableName = DaoUtil.formatTableName(deleteEntity);
		String sql = "UPDATE " + tableName + " SET 削除="
				+ deleteEntity.getIsDel() + " WHERE 入出庫ID="
				+ deleteEntity.getGeneralId();
		System.out.println(sql);
		try {
			Statement stmt = getConn().createStatement();
			stmt.executeUpdate(sql);
			deleted = stmt.getUpdateCount();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleted;
	}

	public int insert(BaseEntity baseEntity) {
		int inserted = 0;
		帳簿Entity insertEntity = (帳簿Entity) baseEntity;
		String tableName = DaoUtil.formatTableName(insertEntity);
		String sql = "INSERT INTO " + tableName
				+ " (番号,発生日,内容,勘定科目ID,支出,収入) VALUES (" + insertEntity.getId()
				+ " , " + DaoUtil.formatDateToAccess(insertEntity.getDate())
				+ " , " + DaoUtil.formatStringNull(insertEntity.getComment())
				+ " , " + insertEntity.getKanjyoKamokuId() + " , "
				+ DaoUtil.formatMoneyZero(insertEntity.getOutgoing()) + " , "
				+ DaoUtil.formatMoneyZero(insertEntity.getIncoming()) + ")";
		System.out.println(sql);
		try {
			Statement stmt = getConn().createStatement();
			stmt.executeUpdate(sql);
			inserted = stmt.getUpdateCount();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inserted;
	}

	public int update(BaseEntity baseEntity) {
		int updated = 0;
		帳簿Entity updateEntity = (帳簿Entity) baseEntity;
		String tableName = DaoUtil.formatTableName(updateEntity);
		String sql = "UPDATE " + tableName + " SET 番号=" + updateEntity.getId()
				+ "," + "発生日="
				+ DaoUtil.formatDateToAccess(updateEntity.getDate()) + ","
				+ "内容=" + DaoUtil.formatStringNull(updateEntity.getComment())
				+ "," + "勘定科目ID=" + updateEntity.getKanjyoKamokuId() + ","
				+ "支出=" + DaoUtil.formatMoneyZero(updateEntity.getOutgoing())
				+ "," + "収入="
				+ DaoUtil.formatMoneyZero(updateEntity.getIncoming())
				+ " WHERE 入出庫ID=" + updateEntity.getGeneralId();
		System.out.println(sql);
		try {
			Statement stmt = getConn().createStatement();
			stmt.executeUpdate(sql);
			updated = stmt.getUpdateCount();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updated;
	}

}
