
CREATE DATABASE BDPROVA1BI;

CREATE USER 'userprova'@'%' IDENTIFIED BY '123';
GRANT ALL ON *.* TO 'userprova'@'%' WITH GRANT OPTION;
flush privileges;

USE BDPROVA1BI;

/***** TABELA FUNCIONARIO *****/
CREATE TABLE tb_clientes (
  id int auto_increment primary key,
  nome varchar(100),
  rg varchar (30),
  cpf varchar (20),
  email varchar(200),
  telefone varchar(30),
  celular varchar(30),
  cep varchar(100),
  endereco varchar (255),
  numero int,
  complemento varchar (200),
  bairro varchar (100),
  cidade varchar (100),
  estado varchar (2),
  data_cadastro varchar (20),
  desconto float
);
/*****************/
