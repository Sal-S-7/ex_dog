<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Dog Details</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
</head>
<body>
<h1>Dog Details</h1>
<%
  com.example.ex_chien.entity.Dog dog = (com.example.ex_chien.entity.Dog) request.getAttribute("dog");
%>
<p><b>Name:</b> <%= dog.getName() %></p>
<p><b>Breed:</b> <%= dog.getBreed() %></p>
<p><b>Birth Date:</b> <%= dog.getBirthDate() %></p>

<a href="<%=request.getContextPath()%>/dog">Back to list</a>
</body>
</html>
