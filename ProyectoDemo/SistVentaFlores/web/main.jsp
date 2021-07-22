<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.usuario == null}">
	<c:redirect url="index.jsp" />
</c:if>

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
