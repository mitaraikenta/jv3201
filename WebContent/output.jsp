<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%

    //サーバーの環境Tomcatは合わせる

    Double height = (Double)request.getAttribute("height");
    Double weight = (Double)request.getAttribute("weight");
    Double BMI = (Double)request.getAttribute("BMI");
    String body = (String)request.getAttribute("BODY");


    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>身長:<%=height %></p>
<p>体重:<%=weight %></p>
<p>BMI:<%=BMI %></p>
<p>体形:<%=body %></p>

</body>
</html>