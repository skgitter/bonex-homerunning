package com.bonex.blog.action;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("unchecked")
abstract public class AbstractBaseAction extends ActionSupport implements
		SessionAware, RequestAware, ServletResponseAware, ServletContextAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7427848759063768747L;

	/**
	 * Context
	 */
	private ServletContext context;
	
	/**
	 * Session Map from Struts2
	 */
	private Map session;
	
	/**
	 * Request Map from Struts2
	 */
	private Map request;
	
	/**
	 * Response HttpServletResponse from javax
	 */
	private HttpServletResponse response;
	
	/**
	 * JsonResult all result in Json;
	 */
	private String jsonResult;

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
	 * 主入口。一般不使用
	 * @return String
	 * @throws Exception
	 */
	public String execute() throws Exception {
		PrintWriter writer = getResponse().getWriter();
		writer.write(getJsonResult());
		return null;
	}
}
