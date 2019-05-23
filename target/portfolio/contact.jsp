<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11.05.2019
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="include.jsp"%>
    <title>Contact</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Vadym Shchur</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="aboutme">About me</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="myprojects">My projects</a>
                </li>
            </ul>
            <form class="navbar-nav my-2 my-lg-0">
                <a class="nav-link" href="contact.jsp">Contact</a>
            </form>
        </div>
    </div>
</nav>
<%@include file="footer.jsp"%>
<%@include file="scripts.jsp"%>
</body>
</html>
