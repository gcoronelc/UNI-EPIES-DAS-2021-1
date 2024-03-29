
CREATE TABLE PARAMETRO
( 
	IDPARAMETRO          integer  NOT NULL ,
	DESCRIPCION          varchar(200)  NOT NULL ,
	VALOR                varchar(200)  NOT NULL ,
	CONSTRAINT XPKPARAMETRO PRIMARY KEY (IDPARAMETRO ASC)
)
go



CREATE TABLE DISTRITO
( 
	IDDISTRITO           integer  NOT NULL ,
	NOMBRE               varchar(100)  NOT NULL ,
	CONSTRAINT XPKDISTRITO PRIMARY KEY (IDDISTRITO ASC)
)
go



CREATE TABLE REPARTIDOR
( 
	IDREPARTIDOR         integer  NOT NULL ,
	NOMBRE               varchar(100)  NOT NULL ,
	RUC                  varchar(20)  NOT NULL ,
	IDDISTRITO           integer  NOT NULL ,
	REPRESENTANTE        varchar(100)  NOT NULL ,
	TELEFONO             varchar(20)  NOT NULL ,
	CORREO               varchar(100)  NOT NULL ,
	CONSTRAINT XPKREPARTIDOR PRIMARY KEY (IDREPARTIDOR ASC),
	CONSTRAINT FK_REPARTIDOR_DISTRITO FOREIGN KEY (IDDISTRITO) REFERENCES DISTRITO(IDDISTRITO)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
go



CREATE TABLE CATEGORIA
( 
	IDCATEGORIA          integer  NOT NULL ,
	NOMBRE               varchar(100)  NOT NULL ,
	CONSTRAINT XPKCATEGORIA PRIMARY KEY (IDCATEGORIA ASC)
)
go



CREATE TABLE PRODUCTO
( 
	IDPRODUCTO           integer  NOT NULL ,
	NOMBRE               varchar(100)  NOT NULL ,
	DETALLE              varchar(1000)  NOT NULL ,
	IDCATEGORIA          integer  NOT NULL ,
	PRECOSTO             numeric(12,2)  NOT NULL ,
	PREVENTA             numeric(10,2)  NOT NULL ,
	STOCK                integer  NOT NULL ,
	CONSTRAINT XPKPRODUCTO PRIMARY KEY (IDPRODUCTO ASC),
	CONSTRAINT FK_PRODUCTO_CATEGORIA FOREIGN KEY (IDCATEGORIA) REFERENCES CATEGORIA(IDCATEGORIA)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
go



CREATE TABLE CONTADOR
( 
	IDCONTADOR           integer  NOT NULL ,
	TABLA                varchar(100)  NOT NULL ,
	ULTIMO               integer  NOT NULL ,
	CONSTRAINT XPKCONTADOR PRIMARY KEY (IDCONTADOR ASC)
)
go



CREATE TABLE CLIENTE
( 
	IDCLIENTE            integer  NOT NULL ,
	NOMBRE               varchar(100)  NOT NULL ,
	APELLIDO             varchar(100)  NOT NULL ,
	DNI                  varchar(20)  NOT NULL ,
	IDDISTRITO           integer  NOT NULL ,
	DIRECCION            varchar(150)  NOT NULL ,
	TELEFONO             varchar(20)  NOT NULL ,
	CORREO               varchar(100)  NOT NULL ,
	CONSTRAINT XPKCLIENTE PRIMARY KEY (IDCLIENTE ASC),
	CONSTRAINT FK_CLIENTE_DISTRITO FOREIGN KEY (IDDISTRITO) REFERENCES DISTRITO(IDDISTRITO)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
go


