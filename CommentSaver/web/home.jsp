<%-- 
    Document   : home
    Created on : Jun 19, 2014, 9:17:35 PM
    Author     : chad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comment Page</title>
    </head>
    <body>
        <h1>Please leave a comment about how amazing this page is.</h1>
        <h4>${invalid}</h4>
        <form action="CommentServlet" method="POST">
            <textarea rows="4" cols="50" name="comment"></textarea>
            <input type="submit" value="Submit"/>
        </form>
        <br/>
        <form action="CommentServlet" method ="GET">
            Enter a user to view his comments: <input type="text" name="viewuser"/>
            <input type="submit" value="View comments"/>
        </form>
    </body>
</html>
