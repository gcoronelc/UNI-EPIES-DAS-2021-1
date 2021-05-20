/*
PREGUNTA 1
Se necesita saber la cantidad de pedidos que ha realizado cada cliente, 
que incluya la cantidad de artículos, el importe respectivo y el porcentaje 
que representa del total de pedidos.
*/

WITH 
V1 AS (
	SELECT 
		o.CustomerID, count(distinct o.OrderID) cantPedidos,
		sum(d.Quantity) cantProductos, sum(d.Quantity*d.UnitPrice) importe
	FROM Orders o
	join [Order Details] d on o.OrderID = d.OrderID
	group by o.CustomerID),
V2 AS ( SELECT sum(cantPedidos) pedidosTotales from v1 )
SELECT 
	c.CustomerID, c.CompanyName, V1.cantPedidos, V1.cantProductos, V1.importe,
	Cast(V1.cantPedidos * 100.0 / V2.pedidosTotales AS decimal(10,2)) porcDelTotal
FROM Customers c
join V1 on c.CustomerID = V1.CustomerID
cross join V2
ORDER BY 1;
GO



/*
PREGUNTA 2:
Se necesita saber cuál es el producto más solicitado en cada país, se debe mostrar los empates. 
*/

WITH 
V1 AS (
	SELECT c.Country, d.ProductID, count(distinct o.OrderID) cantPedidos, sum(d.Quantity) cantProductos
	FROM Customers c
	JOIN Orders o ON c.CustomerID = o.CustomerID
	JOIN [Order Details] d ON o.OrderID = d.OrderID
	GROUP BY c.Country, d.ProductID ),
V2 AS (
	SELECT Country, MAX(cantProductos) CantMaxima 
	FROM V1 
	GROUP BY Country )
SELECT V1.Country, p.ProductName, V1.cantPedidos, V1.cantProductos
FROM V1 JOIN V2 on V1.Country = V2.Country and V1.cantProductos = V2.CantMaxima
JOIN Products p on V1.ProductID = p.ProductID
ORDER BY 1, 2;
GO


/*
PREGUNTA 3:
Se necesita saber las ventas totales por producto, en cada categoría. 
*/

SELECT 
	c.CategoryName, p.ProductName, 
	SUM(d.Quantity) cantidad, SUM(d.Quantity*d.UnitPrice) importe
FROM Categories c
JOIN Products p ON c.CategoryID = p.CategoryID
JOIN [Order Details] d ON p.ProductID = d.ProductID 
GROUP BY c.CategoryName, p.ProductName
ORDER BY 1, 2;
GO


/*
PREGUNTA 4:
Cada empleado recibe 5% de comisión de cada venta. 
Se necesita una consulta que permita obtener la comisión que le corresponde 
a cada empleado en cada mes del año 1997.
*/

WITH 
V1 as (
	SELECT 
		o.EmployeeID, MONTH(o.OrderDate) Mes, 
		COUNT(distinct o.OrderID) cantPedidos,
		SUM(d.Quantity*d.UnitPrice) importe
	FROM Orders o
	JOIN [Order Details] d ON o.OrderID = d.OrderID
	WHERE year(o.OrderDate) = 1997
	GROUP BY o.EmployeeID, MONTH(o.OrderDate) )
SELECT
	CONCAT(e.FirstName,', ',e.LastName) empleado,
	V1.Mes, V1.cantPedidos, V1.importe,
	CAST(V1.importe * 0.05 AS decimal(10,2)) comision
FROM Employees e
JOIN V1 on e.EmployeeID = V1.EmployeeID
ORDER BY 1, 2;
GO



/*
PREGUNTA 5:
Se necesita saber el importe de las ventas de cada categoría y que porcentaje
representa del total de las ventas.
*/

WITH
V1 AS (
	SELECT  p.CategoryID, SUM(d.Quantity*d.UnitPrice) ventas
	FROM Products p
	JOIN [Order Details] d ON p.ProductID = d.ProductID 
	GROUP BY p.CategoryID ),
V2 AS (SELECT SUM(ventas) ventasTotales FROM V1)
SELECT 
	c.CategoryID, c.CategoryName, V1.ventas,
	CAST(V1.ventas * 100.0 / V2.ventasTotales AS decimal(10,2)) porcentaje
FROM Categories c 
JOIN V1 ON c.CategoryID = V1.CategoryID
CROSS JOIN V2 
ORDER BY 1;


