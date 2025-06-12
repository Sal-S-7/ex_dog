<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Add a Dog</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
</head>
<body>
<h1>Add a Dog</h1>
<form action="<%=request.getContextPath()%>/dog" method="post">
  Name: <input type="text" name="name" required/><br/>
  Breed: <input type="text" name="breed" required/><br/>
  Birth Date: <input type="date" name="birthDate" required/><br/>
  <button type="submit">Save</button>
</form>
<a href="<%=request.getContextPath()%>/dog">Back to list</a>
</body>
</html>
