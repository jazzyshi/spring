<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: jzshi
  Date: 2019/12/24
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input name="request" value="<%=request.getAttribute("req")%>"/>
<input name="session" value="<%=request.getAttribute("session")%>"/>
<input name="map" value="<%=(request.getAttribute("map1"))%>" />
<input name="map" value="<%=(request.getAttribute("map2"))%>" />
<input name="model" value="<%=(request.getAttribute("modelA"))%>" />
<input name="mav" value="<%=(request.getAttribute("mav"))%>" />
</body>
</html>
