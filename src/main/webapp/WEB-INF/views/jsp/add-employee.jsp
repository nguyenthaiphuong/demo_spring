<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>
  <h2>Employee</h2>
  <form:form method="POST" action="addEmployee" modelAttribute="employee">
  	<label>Id:</label>
    <form:input path="id" />
    <label>Name:</label>
    <form:input path="name" />
    <input type="submit" value="Submit" />
  </form:form>
</body>
</html>