<%-- 
    Document   : index
    Created on : Jun 18, 2014, 8:20:57 AM
    Author     : chad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please log in to comment</h1>
        <h3>${invalid}</h3>
        <form action="LogInServlet" method="POST">
            Username: <input type="text" name="user"/>
            Password: <input type="password" name="pass"/>
            <input type="submit" value="Sign In"/>
            <span><a href="CreateUser.jsp">Sign Up</a></span>
        </form>
    </body>
</html>
