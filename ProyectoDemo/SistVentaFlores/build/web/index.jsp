<%-- 
    Document   : index
    Created on : 07/05/2021, 04:30:32 PM
    Author     : Gustavo Coronel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
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
	</body>
</html>
