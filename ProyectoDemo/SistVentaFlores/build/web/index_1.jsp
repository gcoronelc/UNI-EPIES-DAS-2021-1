<%-- 
    Document   : index
    Created on : 07/05/2021, 04:30:32 PM
    Author     : Gustavo Coronel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<title>SISTEMA DE VENTA DE FLORES</title>
	</head>
	<body>
		<h1>SISTEMA DE VENTA DE FLORES</h1>
		<div>${mensaje}</div>
		<form method="post" action="LogonControllerIngresar">
			<div>
				<div>
					<label>Usuario</label>
					<input type="text" name="usuario"/>
				</div>
				<div>
					<label>Clave</label>
					<input type="password" name="clave"/>
				</div>
				<div>
					<input type="submit" value="Ingresar"/>
				</div>
			</div>			
		</form>


		<!-- Option 2: jQuery, Popper.js, and Bootstrap JS -->
		<script src="js/jquery-3.5.1.min.js"></script>
		<script src="js/popper.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>
