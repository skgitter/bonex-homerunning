package com.bonex.sys.util;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bonex.sys.Entity.BaseEntity;

public class CommonDataUtil {

	/**
	 * 共通データ格納用のスレッドローカル
	 */
	private ThreadLocal<BaseEntity> memory = new ThreadLocal<BaseEntity>();

	/**
	 * 共通データの取得
	 * 
	 * @return SysCmnDataObj 共通データ
	 */
	public BaseEntity getCmnData() {
		BaseEntity ret = memory.get();
		return ret;
	}

	/**
	 * 共通データの設定
	 * 
	 * @param obj
	 *            共通データ
	 */
	public void setCmnData(BaseEntity obj) {
		if (null != obj) {
			memory.set(obj);
		}
	}

	@SuppressWarnings("unchecked")
	public CommonDataUtil(Class c) {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String accountName = (String) session.getAttribute("accountName");

		Timestamp today = DateUtil.formatStrTOStampBySmt(DateUtil
				.getCurrentDate(DateUtil.DATE_PATTERN_17),
				DateUtil.DATE_PATTERN_17);
		BaseEntity be = new BaseEntity();
		be.setCreateUser(accountName);
		be.setUpdateUser(accountName);
		be.setCreateDtm(today);
		be.setUpdateDtm(today);
		be.setCreateFuncId(c.getSimpleName());
		be.setUpdateFuncId(c.getSimpleName());

		setCmnData(be);
	}

}
