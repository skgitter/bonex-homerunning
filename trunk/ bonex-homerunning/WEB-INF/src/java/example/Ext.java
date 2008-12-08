package example;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.bonex.blog.action.AbstractBaseAction;
import com.bonex.sys.util.Constants;
import com.bonex.sys.util.JSONUtil;

public class Ext extends AbstractBaseAction {
	
	public Ext() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5868051872666032775L;

	private String result;

	private String _dc;
	
	public String get_dc() {
		return _dc;
	}

	public void set_dc(String _dc) {
		this._dc = _dc;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String execute() throws Exception {
		Words w=new Words();
//		w.setRoot("words");
		List<String> word = new ArrayList<String>();
		word.add("fuck struts2");
		word.add("fuck struts3");
		w.setWords("fuck struts2");
		w.setName("damend it");
		List<Words> w2=new ArrayList<Words>();
		
		w2.add(w);
		w2.add(w);
		
		Root rt=new Root();
		rt.setRoot(w2);
		
		JSONArray jsonObject = JSONArray.fromObject(w2);
        JSONObject jo=new JSONObject();
        jo.accumulate("root", jsonObject);
        jo.put("data", "failure");
        try {
            result = jo.toString();
        } catch (Exception e) {
            result = "ss";
        }
        //String x2="{images: [{name: 'Image one', url:'/GetImage.php?id=1', size:46.5, lastmod: new Date(2007, 10, 29)},{name: 'Image Two', url:'/GetImage.php?id=2', size:43.2, lastmod: new Date(2007, 10, 30)}]}";
		String x2="{success:true,words: [{word:'Fuck Struts2 and ExtJs'}]}";
        //result=x2;
        response.getWriter().write(result);
        return null;
	}

	public String write() throws Exception {
		response.getWriter().print("<script>alert('DAM!');" +
				"parent.extAlarm();</script>");
		return null;
	}
	/**
	 * 初始化查询表格的列
	 * @return
	 * @throws Exception
	 */
	public String initColumn() throws Exception {
		String sql = "SELECT * FROM 帳簿 WHERE 1=0";
		setDbConfigPath();
		getExtDao();
		ResultSet rs = extDao.queryBySql(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		StringBuffer columns = new StringBuffer();
		String colName = null;
		int i = 0;
		for (i = 0; i < rsmd.getColumnCount(); ++i) {
			colName = rsmd.getColumnName(i+1);
			columns.append("'" + colName + "',");
		}
		columns.setLength(columns.length()-1);
		String ret = "{success:true,data:[" + columns.toString() + "],count:" + i + "}";
		response.getWriter().print(ret);
		return null;
	}
	/**
	 * 查询数据
	 * @return
	 * @throws Exception
	 */
	public String getGridData() throws Exception {
		String sql = "SELECT * FROM 帳簿";
		setDbConfigPath();
		getExtDao();
		ResultSet rs = extDao.queryBySql(sql);
		int  i = 0;
		while (rs.next()) {
			i++;
		}
		rs.beforeFirst();
		String ret = JSONUtil.ResultSet2JSONString(rs);
		System.err.println(ret);
		response.getWriter().print(ret);
		return null;
	}

	public void setDbConfigPath() {
		dbConfigPath = getContext().getRealPath(Constants.XML_DB_DEFINITION);
	}
}
