<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>

<head>
<title>luv2code Company Home Page</title>
</head>


<body>
<h2>luv2code Company Home Page</h2>
<hr>
<p>
Welcome to the luv2code company home page!
</p>

<hr>

<!-- display user name and role-->

<p>
    User: <security:authentication property="principal.username" />
    <br><br>
    Role(s) : <security:authentication property="principal.authorities" />
</p>


<!--Add a lin to point to /leaders ... this is for the managers -->
    <security:authorize access="hasRole('MANAGER')">
    <a href="${pageContext.request.contextPath}/leaders">leaderShip Meeting</a>
    (Only for Manager peeps)
    </security:authorize>

<!--Add a lin to point to /leaders ... this is for the managers -->
<security:authorize access="hasRole('ADMIN')">
  <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
    (Only for Admin peeps)
</security:authorize>




<hr>



<!-- add the log out -->

<form:form action="${pageContext.request.contextPath}/logout" method="POST">

<input type="submit" value="Logout">

</form:form>


</body>
</html>