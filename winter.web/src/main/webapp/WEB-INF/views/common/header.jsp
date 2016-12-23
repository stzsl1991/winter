<%--
  Created by IntelliJ IDEA.
  User: shulin
  Date: 16/12/22
  Time: 下午7:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">
    <script src="<%=request.getContextPath()%>/resources/jquery/jquery-2.1.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">WINTER</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class=""><a href="#">春天</a></li>
                <li><a href="#">夏天</a></li>
                <li><a href="#">秋天</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        冬天 <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">起飞咯</a></li>
                        <li class="divider"></li>
                        <li><a href="#">哪里走</a></li>
                    </ul>
                </li>

            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
