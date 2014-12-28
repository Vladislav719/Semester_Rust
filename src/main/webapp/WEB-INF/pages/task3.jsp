<%--
  Created by IntelliJ IDEA.
  User: Владислав
  Date: 29.12.2014
  Time: 0:18
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


<a href="/task2/3">Task 3.1</a>
<a href="/task2/4">Task 3.2 - Hotel rating</a>

<c:if test="${!empty task3date}">
  <form action="/task2/3" method="post">
    <select name="selectDate">
      <c:forEach var="w" items="${task3date}">
        <option  value="${w}">${w}</option>
      </c:forEach>
    </select>
    <input type="submit"/>
  </form>
</c:if>

<c:if test="${!empty task31}">
  <table class="table table-striped table-condensed">
    <thead>
    <tr>
      <th>Date Start</th>
      <th>Town</th>
      <th>Hotel</th>
      <th>Worker</th>
      <th>Dollar</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="list" items="${task31}">
      <tr>
        <td>${list.dateStart}</td>
        <td>${list.town}</td>
        <td>${list.hotel}</td>
        <td>${list.worker}</td>
        <td>${list.dallar}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</c:if>

<c:if test="${!empty typeHotel}">
  <table>
    <thead>
      <tr>
        <th>
          Rating
        </th>
        <th>
          Hotel
        </th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="list" items="${typeHotel}">
      <tr>
        <td>${list.type}</td>
        <td>${list.hotel}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</c:if>


</body>
</html>
