let costoEnvio = 50.00;
let sumaSubtotales = 0;
let baseImponible = 0;
let impuesto = 0;
let total = 0;

// Se ejecuta cuando la pagina termina de cargarse
$(function () {
	$("#btnBuscarProductos").click(fnBtnBuscarProductos);
	$("#btnGrabarVenta").click(fnBtnGrabarVenta);
	$("#repartoDistrito").change(cargarRepartidores);
	cargarItems()
});

function fnBtnGrabarVenta(){
	let data = $("#formVenta").serialize();
	let url = "ProcVentaGrabarVenta";
	$.post(url, data, function (reg) {
		alert(reg.message);
		if(reg.code == 1){
			$("#idcliente").val(0);
			$("#repartoDistrito").val(0);
			$("#idrepartidor").val(0);
			$("#repartoDireccion").val("");
			let datos = [];
			mostrarItems(datos);
			sumaSubtotales = 0;
			calcularTotales();
		}
	});
}

function fnBtnBuscarProductos(){
	let data = $("#formCriterio").serialize();
	let url = "ProcVentaTraerProductos";
	$.get(url, data, function (datos) {
		let rec;
		let cuerpoTabla = "";
		for (var i = 0; i < datos.length; i++) {
			rec = datos[i];
			cuerpoTabla += "<tr>";
			cuerpoTabla += "<td>" + rec.idproducto + "</td>";
			cuerpoTabla += "<td>" + rec.nombre + "</td>";
			cuerpoTabla += "<td>" + rec.preventa + "</td>";
			cuerpoTabla += "<td>" + rec.stock + "</td>";
			cuerpoTabla += "<td><a href= 'javascript: fnModalAgregarItem(" + rec.idproducto + ")'>Agregar</a></td>";
			cuerpoTabla += "</tr>";
		}
		$("#tablaResultado").html(cuerpoTabla);
	});
}

function fnModalAgregarItem(id){
	let url = "ProcVentaAgregarItem?idproducto=" + id;
	$.get(url, function (datos) {
		mostrarItems(datos);
		calcularTotales();
	});;
}

function fnModalEliminarItem(id){
	let url = "ProcVentaEliminarItem?idproducto=" + id;
	$.get(url, function (datos) {
		mostrarItems(datos);
		calcularTotales();
	});;
}

function cargarRepartidores() {
	let cboDistritoReparto = $("#repartoDistrito");
	let cboRepartidores = $("#idrepartidor");
	let distrito = cboDistritoReparto.val();
	// En caso selecciones "Seleccionar"
	cboRepartidores.empty();
	cboRepartidores.append('<option value="0">Seleccionar</option>').val('0');
	if (distrito == '0') {
		return;
	}
	// Cargar los repartidores
	let url = "ProcVentaTraerRepartidores?distrito=" + distrito;
	$.get(url, function (datos) {
		console.log(datos);
		for (var i = 0; i < datos.length; i++) {
			let item = "<option value='" + datos[i].codigo + "'>" + datos[i].nombre + "</option>";
			cboRepartidores.append(item);
		}
	});
}

function cargarItems(){
	let url = "ProcVentaTraerItems";
	$.get(url, function (datos) {
		mostrarItems(datos);
		calcularTotales();
	});
}

function mostrarItems( datos ) {
	sumaSubtotales = 0.0;
	let rec;
	let cuerpoTabla = "";
	for (var i = 0; i < datos.length; i++) {
		rec = datos[i];
		cuerpoTabla += "<tr>";
		cuerpoTabla += "<td>" + (i+1) + "</td>";
		cuerpoTabla += "<td>" + rec.idproducto + " - " + rec.nombre + "</td>";
		cuerpoTabla += "<td>" + rec.precio + "</td>";
		cuerpoTabla += "<td>" + rec.cantidad + "</td>";
		cuerpoTabla += "<td>" + rec.subtotal + "</td>";
		cuerpoTabla += "<td><a href='javascript: fnModalEliminarItem(" + rec.idproducto + ")'>Eliminar</a></td>";
		cuerpoTabla += "</tr>";
		sumaSubtotales += rec.subtotal;
	}
	$("#tablaDetalle").html(cuerpoTabla);
}

function calcularTotales(){
	total = to2Dec(costoEnvio + sumaSubtotales);
	baseImponible = to2Dec(total / 1.18);
	impuesto = to2Dec(total - baseImponible);
	$("#costoEnvio").val(costoEnvio);
	$("#baseImponible").val(baseImponible);
	$("#impuesto").val(impuesto);
	$("#total").val(total);
}

function to2Dec( numero ){
	return Math.round(numero * 100.0) / 100.0;
}

