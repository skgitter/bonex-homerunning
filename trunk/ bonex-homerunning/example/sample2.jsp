<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Reorder TreePanel</title>
<%@ include file="../common/ext-header.jsp" %>
<script type="text/javascript" src="example.js"></script>

<!-- Common Styles for the examples -->
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/ext/examples/samples.css" />
</head>
<body>
<script type="text/javascript" src="<%=contextPath%>/ext/examples/samples.js"></script> <!-- EXAMPLES -->
<h1>Drag and Drop ordering in a TreePanel</h1>
<p>This example shows basic drag and drop node moving in a tree. In this implementation there are no restrictions and 
anything can be dropped anywhere except appending to nodes marked &quot;leaf&quot; (the files). <br></p>
<p>Drag along the edge of the tree to trigger auto scrolling while performing a drag and drop.</p>
<p>In order to demonstrate drag and drop insertion points, sorting was <b>not</b> enabled.</p>
<p>The data for this tree is asynchronously loaded with a JSON TreeLoader.</p>
<p>The js is not minified so it is readable. See <a href="reorder.js">reorder.js</a>.</p>

<div id="tree-div" style="overflow:auto; height:300px;width:250px;border:1px solid #c3daf9;"></div>

</body>
</html>
