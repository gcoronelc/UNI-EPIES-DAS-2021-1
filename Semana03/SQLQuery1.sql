-- Filtro de filas
-- WHERE

-- Pregunta 8.
/*
Desarrollar una sentencia SELECT para consultar los empleados del departamento 
de contabilidad. Base de datos RH.
*/

-- ALDO GUSTAVO CONDOR MEDINA14:12

SELECT * 
FROM RH..departamento 
WHERE nombre='contabilidad' 
GO

SELECT * FROM RH..empleado
WHERE iddepartamento = 101
GO

-- ENZO ANTONY CARBAJAL TRUJILLO14:13

SELECT A.[nombre],apellido, B.[nombre] 
FROM rh..empleado A, rh..departamento B
WHERE a.iddepartamento = b.iddepartamento -- Se debe hacer con INNER JOIN
AND b.nombre='Contabilidad'; 
GO

SELECT A.[nombre],apellido, B.[nombre] 
FROM rh..empleado A 
INNER JOIN rh..departamento B ON a.iddepartamento=b.iddepartamento
WHERE b.nombre='Contabilidad'; 
GO

-- Pregunta 9. 
/*
Desarrollar una sentencia SELECT para consultar los empleados que se 
desempeñan como gerentes. Base de datos RH.
*/

-- ENZO ANTONY CARBAJAL TRUJILLO14:13

SELECT A.[nombre],apellido, B.[nombre] 
FROM rh..empleado A, rh..cargo B
WHERE a.idcargo=b.idcargo AND b.nombre='Gerente';
GO

SELECT A.[nombre],apellido, B.[nombre] 
FROM rh..empleado A
INNER JOIN rh..cargo B ON a.idcargo = b.idcargo
WHERE b.nombre LIKE 'Gerente%';
GO


-- Operadores relacionales

-- Pregunta 10.
/* 
Desarrollar una sentencia SELECT para consultar los empleados de 
contabilidad cuyo sueldo e mayor a 10,000.00. Base de datos RH.
*/

-- JAZMIN NICOLE FLORES BALBOA14:25

select a.nombre,a.apellido
from rh..empleado a 
INNER JOIN rh..departamento b on  a.iddepartamento=b.iddepartamento
where a.sueldo>10000 and b.nombre='Contabilidad';
go


-- PRegunta 11.
/*
Desarrollar una sentencia SELECT que permita averiguar los cursos que 
aún no tienen profesor. Base de datos EDUCA.
*/



-- Pregunta 12. 
/*
Desarrollar una sentencia SELECT que permita averiguar los cursos 
que aún no tienen alumnos matriculados. Base de datos EDUCA.
*/




-- Operadores LIKE, BETWEEN, IN

-- Pregunta 13.
/*
Desarrollar una sentencia SELECT que permita consultar los empleados 
que su nombre finaliza con la letra "O". Base de datos RH.
*/

-- JERAD REY NILSON MIRANDA VASQUEZ14:29

SELECT apellido,nombre 
FROM RH..empleado
WHERE nombre LIKE '%o'
GO

-- Oregunta 14. 
/*
Desarrollar una sentencia SELECT que permita consultar los empleados 
que su apellido tiene en la segunda posición la letra "A" ó "O". 
Base de datos RH.
*/

-- JERAD REY NILSON MIRANDA VASQUEZ14:29

SELECT nombre,apellido 
FROM RH..empleado
WHERE apellido LIKE '_o%' or apellido LIKE '_a%';
GO

SELECT nombre,apellido 
FROM RH..empleado
WHERE apellido LIKE '_[AO]%';
GO

-- Pregunta 15. 
/*
Desarrollar una sentencia SELECT que permita averiguar que empleados
tienen un sueldo mayor de 3,000.0 y menor de 10,000.0. Base de datos RH.
*/

-- JERAD REY NILSON MIRANDA VASQUEZ14:29

SELECT nombre,apellido,sueldo 
FROM RH..empleado
WHERE sueldo between 3000 and 10000
GO


-- Pregunta 16. 
/*
Desarrollar una sentencia SELECT que permita averiguar 
quiénes son los empleados de los departamentos de contabilidad 
y ventas. Base de datos RH.
*/

