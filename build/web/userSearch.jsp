<%-- 
    Document   : manager
    Created on : Jun 9, 2017, 2:08:59 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="sample.ws1dao.tblMobileDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <font color="blue">
        Welcome user: ${sessionScope.USERNAME}<br/>
        </font>
        <c:url var="logout" value="login.html">
            <c:param name="cookieName" value="${sessionScope.USERNAME}"/>
        </c:url>
        <a href="${logout}">Logout</a>
        <h1>User Page</h1>
        <form action="MainServlet" method="POST">
            <h3> Insert Mobile in range </h3>
            Begin<br/>
            <input type="text" name="txtSearchBegin" value="${param.txtSearchBegin}" /><br/>
            End <br/>
            <input type="text" name="txtSearchEnd" value="${param.txtSearchEnd}" /><br/>
            <input type="submit" value="SearchPrice" name="btAction" /><br/>
            <input type="submit" value="Click here to view Cart" name="btAction" /><br/>
        </form>


        <c:set var="searchmin" value="${param.txtSearchBegin}"/>
        <c:set var="searchmax" value="${param.txtSearchEnd}"/>
        <c:if test="${not empty searchmin and not empty searchmax}">
            <c:set var="result" value="${requestScope.SEARCH}"/>
             <font color="purple">
                The Search price Beginprice: ${param.txtSearchBegin} and Endprice : ${param.txtSearchEnd} <br/>
                </font>
            <c:if test="${not empty result}">
               
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Mobile ID</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Mobile Name</th>
                            <th>Year of Production</th>
                            <th>Quantity</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action="MainServlet">
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                     ${dto.mobileid}
                                    <input type="hidden" name="txtmobileId" value="${dto.mobileid}" />
                                </td>
                                <td>
                                    ${dto.descript}
                                </td>
                                <td>
                                    ${dto.price}
                                </td>
                                <td>
                                    ${dto.mobilename}
                                </td>
                                <td>
                                    ${dto.yop}
                                </td>
                                <td>
                                    ${dto.quantity}
                                </td>
                                <td>
                                    <input type="submit" value="Add to Cart" name="btAction" />
                                    <input type="hidden" name="lastSearchBegin" value="${param.txtSearchBegin}" />
                                    <input type="hidden" name="lastSearchEnd" value="${param.txtSearchEnd}" />
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
        <c:if test="${empty result}">
            <h2>No record matched</h2>
        </c:if>
    </c:if>
</body>
</html>
