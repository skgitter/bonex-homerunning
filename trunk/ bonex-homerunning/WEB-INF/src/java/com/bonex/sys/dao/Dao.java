package com.bonex.sys.dao;

import java.sql.ResultSet;
import java.util.List;

import com.bonex.sys.Entity.BaseEntity;

public interface Dao {

	public List<BaseEntity> query(BaseEntity entity);
	public int insert(BaseEntity entity);
	public int update(BaseEntity entity);
	public int delete(BaseEntity entity);
	public ResultSet queryBySql(String sql);
	public void close();
}
