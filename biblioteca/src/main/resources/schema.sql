create table IF NOT EXISTS ALMACEN_OLD(
    id bigint auto_increment PRIMARY KEY,
    nombre varchar (25)
);

create table IF NOT EXISTS ALMACEN_NEW(
    id bigint auto_increment PRIMARY KEY,
    nombre varchar(25)
);

create table IF NOT EXISTS LIBRO(
    id bigint auto_increment PRIMARY KEY,
    isbn varchar(25),
    ano INT,
    almacen_old INT,
    almacen_new INT,
    FOREIGN KEY (almacen_old  ) REFERENCES ALMACEN_OLD(id),
    FOREIGN KEY (almacen_new  ) REFERENCES ALMACEN_NEW(id)
);