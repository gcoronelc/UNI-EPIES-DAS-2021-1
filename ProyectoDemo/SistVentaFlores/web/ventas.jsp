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
			<h1>REGISTRAR VENTA</h1>

			<!-- Datos Generales -->
			<div class="card">

				<div
					class="card-header bg-info text-white d-flex justify-content-between align-items-center">
					DATOS DE LA VENTA <input type="button" class="btn btn-primary"
													 value="Registrar venta" id="btnGrabarVenta">
				</div>

				<div class="card-body">

					<div class="form-group row">
						<label class="col-md-2" for="idcliente">Cliente:</label>
						<div class="col-md-10">
							<select class="form-control form-control-sm"
									  id="idcliente" name="idcliente">
								<option value="0">Seleccionar</option>
								<c:forEach items="${comboClientes}" var="r">
									<option value="${r.codigo}">${r.nombre}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group row">
						<label class="col-md-2" for="repartoDistrito">Distrito envío:</label>
						<div class="col-md-10">
							<select class="form-control form-control-sm"
									  id="repartoDistrito" name="repartoDistrito">
								<option value="0">Seleccionar</option>
								<c:forEach items="${comboDistritos}" var="r">
									<option value="${r.codigo}">${r.nombre}</option>
								</c:forEach>
							</select>
						</div>
					</div>	

					<div class="form-group row">
						<label class="col-md-2" for="repartoDireccion">Dirección:</label>
						<div class="col-md-10">
							<input type="text" name="repartoDireccion" id="repartoDireccion"
									 class="form-control form-control-sm" placeholder="Dirección de envío." />
						</div>
					</div>

					<div class="form-group row">
						<label class="col-md-2" for="idrepartidor">Repartidor:</label>
						<div class="col-md-10">
							<select class="form-control form-control-sm"
									  id="idrepartidor" name="idrepartidor">
								<option value="0">Seleccionar</option>
							</select>
						</div>
					</div>		

					<div class="form-group row">
						<label class="col-md-2" for="costoEnvio">Costo de envío:</label>
						<div class="col-md-10">
							<input value="50.00" type="text" name="costoEnvio" id="costoEnvio"
									 class="form-control form-control-sm"
									 readonly="readonly" />
						</div>
					</div>

					<div class="form-group row">
						<label class="col-md-2" for="baseImponible">Base imponible:</label>
						<div class="col-md-10">
							<input value="0.00" type="text" name="baseImponible" id="baseImponible"
									 class="form-control form-control-sm"
									 readonly="readonly" />
						</div>
					</div>					

					<div class="form-group row">
						<label class="col-md-2" for="impuesto">Impuesto:</label>
						<div class="col-md-10">
							<input value="0.00" type="text" name="impuesto" id="impuesto"
									 class="form-control form-control-sm"
									 readonly="readonly" />
						</div>
					</div>					

					<div class="form-group row">
						<label class="col-md-2" for="total">Total:</label>
						<div class="col-md-10">
							<input value="0.00" type="text" name="total" id="total"
									 class="form-control form-control-sm"
									 readonly="readonly" />
						</div>
					</div>

				</div>
			</div>

			<!-- Lista de Productos -->
			<div class="card mt-2">

				<div
					class="card-header d-flex justify-content-between align-items-center">
					LISTA DE PRODUCTOS
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-secondary" data-toggle="modal"
							  data-target="#selectItemModal" id="btnCargarModal">Agregar item</button>
				</div>

				<div class="card-body">

					<table class="table">

						<thead class="thead-light">
							<tr>
								<th scope="col">ITEM</th>
								<th scope="col">CODIGO - PRODUCTO</th>
								<th scope="col">PRECIO</th>
								<th scope="col">CANTIDAD</th>
								<th scope="col">SUBTOTAL</th>
								<th scope="col">ACCION</th>
							</tr>
						</thead>
						<tbody id="tablaDetalle">
						</tbody>
					</table>


				</div>
			</div>

		</div>

		<!-- Modal -->
		<div class="modal" id="selectItemModal" tabindex="-1" role="dialog"
			  aria-labelledby="selectItemModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-scrollable modal-lg"
				  role="document">
				<div class="modal-content">
					<div class="modal-header bg-info text-white">
						<h5 class="modal-title" id="exampleModalLabel">Seleccionar
							item</h5>
						<button type="button" class="close" data-dismiss="modal"
								  aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form id="formCriterio">
							<div class="row d-flex justify-content-center align-items-center">

								<select class="form-control form-control-sm col-md-5"
										  id="categoria" name="categoria">
									<c:forEach items="${comboCategorias}" var="r">
										<option value="${r.codigo}">${r.nombre}</option>
									</c:forEach>
								</select>
								<div class="col-md-5">
									<input type="text" name="nombre"
											 class="form-control form-control-sm" id="nombre"
											 placeholder="Nombre del producto." />
								</div>
								<div class="col-md-2">
									<button id="btnBuscarProductos" type="button"
											  class="btn btn-primary">Buscar</button>
								</div>

							</div>
						</form>
						<div class="row mt-2">
							<table class="table">
								<thead class="thead-light">
									<tr>
										<th scope="col">ID</th>
										<th scope="col">NOMBRE</th>
										<th scope="col">PRECIO</th>
										<th scope="col">STOCK</th>
										<th scope="col">CANTIDAD</th>
										<th scope="col">ACCION</th>
									</tr>
								</thead>
								<tbody id="tablaResultado">
								</tbody>
							</table>

						</div>

					</div>
				</div>
			</div>
		</div>

		<jsp:include page="util/pie.jsp" />
		<script src="paginasjs/ventas.js"></script>
	</body>
</html>
