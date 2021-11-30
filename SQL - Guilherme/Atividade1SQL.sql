create database db_rhempresa;

use db_rhempresa;

create table tb_funcionaries(
codigo bigint(5) auto_increment unique,
nome varchar(255) not null,
setor varchar(255) not null,
cargo varchar(255) not null,
salario decimal(8,2),
primary key(codigo)
);

insert into tb_funcionaries (nome,setor,cargo,salario) values ("Joao", "Admnistrativo", "Auxiliar", 1800.00);
insert into tb_funcionaries (nome,setor,cargo,salario) values ("Maria", "Juridico", "Gerente", 25000.00);
insert into tb_funcionaries (nome,setor,cargo,salario) values ("Jose", "Juridico", "Supervisor", 7500.00);
insert into tb_funcionaries (nome,setor,cargo,salario) values ("Antonio", "Recursos Humanos", "Coordenador", 15500.00);
insert into tb_funcionaries (nome,setor,cargo,salario) values ("Marta", "Executivo", "Diretora", 40000.00);

select * from tb_funcionaries where salario > 2000.00;

select * from tb_funcionaries where salario < 2000.00;

update tb_funcionaries set salario = 2300.00 where codigo = 2;
