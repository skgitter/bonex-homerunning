package com.bonex.sys.util;

import java.util.Date;

import com.bonex.sys.Entity.BaseEntity;

public class DaoUtil {

	static public String formatTableName(BaseEntity entity) {
		String entityName = entity.getClass().getSimpleName();
		String tableName = entityName.replace("Entity", "");
		if (entity.getClass().getSimpleName().matches("[A-Za-z]")) {
			return StringUtil.formatDBTableName(tableName);
		} else {
			return tableName;
		}

	}

	static public String formatDateToAccess(Date date) {
		return "'" + DateUtil.formatDate(date, DateUtil.DATE_PATTERN_17) + "'";
	}

	static public String formatStringNull(String string) {
		if (null != string) {
			return "'" + string + "'";
		} else {
			return null;
		}
	}

	static public String formatMoneyZero(String i) {
		if (null != i) {
			return i;
		} else {
			return "0";
		}
	}
	
	static public String formatDeleteFalse(String delete) {
		if (null == delete) {
			return Constants.FALSE;
		} else {
			return delete;
		}
	}
}
