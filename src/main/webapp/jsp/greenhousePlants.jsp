<%@ page import="by.victor.greenhouse.entity.FlowerData" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 17.12.2019
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Растения в оранжерее</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<table class="table table-striped">
    <thead>
    <tr>
        <th>#</th>
        <th>Название</th>
        <th>Размножение</th>
        <th>Тип почв</th>
        <th>Высота</th>
        <th>Цвет Стебля</th>
        <th>Цвет листвы</th>
        <th>Полив (мл/нед)</th>
        <th>макс. Температура</th>
        <th>мин. Температура</th>
        <th>Цветы</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${resultList}" var="item" varStatus="currentNumber">

        <tr>
            <td class="table-light"><c:out value="${currentNumber.count}"/></td>
            <td class="table-dark"><c:out value="${item.title}"/></td>
            <td class="table-light"><c:out value="${item.multiplying}"/></td>
            <td class="table-dark"><c:out value="${item.soil}"/></td>
            <td class="table-light"><c:out value="${item.height}"/></td>
            <td class="table-dark"><c:out value="${item.stickColor}"/></td>
            <td class="table-light"><c:out value="${item.leafColor}"/></td>
            <td class="table-dark"><c:out value="${item.watering}"/></td>
            <td class="table-light"><c:out value="${item.maxTemperature}"/></td>
            <td class="table-dark"><c:out value="${item.minTemperature}"/></td>
            <td class="table-light"><c:out value="${item.inflorescenceColor}"/></td>

        </tr>

    </c:forEach>
    </tbody>
</table>
</body>
</html>
