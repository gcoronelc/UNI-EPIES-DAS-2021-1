<%-- 
    Document   : main
    Created on : 07/05/2021, 04:24:14 PM
    Author     : Gustavo Coronel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="estado" value=""/>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="util/cabecera.jsp" />
	</head>
	<body>
		<jsp:include page="util/menu.jsp" />

		<div id="divWorkArea" class="container mt-2">

			<h1>MANTENIMIENTO DE CLIENTES</h1>

			<div class="card mt-2" id="divFormulario">
				<div class="card-header">
					${accion} CLIENTE
				</div>

				<div class="card-body container justify-content-center">

					<c:if test="${mensaje != null}">
						<div class="alert alert-success">
							<strong>Success!</strong> ${mensaje}
						</div>
					</c:if>

					<c:if test="${erro != null}">
						<div class="alert alert-danger">
							<strong>Error!</strong> ${mensaje}
						</div>
					</c:if>

					<c:if test="${dto != null}">
						<form method="post" action="ClientesFormularioGrabar">

							<input type="hidden" name="accion" value="${accion}"/>
							<input type="hidden" name="id" value="${dto.idcliente}"/>

							<div class="form-group row">
								<label for="codigo" class="col-sm-3 col-form-label">Código</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="codigo" placeholder="Código" disabled="disabled" value="${dto.idcliente}">
								</div>
							</div>

							<div class="form-group row">
								<label for="nombre" class="col-sm-3 col-form-label">Nombre</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="nombre" placeholder="Nombre" value="${dto.nombre}" ${desactiva}>
								</div>
							</div>

							<div class="form-group row">
								<label for="apellido" class="col-sm-3 col-form-label">Apellido</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="apellido" placeholder="Apellido" value="${dto.apellido}" ${desactiva}>
								</div>
							</div>

							<div class="form-group row">
								<label for="dni" class="col-sm-3 col-form-label">DNI</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="dni" placeholder="DNI" value="${dto.dni}" ${desactiva}>
								</div>
							</div>

							<div class="form-group row">
								<label for="distrito" class="col-sm-3 col-form-label">Distrito</label>
								<div class="col-sm-9">
									<select name="distrito" class="custom-select" ${desactiva}>
										<option value="0">Seleccione</option>
										<c:forEach items="${comboDistritos}" var="r">
											<c:set var="estado" value=""/>
											<c:if test="${dto.iddistrito == r.codigo}">
												<c:set var="estado" value="selected"/>
											</c:if>
											<option value="${r.codigo}" ${estado}>${r.nombre}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="form-group row">
								<label for="direccion" class="col-sm-3 col-form-label">Dirección</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="direccion" placeholder="Dirección" value="${dto.direccion}" ${desactiva}>
								</div>
							</div>

							<div class="form-group row">
								<label for="telefono" class="col-sm-3 col-form-label">Teléfono</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="telefono"  placeholder="Teléfono" value="${dto.telefono}" ${desactiva}>
								</div>
							</div>

							<div class="form-group row">
								<label for="correo" class="col-sm-3 col-form-label">Correo electrónico</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="correo"  placeholder="Correo electrónico" value="${dto.correo}" ${desactiva}>
								</div>
							</div>

							<div class="row form-group">
								<input type="submit" name="btnGrabar" class="btn btn-primary p-3 m-2 flex-fill" value="Grabar"/>
								<input type="submit" name="btnCancelar" class="btn btn-secondary p-3 m-2 flex-fill" value="Cancelar"/>
							</div>

						</form>
					</c:if>

				</div>
			</div>

		</div>

		<jsp:include page="util/pie.jsp" />
	</body>
</html>
