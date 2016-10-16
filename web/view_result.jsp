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
<br>
<h4>Author Info:</h4>
<br>
<table border="1">
    <tr>
        <td>AuthorID</td>
        <td>Name</td>
        <td>Age</td>
        <td>Country</td>
    </tr>
    <tr>
        <td><s:property value="#request.aAuthorID"/></td>
        <td><s:property value="#request.aName"/></td>
        <td><s:property value="#request.aAge"/></td>
        <td><s:property value="#request.aCountry"/></td>
    </tr>
</table>
<br><br>
<h4>author's books:</h4>
<br>
<table border="1">
    <tr>
        <th>Isbn</th>
        <th>Title</th>
        <th>AuthorID</th>
        <th>Publisher</th>
        <th>PublishDate</th>
        <th>Price</th>
        <th>handle</th>
    </tr>
    <s:iterator value="#request.itemlist" id="mycontent" status="status">
    <tr>
        <td><s:property value="#mycontent.isbn"/></td>
        <td><s:property value="#mycontent.title"/></td>
        <td><s:property value="#mycontent.authorID"/></td>
        <td><s:property value="#mycontent.publisher"/></td>
        <td><s:property value="#mycontent.publishDate"/></td>
        <td><s:property value="#mycontent.price"/></td>
        <td><a href="delete.action?delete_Isbn=<s:property value="#mycontent.isbn"/>">
            delete</a></td>
    </tr>
    </s:iterator>



</body>
</html>
