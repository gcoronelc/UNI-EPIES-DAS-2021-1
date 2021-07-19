
select * from categoria;
go

select idproducto, nombre, preventa precio, stock
from PRODUCTO 
where IDCATEGORIA = ? and NOMBRE LIKE '%rosas%'
go

select * from CONTADOR;
go

select * from producto;

sp_help producto

select * from venta where idventa=9;
select * from DETALLEVENTA where idventa=9;
go


update producto 
set stock = stock - ? 
where idproducto = ? 






