<%-- 
    Document   : staffsearch
    Created on : Jun 3, 2017, 3:25:50 PM
    Author     : HP
--%>

<%@page import="sample.ws1dao.tblMobileDTO"%>
<%@page import="sample.ws1dao.tblMobileDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
            <font color="red">
                    Welcome , ${sessionScope.USERNAME}
            </font>
       
        <c:url var="logout" value="login.html">
            <c:param name="cookieName" value="${sessionScope.USERNAME}"/>
        </c:url>
        <a href="${logout}">Log out</a>
        <h1>Search Page</h1>
        <form action="MainServlet" method="POST">
            Search value <input type="text" name="txtSearchValue" value="" size="15" />
            <input type="submit" value="Search" name="btAction" /><br/>
            <a href="staffCreateMobile.html">Click here to insert Mobile </a>
        </form>
        <br/>
        <c:set var="searchValue" value="${param.txtSearchValue}" />

        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCHDEVICE}"/>
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
                            <th>Not Sale</th>
                            <th>Delete</th>
                            <th>Update</th>
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
                                    <input type="hidden" name="txtMobileID" value="${dto.mobileid}" />
                                </td>
                                <td>
                                    <input type="text" name="txtDescript" value="${dto.descript}" />
                                </td>
                                <td>
                                    
                                     <input type="text" name="txtPrice" value="${dto.price}" />
                                </td>
                                <td>
                                    ${dto.mobilename}
                                </td>
                                <td>
                                    ${dto.yop}
                                </td>
                                 <td>
                                    
                               <input type="text" name="txtQuantity" value="${dto.quantity}" />
                                </td>
                                <td>
                                    <input type="checkbox" name="chkSale" value="SALE" 
                                           <c:if test="${dto.notSale}">
                                               checked="checked"
                                           </c:if>
                                           />
                                </td>
                                <td> 
                                    <!--============================-->
                                    <c:url var="urlRewritting" value="MainServlet">
                                        <c:param name="btAction" value="delete"/>
                                        <c:param name="pk"  value="${dto.mobileid}"/>
                                        <c:param name="lastSearhValue" value="${param.txtSearchValue}" />
                                    </c:url>
                                    <a href="${urlRewritting}">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" value="Update" name="btAction" />
                                    <input type="hidden" name="lastSearchValue" value="${param.txtSearchValue}" />
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
