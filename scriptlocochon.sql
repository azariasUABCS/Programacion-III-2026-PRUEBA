drop database prestamos;
create database prestamos;
use prestamos; 


create table cliente (
    id_cliente int auto_increment primary key,
    nombre varchar(45),
    apellido varchar(45),
    edad int,
    domicilio varchar(45),
    numero_casa int,
    numero_celular long,
    correo_electronico varchar(45),
    empleo varchar(45),
    domicilio_empleo varchar(45),
    ingresos_mensuales double,
    numero_cuenta_bancaria int,
    nombre_banco varchar(45),
    curp varchar(45),
    reputacion enum('excelente','buena','regular','mala')
);


create table usuario (
    id_usuario int auto_increment primary key auto_increment,
    nombre varchar(45),
    apellido varchar(45),
    correo_electronico varchar(45),
    contraseña varchar(45),
    capacidad_prestamo varchar(45),
    url_foto varchar(50),
    guardar boolean,
    rol varchar(45) 
);


create table prestamo (
    id_prestamo int auto_increment primary key,
    id_usuario int,
    id_cliente int,
    estado enum('activo','concluso','cancelado'),
    monto double,
    numero_quincenas int,
    monto_quincenal double,
    monto_restante double,
    interes double,
    foreign key (id_usuario) references usuario(id_usuario),
    foreign key (id_cliente) references cliente(id_cliente)
);


create table estado_prestamo (
    id_estado_prestamo int auto_increment primary key,
    id_prestamo int,
    monto_restante varchar(45),
    fecha_proximo_pago date,
    monto_proximo_pago double,
    estado enum('correcto','atrasado'),
    quincenas_atrasadas int,
    foreign key (id_prestamo) references prestamo(id_prestamo)
);




-- 1. Préstamos activos con nombre del cliente y usuario
/*select p.id_prestamo, c.nombre as cliente, u.nombre as usuario, p.monto
from prestamo p
inner join cliente c on p.id_cliente = c.id_cliente
inner join usuario u on p.id_usuario = u.id_usuario
where p.estado = 'activo';

-- 2. Clientes con reputación excelente y sus préstamos
select c.nombre, c.apellido, p.monto, p.estado
from cliente c
inner join prestamo p on c.id_cliente = p.id_cliente
where c.reputacion = 'excelente';

-- 3. Usuarios que han otorgado préstamos mayores a 30000
select u.nombre, u.financiera, p.monto
from usuario u
inner join prestamo p on u.id_usuario = p.id_usuario
where p.monto > 30000;

-- 4. Préstamos atrasados con nombre del cliente y quincenas atrasadas
select c.nombre, c.apellido, e.quincenas_atrasadas
from cliente c
inner join prestamo p on c.id_cliente = p.id_cliente
inner join estado_prestamo e on p.id_prestamo = e.id_prestamo
where e.estado = 'atrasado';

-- 5. Clientes de un banco específico (ejemplo: BBVA) y sus préstamos
select c.nombre, c.nombre_banco, p.monto, p.estado
from cliente c
inner join prestamo p on c.id_cliente = p.id_cliente
where c.nombre_banco = 'BBVA';

-- 6. Préstamos con interés mayor al 12% y estado activo
select p.id_prestamo, c.nombre, p.interes, p.monto
from prestamo p
inner join cliente c on p.id_cliente = c.id_cliente
where p.interes > 12 and p.estado = 'activo';

-- 7. Usuarios con capacidad de préstamo alta y los clientes que atendieron
select u.nombre as usuario, u.capacidad_prestamo, c.nombre as cliente, p.monto
from usuario u
inner join prestamo p on u.id_usuario = p.id_usuario
inner join cliente c on p.id_cliente = c.id_cliente
where u.capacidad_prestamo = 'alta';*/
select * from usuario;