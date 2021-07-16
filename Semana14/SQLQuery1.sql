
select * from dbo.CONTADOR where IDCONTADOR = 5;
select * from dbo.VENTA where IDVENTA = 6;
select * from dbo.DETALLEVENTA where IDVENTA = 6;
go

select * from usuario;
go


select idcliente codigo, 
UPPER(concat(apellido, ', ', nombre)) nombre 
from dbo.cliente;
go

select IDREPARTIDOR codigo, nombre 
from dbo.REPARTIDOR 
where IDDISTRITO = 3;
go


select * from dbo.DISTRITO;
go

select * from dbo.PRODUCTO;
go

select idcategoria codigo, nombre from CATEGORIA order by 2

sp_help PRODUCTO
go




