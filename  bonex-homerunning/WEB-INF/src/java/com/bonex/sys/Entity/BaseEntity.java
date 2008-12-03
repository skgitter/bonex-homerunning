package com.bonex.sys.Entity;

import java.sql.Timestamp;


public class BaseEntity {
	
	private Timestamp createDtm;
	
	private Timestamp updateDtm;
	
	private String createUser;
	
	private String updateUser;
	
	private String isDel;
	
	private String createFuncId;
	
	private String updateFuncId;


	/**
	 * @return the createDtm
	 */
	public Timestamp getCreateDtm() {
		return createDtm;
	}

	/**
	 * @param createDtm the createDtm to set
	 */
	public void setCreateDtm(Timestamp createDtm) {
		this.createDtm = createDtm;
	}

	/**
	 * @return the updateDtm
	 */
	public Timestamp getUpdateDtm() {
		return updateDtm;
	}

	/**
	 * @param updateDtm the updateDtm to set
	 */
	public void setUpdateDtm(Timestamp updateDtm) {
		this.updateDtm = updateDtm;
	}

	/**
	 * @return the createUser
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * @param createUser the createUser to set
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	/**
	 * @return the updateUser
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * @param updateUser the updateUser to set
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * @return the isDel
	 */
	public String getIsDel() {
		return isDel;
	}

	/**
	 * @param isDel the isDel to set
	 */
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	/**
	 * @return the createFuncId
	 */
	public String getCreateFuncId() {
		return createFuncId;
	}

	/**
	 * @param createFuncId the createFuncId to set
	 */
	public void setCreateFuncId(String createFuncId) {
		this.createFuncId = createFuncId;
	}

	/**
	 * @return the updateFuncId
	 */
	public String getUpdateFuncId() {
		return updateFuncId;
	}

	/**
	 * @param updateFuncId the updateFuncId to set
	 */
	public void setUpdateFuncId(String updateFuncId) {
		this.updateFuncId = updateFuncId;
	}

	
}
