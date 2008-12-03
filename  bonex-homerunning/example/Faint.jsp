<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="../common/ext-header.jsp"%>
<body>
<h2>Faint!</h2>
<s:form>
	<s:textfield key="result"></s:textfield>
	<s:submit></s:submit>
</s:form>
<hr />
<s:iterator value="resultList">
    <s:property value="generalId"/>
	<s:property value="id" />
	<s:property value="date" />
	<s:property value="comment" />
	<s:property value="kanjyoKamokuId" />
	<s:property value="outgoing" />
	<s:property value="incoming" />

	<br />
</s:iterator>

<div id = "gridview"></div>
</body>
<script type="text/javascript">
Ext.namespace("test");
test.contextPath = "<%=contextPath%>";
</script>
<script type = "text/javascript" src="faint.js"></script>
</html>