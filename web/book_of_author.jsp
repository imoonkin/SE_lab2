<%@ page import="pack.act" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<s:form action="returnHome">
    <s:submit  value="Home" type="button"/>
</s:form>
<table border="1">
    <tr>
        <th>id</th>
        <th>author</th>
        <th>book name</th>
        <th>comment</th>
        <th>handle</th>
    </tr>
    <s:iterator value="#request.itemlist" id="mycontent" status="status">
    <tr>
        <td><s:property value="#mycontent.id"/></td>
        <td><s:property value="#mycontent.author"/></td>
        <td><s:property value="#mycontent.bookname"/></td>
        <td><s:property value="#mycontent.comment"/></td>
        <td><a href="delete.action?id=<s:property
                    value="#mycontent.id"/>">delete</a></td>
    </tr>
    </s:iterator>



</body>
</html>
