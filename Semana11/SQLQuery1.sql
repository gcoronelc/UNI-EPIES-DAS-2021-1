
select IIF(2=2,3,4);
go

SELECT ISNULL(2,3);
GO

SELECT ISNULL(NULL,3);
GO


select * from CLIENTE;
go



SELECT IDCLIENTE, NOMBRE, APELLIDO, DNI, IDDISTRITO, DIRECCION, TELEFONO, CORREO FROM CLIENTE  
WHERE IDCLIENTE = ISNULL(?,IDCLIENTE) 
AND NOMBRE LIKE ISNULL(?,NOMBRE) 
AND APELLIDO LIKE ISNULL(?,APELLIDO) 


select * from CONTADOR;

select * from cliente;

/*
PROCESO
1.- Actualizar el contador
2.- Leer el contador
3.- Registrar cliente
*/


INSERT INTO CLIENTE(IDCLIENTE,NOMBRE,APELLIDO,DNI,IDDISTRITO,DIRECCION,TELEFONO,CORREO)
VALUES(?,?,?,?,?,?,?,?)


UPDATE CLIENTE 
SET NOMBRE = ?, APELLIDO = ?, DNI = ?, 
IDDISTRITO = ?, DIRECCION = ?, TELEFONO = ?, 
CORREO = ? WHERE IDCLIENTE  = ?

