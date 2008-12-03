package com.bonex.blog.action;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

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
	private HttpServletResponse servletResponse;
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
	 */
	public void setRequest(Map request) {
		this.request = request;
	}

	/**
	 * getServletResponse
	 * @return
	 */
	public HttpServletResponse getServletResponse() {
		return servletResponse;
	}

	/**
	 * setServletResponse
	 */
	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
		this.servletResponse.setCharacterEncoding("UTF-8");
	}

	/**
	 * getJsonResult
	 * @return
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
	 */
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	/**
	 * getServletContext
	 * @return
	 */
	public ServletContext getServletContext() {
		return this.context;
	}
	
	/**
	 * 主入口。一般不做操作
	 */
	public String execute() throws Exception {
		PrintWriter writer = getServletResponse().getWriter();
		JSONArray jsonObject = JSONArray.fromObject(doProcess());
		try {
			setJsonResult(jsonObject.toString());
		} catch (Exception e) {
			setJsonResult("FAILURE IN CONVERTING.");
		}
		writer.write(getJsonResult());
		return null;
	}

	abstract Object doProcess();


}
