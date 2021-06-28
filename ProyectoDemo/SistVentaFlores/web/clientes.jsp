<%-- 
    Document   : main
    Created on : 07/05/2021, 04:24:14 PM
    Author     : Gustavo Coronel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

			<h1>MANTENIMIENTO DE CLIENTES</h1>

			<div class="card mt-2" id="divCriterio">
				<div class="card-header">
					CRITERIO DE CONSULTA 
				</div>
				<div class="card-body container justify-content-center">
					<form class="form-inline" id="formulario" action="ClientesFormularioConsulta">
						<label for="codigo" class="sr-only">Código</label>
						<input type="text" class="form-control mb-2 mr-sm-2" id="codigo" name="codigo" placeholder="Código">
						<label for="nombre" class="sr-only">Nombre</label>
						<input type="text" class="form-control mb-2 mr-sm-2" id="nombre" name="nombre" placeholder="Nombre">
						<label for="apellido" class="sr-only">Apellido</label>
						<input type="text" class="form-control mb-2 mr-sm-2" id="apellido" name="apellido" placeholder="Apellido">
						<button type="submit" id="btnConsultar" name="btnConsultar" class="btn btn-primary mb-2 mr-sm-2">Consultar</button>
						<button type="submit" id="btnNuevo" name="btnNuevo" class="btn btn-secondary mb-2 mr-sm-2">Nuevo</button>
					</form>
				</div>
			</div>

			<c:if test="${lista != null}">
				<div class="card mt-2" id="divResultado">
					<div class="card-header">
						RESULTADO DE LA CONSULTA 
					</div>
					<div class="card-body container-fluid" id="divTabla">
						<table class="table">
							<thead class="thead-light">
								<tr>
									<th>CODIGO</th>
									<th>NOMBRE</th>
									<th>APELLIDO</th>
									<th>DNI</th>
									<th>CORREO</th>
									<th>EDITAR</th>
									<th>ELIMINAR</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${lista}" var="r">
									<tr>
										<td>${r.idcliente}</td>
										<td>${r.nombre}</td>
										<td>${r.apellido}</td>
										<td>${r.dni}</td>
										<td>${r.correo}</td>
										<td>
											<a href="ClientesEditar?id=${r.idcliente}">Editar</a>
										</td>
										<td>											
											<a href="ClientesEliminar?id=${r.idcliente}">Eliminar</a>
										</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</c:if>

		</div>

		<jsp:include page="util/pie.jsp" />
	</body>
</html>
