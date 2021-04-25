
-- Selección de columnas
-- ======================

-- Pregunta 1
/*
Desarrolle una sentencia SELECT para consultar el nombre, 
apellido e email de los empleados de la base de datos RH.
*/

select nombre, apellido, email
from rh..empleado;
go



-- Pregunta 2
/*
Desarrolle una sentencia SELECT para consultar el nombre, 
vacantes y precio de cada curso de la base de datos EDUCA.
*/

-- JERAD REY NILSON MIRANDA VASQUEZ17:10

SELECT cur_nombre,cur_vacantes,cur_precio 
FROM educa..CURSO;
go


-- Campos calculados

-- Pregunta 3
/*
Desarrollar una sentencia SELECT que permita obtener el importe 
que se obtendría si se logra vender todas las vacantes por cada curso. 
Base de datos EDUCA.
*/

select 
	cur_id, cur_nombre, cur_vacantes, cur_precio,
	cur_vacantes * cur_precio "importe x curso"
from educa..CURSO;
go


-- Preguna 4
/*
Desarrollar una sentencia SELECT que permita obtener el importe de lo 
recaudado hasta el momento de los cursos vendidos. Base de datos EDUCA.
*/

-- NATALY SALCEDO GUERRA17:19

SELECT cur_id,cur_nombre,cur_matriculados,cur_precio,cur_matriculados*cur_precio recaudado 
from educa..CURSO;
go


select c.cur_id, c.cur_nombre, sum(p.pag_importe) recaudado
from educa..CURSO c 
join educa..PAGO p on c.cur_id = p.cur_id
group by c.cur_id, c.cur_nombre;

-- Respuesta correcta

select sum(pag_importe) recaudado
from educa..PAGO;


-- Pregunta 5
/*
Desarrollar una sentencia SELECT que permita consultar el importe de lo
que se tiene comprometido (cobrado y no cobrado) por los cursos vendidos 
hasta el momento. Base de datos EDUCA.
*/


-- ANDRE FABRIZIO BENITO SANTILLAN17:37

select SUM(mat_precio) Importe
from EDUCA..MATRICULA;
go


-- Operadores aritméticos y de concatenación

-- Problema 6
/*
Desarrollar una sentencia SELECT para consultar el nombre y apellido 
de un empleado en una sola columna. Base de datos RH.
*/

select concat(nombre, ', ', apellido) [Nombre Completo]
from rh..empleado;
go


-- Problema 7
/*
Desarrollar una sentencia SELECT para consultar el ingreso total de cada empleado. 
Base de datos RH.
*/


select 
	idempleado, nombre, apellido, sueldo, comision,
	sueldo + isnull(comision,0) [ingreso total]
from rh..empleado;
go


select 
	80 + null "Caso 1",
	80 + isnull(null,0) "Caso 2",
	80 + isnull(50,0) "Caso 3"
go






