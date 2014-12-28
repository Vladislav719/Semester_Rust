<%--
  Created by IntelliJ IDEA.
  User: Владислав
  Date: 28.12.2014
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title></title>
</head>
<body>

<a href="<c:url value="/task2/1"/>">Первый запрос</a>
<a href="<c:url value="/task2/2"/>">Второй запрос</a>
<a href="<c:url value="/task2/3"/>">Третий запрос</a>
<a href="<c:url value="/task2/4"/>">Четвертый запрос</a>


<c:if test="${not empty listFirst}">
    <table class="table table-striped table-condensed">
        <thead>
        <tr>
            <th>Cost</th>
            <th>Country</th>
            <th>Hotel</th>
            <th>Period</th>
            <th>Route ID</th>
            <th>Route Name</th>
            <th>Type</th>
            <th>Worker</th>
        </tr>
        </thead>
        <tbody>

            <c:forEach var="list" items="${listFirst}">
                <tr>
                    <td>${list.cost}</td>
                    <td>${list.country}</td>
                    <td>${list.hotel}</td>
                    <td>${list.period}</td>
                    <td>${list.routeid}</td>
                    <td>${list.routeName}</td>
                    <td>${list.type}</td>
                    <td>${list.worker}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>


<c:if test="${not empty listSecond}">
    <table class="table table-striped table-condensed">
        <thead>
        <tr>
            <th>town</th>
            <th>Country</th>
            <th>Hotel</th>
            <th>Period</th>
            <th>Type</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="w" items="${listSecond}">
            <tr>

                <td>${w.town}</td>
                <td>${w.country}</td>
                <td>${w.hotel}</td>
                <td>${w.period}</td>
                <td>${w.type}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</c:if>

</body>
</html>
