<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11.05.2019
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="include.jsp"%>
    <title>About me</title>
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
<div class="container">
    <div class="row">
<c:forEach var="studie" items="${studies}">
    <div class="col">
        <c:out value="${studie.name}"/>
        <c:out value="${studie.description}"/>
    </div>
</c:forEach>
    </div>
</div>
<div class="container">
    <div class="row">
        <c:forEach var="skill" items="${skills}">
            <div class="col">
                <c:out value="${skill.name}"/>
                <c:out value="${skill.description}"/>
                <c:out value="${skill.rate.rate}"/>
                <c:out value="${skill.rate.description}"/>
            </div>
        </c:forEach>
    </div>
</div>
<%@include file="footer.jsp"%>
<%@include file="scripts.jsp"%>
</body>
</html>
