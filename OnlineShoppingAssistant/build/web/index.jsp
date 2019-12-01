<%-- 
    Document   : index
    Created on : Mar 1, 2018, 12:53:17 AM
    Author     : Solaiman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Online Shopping Assistant</title>
        <link rel="stylesheet" href="properties/css/style.css">
    </head>
    <jsp:include page="header.jsp"></jsp:include>
        <body>
        <div class="window">
            <div class="bar">
                <div class="button"></div>
            </div>
            <form class="search" action="Manage" method="post">
                <input type="search" placeholder="Search" name="search">
            </form>
        </div>
    </body>
</html>