-- JERAD REY NILSON MIRANDA VASQUEZ14:29

SELECT E.nombre,E.apellido,D.nombre 
FROM RH..empleado E,RH..departamento D
WHERE D.iddepartamento=E.iddepartamento and D.nombre in ('Contabilidad','Ventas')
GO

--(INNER JOIN)

SELECT E.nombre,E.apellido,D.nombre 
FROM RH..departamento D
INNER JOIN RH..empleado E ON D.iddepartamento= E.iddepartamento 
WHERE  D.nombre in ('Contabilidad','Ventas')
GO


-- SARAY ANEL CLARIBEL MIRANDA VASQUEZ14:31

SELECT E.nombre,E.apellido,D.nombre 
FROM RH..departamento D
INNER JOIN RH..empleado E ON D.iddepartamento= E.iddepartamento 
WHERE  D.nombre in ('Contabilidad','Ventas')
GO


-- Ordenamiento del conjunto de resultados

-- Pregunta 17.
/*
Desarrollar una sentencia SELECT que permita mostrar una lista de 
los empleados ordenada por fecha de ingreso. Base de datos RH.
*/

-- KEVIN DENIZ PAUCAR FUENTES14:31

select *
from rh..empleado
order by fecingreso asc;


-- Manipulación de valores NULL

-- Probelams 18. 
/*
Desarrollar una sentencia SELECT para consultar los empleados cuyos 
ingresos totales es menor a 8,000.00. Base de datos RH.
*/

-- KEVIN DENIZ PAUCAR FUENTES14:31

select idempleado,apellido,nombre,sueldo,comision,
      sueldo + isnull(comision,0) "ingeso total"
from  rh..empleado
where sueldo + isnull(comision,0)<8000
go


-- Funciones de conversión de tipo. Funciones de fecha y hora

-- Pregunta 19. 
/*
Desarrollar una sentencia SELECT para consultar los empleados que 
ingresaron a la empresa un mes de Enero. Base de datos RH.
*/

-- SARAY ANEL CLARIBEL MIRANDA VASQUEZ14:45

SELECT nombre,fecingreso 
FROM RH..empleado
WHERE datename(month,fecingreso)='Enero';
GO

SELECT nombre,fecingreso 
FROM RH..empleado
WHERE datepart(month,fecingreso)=1;
GO

SELECT nombre,fecingreso 
FROM RH..empleado
WHERE month(fecingreso)=1;
GO

-- Pregunta 20. 
/*
Desarrollar una sentencia SELECT para consultar las matriculas del último mes. 
Base de datos EDUCA.
*/

-- ¿Cuál es el ultimo mes?

-- JERAD REY NILSON MIRANDA VASQUEZ14:50

SELECT cur_id,mat_fecha 
FROM EDUCA..MATRICULA
WHERE MONTH(mat_fecha)=(
		SELECT TOP(1) MONTH(mat_fecha) 
		FROM EDUCA..MATRICULA 
		ORDER BY mat_fecha DESC)
GO

SELECT * 
FROM EDUCA..MATRICULA
order by mat_fecha;
go


WITH
V1 AS (
	SELECT MAX(mat_fecha)  FECHA
	FROM EDUCA..MATRICULA 
)
SELECT cur_id,mat_fecha 
FROM EDUCA..MATRICULA M
JOIN V1 ON MONTH(M.mat_fecha) = MONTH(V1.FECHA);
GO


-- Funciones de agregación

-- Pregunta 21. 
/*
Desarrolle una sentencia SELECT para calcular el importe de la 
planilla del departamento de ventas. Debe incluir el sueldo y 
la comisión. Base de datos RH.
*/

-- JAZMIN NICOLE FLORES BALBOA15:09

select SUM(a.sueldo+ isnull(a.comision,0) )  [Importe total]
from rh..empleado a 
INNER JOIN rh..departamento b on  a.iddepartamento=b.iddepartamento
where  b.nombre='Ventas' 
GO


-- Pregunta 22. 
/*
Desarrolle una sentencia SELECT para encontrar el mayor y menor 
sueldo en el departamento de ventas. Base de datos RH.
*/

