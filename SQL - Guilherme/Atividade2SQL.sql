create database db_ecommerce;

use db_ecommerce;

create table tb_estoque(
prodId bigint(5) auto_increment unique,
nome varchar(255) not null,
quantidade int,
categoria varchar(255) not null,
valor decimal(8,2),
primary key (prodId)
);


insert into tb_estoque (nome,quantidade,categoria,valor) values ("Lampada", 25000, "Casa", 10.00);
insert into tb_estoque (nome,quantidade,categoria,valor) values ("Geladeira", 70, "Eletrodomesticos", 1500.00);
insert into tb_estoque (nome,quantidade,categoria,valor) values ("Liquidificador", 188, "Eletrodomesticos", 200.00);
insert into tb_estoque (nome,quantidade,categoria,valor) values ("Maquina de Lavar", 100, "Eletrodomesticos", 2000.00);
insert into tb_estoque (nome,quantidade,categoria,valor) values ("Vaso pequeno", 100, "Decoracao", 30.00);
insert into tb_estoque (nome,quantidade,categoria,valor) values ("Vaso Sanitario", 100, "Casa", 345.00);
insert into tb_estoque (nome,quantidade,categoria,valor) values ("Coller", 40, "Lazer", 100.00);
insert into tb_estoque (nome,quantidade,categoria,valor) values ("Churrasqueira", 50, "Lazer", 599.00);

select * from tb_estoque where valor > 500.00;

select * from tb_estoque where valor < 500.00;

update tb_estoque set quantidade = 2500 where prodId = 1;