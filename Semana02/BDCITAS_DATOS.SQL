-- =============================================
-- Seleccionar la Base de Datos
-- =============================================

USE BDCITAS;


-- =============================================
-- Tabla: PARAMETRO
-- =============================================

INSERT INTO PARAMETRO(IDPARAMETRO,NOMBRE, VALOR) 
VALUES( 1, 'NOMBRE DE LA CLINICA', 'CLINICA ESPERANZA');
GO

INSERT INTO PARAMETRO(IDPARAMETRO,NOMBRE, VALOR) 
VALUES( 2, 'RUC DE LA CLINICA', '20547823769');
GO

INSERT INTO PARAMETRO(IDPARAMETRO,NOMBRE, VALOR) 
VALUES( 3, 'DIRECCION DE LA CLINICA', 'CALLE LOS MEDICOS 6578 - DISTRITO NO EXISTE');
GO

INSERT INTO PARAMETRO(IDPARAMETRO,NOMBRE, VALOR) 
VALUES( 4, 'PRECIO DE CONSULTA', '35.00');
GO

-- =============================================
-- Tabla: ESPECIALIDAD
-- minimo: 15
-- =============================================

select * from especialidad;
go

INSERT INTO ESPECIALIDAD( IDESPECIALIDAD, NOMBRE, PACIENTES)
VALUES(1,'EMPLEADO', 0);
GO

INSERT INTO ESPECIALIDAD( IDESPECIALIDAD, NOMBRE, PACIENTES)
VALUES(2,'EMPLEADO', 0);
GO



-- =============================================
-- Tabla: PACIENTE
-- Nueva columna: DISTRITO
-- Minimo: 1000 Filas
-- =============================================

select * from paciente;
go

SET IDENTITY_INSERT PACIENTE ON;
GO


INSERT INTO PACIENTE(IDPACIENTE,NOMBRE,APELLIDO, DNI, CELULAR,CORREO)
VALUES( 1, 'JUAN CARLOS', 'TORRES GARCIA', '43761234', '879823456', 'JTORRES@GMAIL.COM' );
GO


INSERT INTO PACIENTE(IDPACIENTE,NOMBRE,APELLIDO, DNI, CELULAR,CORREO)
VALUES( 2, 'ANA MARIA', 'QUISPE JUARES', '54672345', '965983451', 'AQUISPE@GMAIL.COM' );
GO

SET IDENTITY_INSERT PACIENTE OFF;
GO


