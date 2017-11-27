<%-- 
    Document   : staffCreateMobile
    Created on : Jun 4, 2017, 11:07:49 AM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.ws1dao.CreateMobileError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create new Mobile</h1>
        <form action="MainServlet" method="POST">
            <c:set var="err" value="${requestScope.CREATEERR}"/>
           
            mobileID <input type="text" name="txtmobileId" value="" />(2 - 10 chars)<br/>
            <c:if test="${not empty err}">
                <c:if test="${not empty err.mobileIdErrLength}">
            <font color="red">
           ${err.mobileIdErrLength}<br/>
            </font>
              </c:if>
            </c:if>
            
            Description <input type="text" name="txtDescript" value="" />(5-250 chars)<br/>
             <c:if test="${not empty err}">
                <c:if test="${not empty err.descriptErrLength}">
            <font color="red">
            ${err.descriptErrLength}<br/>
            </font>
             </c:if>
            </c:if>
            
            Price <input type="text" name="txtPrice" value="" />(double number)<br/>
             <c:if test="${not empty err}">
                <c:if test="${not empty err.priceErr}">
            <font color="red">
            ${err.priceErr}<br/>
            </font>
             </c:if>
            </c:if>
            mobileName <input type="text" name="txtmobileName" value="" />(3-20 chars)<br/>
              <c:if test="${not empty err}">
                <c:if test="${not empty err.mobileNameErrLength}">
            <font color="red">
            ${err.mobileNameErrLength}<br/>
            </font>
             </c:if>
            </c:if>
            
            Year of Production <input type="text" name="txtYOP" value="" />(year form : yyyy)<br/>
              <c:if test="${not empty err}">
                <c:if test="${not empty err.yearofProductionErr}">
            <font color="red">
            ${err.yearofProductionErr}<br/>
            </font>
             </c:if>
            </c:if>
            Quantity <input type="text" name="txtQuantity" value="" />(possitive number)<br/>
                <c:if test="${not empty err}">
                <c:if test="${not empty err.quantityErr}">
            <font color="red">
            ${err.quantityErr}<br/>
            </font>
             </c:if>
            </c:if>
            Sale <input type="checkbox" name="chkSale" value="" /><br/>
            <input type="submit" value="Create" name="btAction" />
            <input type="reset" value="Reset" /><br/>
                <c:if test="${not empty err}">
                <c:if test="${not empty err.mobileIDisExist}">
            <font color="red">
            ${err.mobileIDisExist}<br/>
            </font>
             </c:if>
            </c:if>

        </form>
    </body>
</html>
