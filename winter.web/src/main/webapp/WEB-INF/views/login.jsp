<%--
  Created by IntelliJ IDEA.
  User: shulin
  Date: 16/12/22
  Time: 下午5:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bootstrap 实例</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<!--引入头-->
<jsp:include page="common/header.jsp"/>

<div id="myCarousel" class="carousel slide ">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0"
            class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="<%=request.getContextPath()%>/resources/pic/春.jpg" alt="First slide">
        </div>
        <div class="item">
            <img src="<%=request.getContextPath()%>/resources/pic/夏.jpg" alt="Second slide">
        </div>
        <div class="item">
            <img src="<%=request.getContextPath()%>/resources/pic/秋.jpg" alt="Third slide">
        </div>
        <div class="item">
            <img src="<%=request.getContextPath()%>/resources/pic/冬.jpg" alt="Third slide">
        </div>
    </div>
</div>
<!--自动滑动-->
<script>
    $(function () {
        $('#myCarousel').carousel({
            interval: 3000
        })
    });
</script>

<div class="container">

    <div class="row">
        <div class="col-sm-3">
            <h3>春</h3>

            <p>学的不仅是技术，更是梦想！</p>

            <p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>
        </div>
        <div class="col-sm-3">
            <h3>夏</h3>

            <p>学的不仅是技术，更是梦想！</p>

            <p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>
        </div>
        <div class="col-sm-3">
            <h3>秋</h3>

            <p>学的不仅是技术，更是梦想！</p>

            <p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>
        </div>
        <div class="col-sm-3">
            <h3>冬</h3>

            <p>学的不仅是技术，更是梦想！</p>

            <p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>
        </div>
    </div>
</div>

</body>
</html>
