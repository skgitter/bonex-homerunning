package com.bonex.sys.util;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bonex.sys.Entity.BaseEntity;

public class CommonDataUtil {

	/**
	 * ���ʃf�[�^�i�[�p�̃X���b�h���[�J��
	 */
	private ThreadLocal<BaseEntity> memory = new ThreadLocal<BaseEntity>();

	/**
	 * ���ʃf�[�^�̎擾
	 * 
	 * @return SysCmnDataObj ���ʃf�[�^
	 */
	public BaseEntity getCmnData() {
		BaseEntity ret = memory.get();
		return ret;
	}

	/**
	 * ���ʃf�[�^�̐ݒ�
	 * 
	 * @param obj
	 *            ���ʃf�[�^
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
