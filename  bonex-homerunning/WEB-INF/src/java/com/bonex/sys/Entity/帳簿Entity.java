package com.bonex.sys.Entity;

import java.util.Date;

/**
 * ����p��Entity
 * 
 * @author zhangzm
 * 
 */
public class 帳簿Entity extends BaseEntity {

	/**
	 * ��o��ID
	 */
	private Long generalId;
	/**
	 * �ԍ�
	 */
	private Long id;
	/**
	 * ������
	 */
	private Date date;
	/**
	 * ��e
	 */
	private String comment;
	/**
	 * ����Ȗ�_ID
	 */
	private Long kanjyoKamokuId;
	/**
	 * ���
	 */
	private String incoming;
	/**
	 * �x�o
	 */
	private String outgoing;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the kanjyoKamokuId
	 */
	public Long getKanjyoKamokuId() {
		return kanjyoKamokuId;
	}

	/**
	 * @param kanjyoKamokuId
	 *            the kanjyoKamokuId to set
	 */
	public void setKanjyoKamokuId(Long kanjyoKamokuId) {
		this.kanjyoKamokuId = kanjyoKamokuId;
	}

	/**
	 * @param generalId
	 *            the generalId to set
	 */
	public void setGeneralId(Long generalId) {
		this.generalId = generalId;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the gold
	 */
	public String getIncoming() {
		return incoming;
	}

	/**
	 * @param gold
	 *            the gold to set
	 */
	public void setIncoming(String gold) {
		this.incoming = gold;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the outgoing
	 */
	public String getOutgoing() {
		return outgoing;
	}

	/**
	 * @param outgoing
	 *            the outgoing to set
	 */
	public void setOutgoing(String outgoing) {
		this.outgoing = outgoing;
	}

	/**
	 * @return the generalId
	 */
	public Long getGeneralId() {
		return generalId;
	}

}
