package com.bonex.blog.action;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.bonex.sys.dao.ExtBaseDao;
import com.opensymphony.xwork2.ActionSupport;

import example.ExampleSupport;

@SuppressWarnings("unchecked")
abstract public class AbstractBaseAction extends ActionSupport implements
		SessionAware, RequestAware, ServletResponseAware, ServletContextAware {

	/**
	 * log4j
	 */
	protected Logger log = Logger.getLogger(ExampleSupport.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 7427848759063768747L;

	/**
	 * Context
	 */
	protected ServletContext context = null;
	
	/**
	 * Session Map from Struts2
	 */
	protected Map session = null;
	
	/**
	 * Request Map from Struts2
	 */
	protected Map request = null;
	
	/**
	 * Response HttpServletResponse from javax
	 */
	protected HttpServletResponse response = null;
	
	/**
	 * JsonResult all result in Json;
	 */
	private String jsonResult = null;
	
	/**
	 * Ext JS 用的DAO
	 */
	protected ExtBaseDao extDao = null;

	/**
	 * getSession
	 * @return
	 */
	public Map getSession() {
		return session;
	}

	/**
	 * setSession
	 */
	public void setSession(Map session) {
		this.session = session;
	}

	/**
	 * getRequest
	 * @return
	 */
	public Map getRequest() {
		return request;
	}

	/**
	 * setRequest
	 * @param Map
	 */
	public void setRequest(Map request) {
		this.request = request;
	}

	/**
	 * getServletResponse
	 * @return HttpServletResponse
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * setServletResponse
	 */
	public void setServletResponse(HttpServletResponse servletResponse) {
		this.response = servletResponse;
		this.response.setCharacterEncoding("UTF-8");
	}

	/**
	 * getJsonResult
	 * @return String
	 */
	public String getJsonResult() {
		return jsonResult;
	}

	/**
	 * setJsonResult
	 * @param jsonResult
	 */
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}
	
	/**
	 * setServletContext
	 * @param ServletContext
	 */
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	/**
	 * getServletContext
	 * @return ServletContext
	 */
	public ServletContext getContext() {
		return this.context;
	}
	
	/**
	 * 第一次调用时初始化Dao
	 * @return the extDao
	 */
	public ExtBaseDao getExtDao() throws Exception {
		if (extDao == null) {
			this.extDao = new ExtBaseDao();
			this.extDao.setDbConfig(getDbConfigPath());
			this.extDao.init();
		}
		return extDao;
	}

	/**
	 * @param extDao the extDao to set
	 */
	public void setExtDao(ExtBaseDao extDao) {
		this.extDao = extDao;
	}

	/**
	 * 主入口。一般不使用
	 * @return String
	 * @throws Exception
	 */
	public String execute() throws Exception {
		PrintWriter writer = getResponse().getWriter();
		writer.write(getJsonResult());
		return null;
	}
	
	/**
	 * 构造函数 
	 * @throws Exception
	 */
	public AbstractBaseAction() throws Exception{
		super();
//		setDbConfigPath();
//		getExtDao();
	}
	
	protected String dbConfigPath  = null;

	/**
	 * @return the dbConfigPath
	 */
	public String getDbConfigPath() {
		return this.dbConfigPath;
	};

	/**
	 * @param dbConfigPath the dbConfigPath to set
	 */
	public void setDbConfigPath(String dbConfigPath) {
		this.dbConfigPath = dbConfigPath;
	}
	
	abstract public void setDbConfigPath();
	
}
