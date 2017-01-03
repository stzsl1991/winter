<%--
  Created by IntelliJ IDEA.
  User: shulin
  Date: 16/12/26
  Time: 下午3:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载Excel</title>
    <script src="<%=request.getContextPath()%>/resources/myjs/down-exl.js"></script>
</head>
<body>
<jsp:include page="common/header.jsp"/>
<div>
    <button onclick="downloadExl();">下载Excel</button>
</div>

</body>
</html>
