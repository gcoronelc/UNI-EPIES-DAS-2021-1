let costoEnvio = 50.00;
let sumaSubtotales = 0;
let baseImponible = 0;
let impuesto = 0;
let total = 0;

// Se ejecuta cuando la pagina termina de cargarse
$(function () {
	$("#repartoDistrito").change(cargarRepartidores);
	cargarItems()
});

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
			cuerpoTabla += "<td>Pronto</td>";
			cuerpoTabla += "</tr>";
			sumaSubtotales += rec.subtotal;
		}
		$("#tablaDetalle").html(cuerpoTabla);
		calcularTotales();
	});
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

