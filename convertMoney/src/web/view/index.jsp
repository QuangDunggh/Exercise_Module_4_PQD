<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/03/2022
  Time: 10:58 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="get" action="/convert">
    <input type="text" name="convert">
    <input type="submit" value="convert">
  </form>
  <br>
  <h1>Result : ${result}</h1>

  </body>
</html>
