<%-- 
    Document   : main
    Created on : 07/05/2021, 04:24:14 PM
    Author     : Gustavo Coronel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="util/cabecera.jsp" />
	</head>
	<body>
		<jsp:include page="util/menu.jsp" />

		<div id="divWorkArea" class="container mt-2">
			<img src="img/homePage.jpeg" class="img-fluid" alt=""/>
		</div>

		<jsp:include page="util/pie.jsp" />
	</body>
</html>
