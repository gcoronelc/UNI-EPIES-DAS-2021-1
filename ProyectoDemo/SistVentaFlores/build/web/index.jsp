<%-- 
    Document   : index
    Created on : 07/05/2021, 04:30:32 PM
    Author     : Gustavo Coronel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/index.css">
	<title>SISTEMA DE VENTA DE FLORES</title>
	<body>
		<div class="container">
			<div class="card card-container">
				<img id="profile-img" class="profile-img-card" src="img/Usuario.png" />

				<c:if test="${not empty mensaje}">
					<div class="alert alert-danger alert-dismissible fade show">  
						<button type="button" class="close" data-dismiss="alert">×</button>  
						<h4 class="alert-heading">Error!</h4> ${mensaje} 
					</div>
				</c:if>

				<form class="form-signin" method="post" action="LogonControllerIngresar">
					<span id="reauth-email" class="reauth-email"></span>
					<input type="text" id="usuario" name="usuario" class="form-control" placeholder="Usuario" required autofocus>
					<input type="password" id="clave" name="clave" class="form-control" placeholder="Clave" required>
					<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Ingresar</button>
				</form><!-- /form -->

			</div><!-- /card-container -->
		</div><!-- /container -->

		<script src="js/jquery-3.5.1.min.js"></script>
		<script src="js/popper.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>
