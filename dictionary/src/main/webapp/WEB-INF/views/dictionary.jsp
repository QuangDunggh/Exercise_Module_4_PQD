<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/03/2022
  Time: 3:37 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Từ điển</title>
</head>
<body>
 <form method="get" >
     <input type="text" name="convert">
     <input type="submit" value="Search">
 </form>
${result}
</body>
</html>
