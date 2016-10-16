<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="returnHome">
    <s:submit  value="Home" type="button"/>
</s:form>
<br>
<s:form action="searchauthor">
    <s:textfield label="Name (eg. 'name1' or 'name2' or 'name33_John')" name="name"/>
    <s:submit value="search this name qwq"/>
</s:form>
</body>
</html>
