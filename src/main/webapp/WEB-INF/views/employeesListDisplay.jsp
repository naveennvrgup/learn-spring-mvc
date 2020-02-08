<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Learn spring mvc</title>
</head>
<body>
    <h2>All Employees In The System</h2>
    <form action="/getAllEmployees" method="post">
        <c:if test="${haserr}">
            has err: <c:out value="${haserr}"></c:out>
        </c:if>

        <input type="text" placeholder="id" name="id">
        <input type="text" placeholder="firstName" name="firstName">
        <input type="text" placeholder="lastName" name="lastName">
        <input type="text" placeholder="email" name="email">
        <button>Submit</button>
    </form>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>email</th>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>