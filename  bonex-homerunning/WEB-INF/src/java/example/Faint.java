package example;

import java.sql.Date;
import java.util.List;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.bonex.sys.Entity.帳簿Entity;
import com.bonex.sys.dao.impl.帳簿DaoImpl;
import com.bonex.sys.util.DateUtil;
import com.bonex.sys.util.XMLReader;

public class Faint extends ExampleSupport {

	private static final Date DATE = new Date(2008, 10, 15);
	/**
	 * 
	 */
	private static final long serialVersionUID = 3997952823892011735L;
	private String faint;

	/**
	 * @return the faint
	 */
	public String getFaint() {
		return faint;
	}

	/**
	 * @param faint
	 *            the faint to set
	 */
	public void setFaint(String faint) {
		this.faint = faint;
	}

	private List<帳簿Entity> resultList;

	public void setResultList(List<帳簿Entity> resultList) {
		this.resultList = resultList;
	}

	public List<帳簿Entity> getResultList() {
		return this.resultList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		setFaint("damn");
		return SUCCESS;
	}

	public String wocao() throws Exception {
		// String path = getServletContext().getRealPath("/web-inf/db");
		if (null == getDao() || null == getDao().getConn())
			setResult("DIE");
		else {
			List li = getDao().query(new 帳簿Entity());
			setResultList(li);
			setResult("done");
		}
		String path = getServletContext().getRealPath("/web-inf/sqlfiles.xml");
		XMLReader xr = new XMLReader(path);
		System.out.println(xr.getSQLFile("a4"));
		
		System.out.println(xr.getSQLFile("a1"));
		return SUCCESS;
	}

	public String xocao() throws Exception {
		帳簿Entity insertEntity = new 帳簿Entity();
		insertEntity.setId(new Long(124));
		insertEntity.setDate(DateUtil.toDate("2008-10-15",DateUtil.DATE_PATTERN_17));
		insertEntity.setOutgoing("23.5");
		if (null == getDao() || null == getDao().getConn())
			setResult("DIE");
		else {
			int i = 0;
			i = getDao().insert(insertEntity);
			if (i == 1)
				setResult("done");
		}
		return SUCCESS;
	}
	public String yocao() throws Exception {
		帳簿Entity insertEntity = new 帳簿Entity();
		insertEntity.setGeneralId(new Long(8));
		insertEntity.setId(new Long(124));
		insertEntity.setDate(DateUtil.toDate("2008-10-15",DateUtil.DATE_PATTERN_17));
		insertEntity.setOutgoing("23.5");
		if (null == getDao() || null == getDao().getConn())
			setResult("DIE");
		else {
			int i = 0;
			i = getDao().update(insertEntity);
			if (i == 1)
				setResult("done");
		}
		return SUCCESS;
	}

	public String zocao() throws Exception {
		帳簿Entity insertEntity = new 帳簿Entity();
		insertEntity.setGeneralId(new Long(8));
		insertEntity.setIsDel("true");
		if (null == getDao() || null == getDao().getConn())
			setResult("DIE");
		else {
			int i = 0;
			i = getDao().delete(insertEntity);
			if (i == 1)
				setResult("done");
		}
		return SUCCESS;
	}
	@Override
	public void setDao() {
		this.dao = new 帳簿DaoImpl(getDBPath());
	}

	// public String cb() throws Exception {
	// setResult(Faint.class.toString());
	// return SUCCESS;
	// }
}
