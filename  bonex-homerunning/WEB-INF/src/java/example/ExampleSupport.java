/*
 * $Id: ExampleSupport.java 471756 2006-11-06 15:01:43Z husted $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package example;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.bonex.sys.dao.BaseDao;
import com.bonex.sys.util.CommonDataUtil;
import com.bonex.sys.util.Constants;
import com.bonex.sys.util.XMLReader;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Base Action class for the Tutorial package.
 */
@SuppressWarnings("unchecked")
public abstract class ExampleSupport extends ActionSupport implements SessionAware,
		ServletContextAware,ServletResponseAware {
	
	protected HttpServletResponse response;
	
	private Logger logger = Logger.getLogger(ExampleSupport.class);

	private String DBPath;

	protected BaseDao dao;

	private Map session;
	/**
	 * 
	 */
	private static final long serialVersionUID = 3515078654701117288L;

	private String result;

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	public String cb() throws Exception {
		session.put("accountName", "damned");
		setResult("Here");
		return SUCCESS;
	}

	public String db() throws Exception {
		setResult((String) session.get("accountName"));
		return SUCCESS;
	}

	public String eb() throws Exception {
		CommonDataUtil cdu = new CommonDataUtil(this.getClass());
		setResult(cdu.getCmnData().getUpdateUser());
		return SUCCESS;
	}

	public String execute() throws Exception {

		return SUCCESS;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	private ServletContext context;

	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	public ServletContext getServletContext() {
		return this.context;
	}

	public String getDBPath() {
		if (null == this.DBPath) {
			String path = getServletContext().getRealPath(
					Constants.XML_DB_DEFINITION);
			XMLReader xmlReader = new XMLReader(path);
			String dbPath = getServletContext().getRealPath(
					xmlReader.getDBPath() + "/"
							+ xmlReader.getDBAccessFilename());
			setDBPath(dbPath);
			logger.info(getDBPath() + " IN getDBPath FROM XML");
		}
		return DBPath;
	}

	public void setDBPath(String path) {
		DBPath = path;
	}

	abstract public void setDao();

	public BaseDao getDao() {
		
		if (null == getDBPath())
			throw new NullPointerException("DBPath is NULL.");
		
		setDao();
	
		return this.dao;
	}
	
	public void setServletResponse(HttpServletResponse resp) {
		this.response = resp;
		response.setCharacterEncoding("UTF-8");
	}
}
