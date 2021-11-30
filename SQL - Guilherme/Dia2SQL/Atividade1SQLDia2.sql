create database db_generation_game_online;

use db_generation_game_online;

create table tb_classe(
id bigint auto_increment unique,
profissao varchar(255) not null,
especialidade varchar(255) not null,
primary key(id)
);

insert into tb_classe(profissao,especialidade) values ("Guerreiro","Tanque");
insert into tb_classe(profissao,especialidade) values ("Gladiador","Dano");
insert into tb_classe(profissao,especialidade) values ("Paladino","Tanque");
insert into tb_classe(profissao,especialidade) values ("Clerigo","Suporte");
insert into tb_classe(profissao,especialidade) values ("Feiticeiro","Suporte");
insert into tb_classe(profissao,especialidade) values ("Bruxo","Dano");
insert into tb_classe(profissao,especialidade) values ("Assasino","Dano");
insert into tb_classe(profissao,especialidade) values ("Cacador","Dano");

create table tb_personagem(
id bigint auto_increment unique,
nome varchar(255) not null unique,
classe_id bigint,
ataque int,
defesa int,
raca varchar(255) not null,
sexo varchar(255) not null,
primary key (id),
foreign key (classe_id) references tb_classe(id)
);

insert into tb_personagem(nome,classe_id,raca,sexo,ataque,defesa) values("Godrik",5,"Ogro","Masculino",1000,3000);
insert into tb_personagem(nome,classe_id,raca,sexo,ataque,defesa) values("Famula",7,"Elfo","Feminino",3500,500);
insert into tb_personagem(nome,classe_id,raca,sexo,ataque,defesa) values("Merlin",6,"Humano","Masculino",3000,1235);
insert into tb_personagem(nome,classe_id,raca,sexo,ataque,defesa) values("Lottar",4,"Hob-Goblin","Masculino",1300,3700);
insert into tb_personagem(nome,classe_id,raca,sexo,ataque,defesa) values("Apetra",3,"Valkiria","Feminino",500,5000);
insert into tb_personagem(nome,classe_id,raca,sexo,ataque,defesa) values("Rodrik",3,"Ogro","Masculino",470,4795);
insert into tb_personagem(nome,classe_id,raca,sexo,ataque,defesa) values("Jotnar",2,"Orc","Masculino",2900,1000);
insert into tb_personagem(nome,classe_id,raca,sexo,ataque,defesa) values("Leroy",8,"Elfo","Masculino",4000,200);
insert into tb_personagem(nome,classe_id,raca,sexo,ataque,defesa) values("Luna",4,"Humano","Feminino",1200,4000);
insert into tb_personagem(nome,classe_id,raca,sexo,ataque,defesa) values("Portos",1,"Gigante","Masculino",2000,2900);

select * from tb_personagem where ataque > 2000;

select * from tb_personagem where defesa between 1000 and 2000;

select * from tb_personagem where nome like "%C%";

select * from tb_personagem 
inner join tb_classe on tb_classe.id = tb_personagem.classe_id;

select * from tb_personagem 
inner join tb_classe on tb_classe.id = tb_personagem.classe_id
where tb_classe.id = 4;

