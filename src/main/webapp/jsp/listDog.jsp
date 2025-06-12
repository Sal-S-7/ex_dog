<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Dog List</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
</head>
<body>
<h1>Dog List</h1>
<a href="<%=request.getContextPath()%>/dog?action=add">Add a Dog</a>
<table style="border-collapse: collapse; border: 1px solid #ccc; width: 100%;">
  <tr><th>Name</th><th>Breed</th><th>Details</th></tr>
  <%
    java.util.List<com.example.ex_chien.entity.Dog> dogs = (java.util.List<com.example.ex_chien.entity.Dog>)request.getAttribute("dogs");
    for (com.example.ex_chien.entity.Dog d : dogs) {
  %>
  <tr>
    <td><%= d.getName() %></td>
    <td><%= d.getBreed() %></td>
    <td><a href="<%=request.getContextPath()%>/dog?action=detail&id=<%=d.getId()%>">View Details</a></td>
  </tr>
  <% } %>
</table>
</body>
</html>
