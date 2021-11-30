create database db_escola;

use db_escola;

create table tb_matricula(
mat bigint(5) auto_increment unique,
nome varChar(255) not null,
periodo varchar(255) not null,
ano varchar(255) not null,
nota double
);

insert into tb_matricula(nome,periodo,ano,nota) values("Pedro", "Vespertino","5 ANO", 7.9);
insert into tb_matricula(nome,periodo,ano,nota) values("Hugo", "Vespertino","3 ANO", 9);
insert into tb_matricula(nome,periodo,ano,nota) values("Aurora", "Integral","8 ANO", 6.9);
insert into tb_matricula(nome,periodo,ano,nota) values("Apolo", "Integral","9 ANO", 8);
insert into tb_matricula(nome,periodo,ano,nota) values("Catharina", "Vespertino","5 ANO", 6.75);
insert into tb_matricula(nome,periodo,ano,nota) values("Matheus", "Matutino","6 ANO", 10);
insert into tb_matricula(nome,periodo,ano,nota) values("Rafaella", "Matutino","7 ANO", 7.67);
insert into tb_matricula(nome,periodo,ano,nota) values("Caio", "Integral","8 ANO", 4.5);

select * from tb_matricula where nota > 7;
select * from tb_matricula where nota < 7;

alter table tb_matricula add primary key (mat);

update tb_matricula set nota = 1.5 where mat = 6 