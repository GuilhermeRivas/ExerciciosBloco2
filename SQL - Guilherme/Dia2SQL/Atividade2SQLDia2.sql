create database db_pizzaria_legal;

use db_pizzaria_legal;

create table tb_categoria(
id bigint auto_increment unique,
tipo varchar(255) not null,
estilo varchar(255) not null,
primary key(id)
);

insert into tb_categoria(tipo,estilo) values("Pizza","Tradicional");
insert into tb_categoria(tipo,estilo) values("Pizza","Especial");
insert into tb_categoria(tipo,estilo) values("Pizza","Doce");
insert into tb_categoria(tipo,estilo) values("Esfiha","Tradicional");
insert into tb_categoria(tipo,estilo) values("Esfiha","Especial");
insert into tb_categoria(tipo,estilo) values("Esfiha","Doce");

create table tb_pizza(
id bigint auto_increment unique,
sabor varchar(255) not null,
categoria_id bigint,
preco decimal(4,2),
tamanho varchar(255) not null
);

insert into tb_pizza(sabor,categoria_id,preco,tamanho) values ("Napolitana", 1, 45.99, "Grande");
insert into tb_pizza(sabor,categoria_id,preco,tamanho) values ("Banana Caramelizada", 3, 45.99, "Media");
insert into tb_pizza(sabor,categoria_id,preco,tamanho) values ("Marguerita", 1, 24.99, "Broto");
insert into tb_pizza(sabor,categoria_id,preco,tamanho) values ("Frango com Bacon e Catupiry", 5, 12.99, "Normal");
insert into tb_pizza(sabor,categoria_id,preco,tamanho) values ("Mussarela", 1, 45.99, "Grande");
insert into tb_pizza(sabor,categoria_id,preco,tamanho) values ("Carne", 4, 6.99, "Normal");
insert into tb_pizza(sabor,categoria_id,preco,tamanho) values ("Catuperoni", 2, 55.99, "Media");
insert into tb_pizza(sabor,categoria_id,preco,tamanho) values ("Morango com Chocolate", 6, 9.99, "Normal");

alter table tb_pizza add foreign key (categoria_id) references tb_categoria(id);

select * from tb_pizza where preco > 45;

select * from tb_pizza where preco between 39 and 60;

select * from tb_pizza where sabor like "%C%";

select * from tb_pizza
inner join tb_categoria on tb_categoria.id = tb_pizza.categoria_id;

select * from tb_pizza
inner join tb_categoria on tb_categoria.id = tb_pizza.categoria_id
where tb_categoria.id = 3 or tb_categoria.id = 6;
