DROP TABLE topicos;
create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(100) not null unique,
    fecha DATE not null unique,
    estatus boolean not null,
    autor bigint not null,
    curso bigint not null,

    primary key(id)

);