select MIN(a.sueldo) [Minimo_sueldo] ,MAX(a.sueldo) [Maximo_sueldo]
from rh..empleado a 
INNER JOIN rh..departamento b on  a.iddepartamento=b.iddepartamento
where  b.nombre='Ventas'
Go

-- Pregunta 23.
/*
Desarrolle una sentencia SELECT para encontrar el salario promedio 
en la empresa. Base de datos RH.
*/

-- JAZMIN NICOLE FLORES BALBOA15:14

Select avg(sueldo)[Salario_Promedio] from rh..empleado;
go


-- Pregunta 24.
/*
Desarrolle una sentencia SELECT para encontrar los departamentos que 
tienen por lo menos un trabajador. Base de datos RH.
*/

select * from rh..departamento
where iddepartamento in (select iddepartamento from rh..empleado);
go

-- GROUP BY

/*
Desarrolle una sentencia SELECT para encontrar el salario 
promedio por departamento. Base de datos RH.
*/


SELECT iddepartamento, AVG(sueldo) SUELDO_PROMEDIO
FROM RH..empleado
GROUP BY iddepartamento;
go


SELECT d.iddepartamento, d.nombre, AVG(sueldo) SUELDO_PROMEDIO
FROM RH..empleado e
join rh..departamento d on e.iddepartamento = d.iddepartamento
GROUP BY d.iddepartamento, d.nombre;
go


WITH 
V1 AS (
	SELECT iddepartamento, AVG(sueldo) SUELDO_PROMEDIO
	FROM RH..empleado
	GROUP BY iddepartamento
)
SELECT d.iddepartamento, d.nombre, V1.SUELDO_PROMEDIO
FROM V1 
JOIN RH..departamento D ON V1.iddepartamento = D.iddepartamento;
GO


/*
Desarrolle una sentencia SELECT para encontrar la cantidad de 
trabajadores por departamento. Base de datos RH.
*/


WITH 
V1 AS (
	SELECT iddepartamento, COUNT(idempleado) CANT_TRABAJADORES
	FROM RH..empleado
	GROUP BY iddepartamento
)
SELECT d.iddepartamento, d.nombre, V1.CANT_TRABAJADORES
FROM V1 
JOIN RH..departamento D ON V1.iddepartamento = D.iddepartamento;
GO

SELECT * FROM RH..empleado;
GO


/*
Ventas por mes de un año
Base de datos Northwind
*/

select 
	o.CustomerID,
	sum(iif(month(OrderDate)=1, d.UnitPrice * d.Quantity, 0)) [Enero],
	sum(iif(month(OrderDate)=2, d.UnitPrice * d.Quantity, 0)) [Febrero],
	sum(iif(month(OrderDate)=3, d.UnitPrice * d.Quantity, 0)) [Marzo],
	sum(iif(month(OrderDate)=4, d.UnitPrice * d.Quantity, 0)) [Abril],
	sum(iif(month(OrderDate)=5, d.UnitPrice * d.Quantity, 0)) [Mayo],
	sum(iif(month(OrderDate)=6, d.UnitPrice * d.Quantity, 0)) [Junio],
	sum(iif(month(OrderDate)=7, d.UnitPrice * d.Quantity, 0)) [Julio],
	sum(iif(month(OrderDate)=8, d.UnitPrice * d.Quantity, 0)) [Agosto],
	sum(iif(month(OrderDate)=9, d.UnitPrice * d.Quantity, 0)) [Setiembre],
	sum(iif(month(OrderDate)=10, d.UnitPrice * d.Quantity, 0)) [Octubre],
	sum(iif(month(OrderDate)=11, d.UnitPrice * d.Quantity, 0)) [Noviembre],
	sum(iif(month(OrderDate)=12, d.UnitPrice * d.Quantity, 0)) [Diciembre],
	sum(d.UnitPrice * d.Quantity) [Ventas Totales]
from Northwind..Orders o
join Northwind..[Order Details] d on o.OrderID = d.OrderID
where year(OrderDate) = 1997
group by o.CustomerID;
go




