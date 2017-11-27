<%-- 
    Document   : ViewCart
    Created on : Jun 9, 2017, 5:12:34 PM
    Author     : HP
--%>

<%@page import="java.util.Map"%>
<%@page import="sample.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <h1>Cart Page</h1>
        <c:set var="cart" value="${sessionScope.CART}"/>
        <c:if test="${not empty cart}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Mobile ID</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                   <c:set var="item" value="${cart.items}"/>
             <c:if test="${not empty item}">
                 <form action="MainServlet">
                 <c:forEach var="dto" items="${item.entrySet()}" varStatus="counter">
                      <tr>
                        <td>${counter.count}</td>
                        <td>${dto.key}
                         <input type="hidden" name="txtSaveId" value="${dto.key}" />
                        </td>
                     
                        <td>${dto.value}
                         <input type="hidden" name="txtSaveValue" value="${dto.value}" />
                        </td>
                        <td>
                            <input type="checkbox" name="chkRemove" value="${dto.key}" />
                        </td>
                    </tr>
                 </c:forEach>
                    <tr>
                        <td colspan="3">
                            <a href="manager.jsp">Click here to Buy more</a>
                        </td>
                        <td>
                            <input type="submit" value="Remove" name="btAction" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <input type="submit" value="BUY" name="btAction" />
                        </td>
                    </tr>
                     </form>
                     
             </c:if>
                </tbody>
            </table>
             
            
                 
        </c:if>
        <c:if test="${empty cart}">
            No record to show
        </c:if>
            <form action="MainServlet">
          <c:set var="errors" value="${requestScope.CREATEERROR}"/>
        <c:if test="${not empty errors.addItemstoCartErr}">
            <font color="red">
            ${errors.addItemstoCartErr}    
            </font>
        </form>
    </c:if><br/>
               
</body>
</html>
