
select * from usuario;
go

select u.IDEMPLEADO, u.USUARIO, '*****' CLAVE, 
u.IDROL, r.NOMBRE, u.ACTIVO
from dbo.USUARIO u
join dbo.EMPLEADO e on u.IDEMPLEADO = e.IDEMPLEADO
join dbo.ROL r on u.IDROL = r.IDROL
where u.USUARIO = 'dmendoza' and u.CLAVE = 'cazador'
and u.ACTIVO = 1 and e.ACTIVO = 1;
go
