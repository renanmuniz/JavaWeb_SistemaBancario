CREATE DATABASE SISTEMABANCARIO;

USE SISTEMABANCARIO;

CREATE TABLE TB01_PESSOA_FISICA (
 TB01_CPF VARCHAR(11) NOT NULL,
 TB01_NOME VARCHAR(60) NOT NULL,
 TB01_ENDERECO VARCHAR(100) NOT NULL,
 TB01_CIDADE VARCHAR(60) NOT NULL,
 TB01_UF VARCHAR(02) NOT NULL,
 TB01_TELEFONE VARCHAR(11) NOT NULL,
 PRIMARY KEY (TB01_CPF));
 
 
CREATE TABLE TB02_PESSOA_JURIDICA (
 TB02_CNPJ VARCHAR(14) NOT NULL,
 TB02_SOCIO_CPF VARCHAR(11) NOT NULL,
 TB02_RAZAO_SOCIAL VARCHAR(60) NOT NULL,
 TB02_ENDERECO VARCHAR(100) NOT NULL,
 TB02_CIDADE VARCHAR(60) NOT NULL,
 TB02_UF VARCHAR(02) NOT NULL,
 TB02_TELEFONE VARCHAR(11) NOT NULL,
 PRIMARY KEY (TB02_CNPJ));
  
 ALTER TABLE TB02_PESSOA_JURIDICA
 ADD FOREIGN KEY (TB02_SOCIO_CPF) REFERENCES TB01_PESSOA_FISICA(TB01_CPF);
 

CREATE TABLE TB03_AGENCIA (
TB03_NUM_AGENCIA VARCHAR(05) NOT NULL,
TB03_ENDERECO VARCHAR(100) NOT NULL,
TB03_CIDADE VARCHAR(60) NOT NULL,
TB03_ESTADO VARCHAR(02) NOT NULL,
TB03_TELEFONE VARCHAR(11) NOT NULL,
PRIMARY KEY (TB03_NUM_AGENCIA));


CREATE TABLE TB04_CONTA_PF (
TB04_NUM_CONTA INT(08) NOT NULL AUTO_INCREMENT,
TB04_TPO_CONTA VARCHAR(02) DEFAULT "01" NOT NULL,
TB04_NUM_AGENCIA VARCHAR(05) NOT NULL,
TB04_CPF_TITULAR VARCHAR(11) NOT NULL,
TB04_SALDO DOUBLE NOT NULL,
PRIMARY KEY (TB04_NUM_CONTA, TB04_TPO_CONTA, TB04_NUM_AGENCIA));

ALTER TABLE TB04_CONTA_PF
ADD FOREIGN KEY (TB04_CPF_TITULAR) REFERENCES TB01_PESSOA_FISICA(TB01_CPF);
 
ALTER TABLE TB04_CONTA_PF
ADD FOREIGN KEY (TB04_NUM_AGENCIA) REFERENCES TB03_AGENCIA(TB03_NUM_AGENCIA);


CREATE TABLE TB05_CONTA_PJ (
TB05_NUM_CONTA INT(08) NOT NULL AUTO_INCREMENT,
TB05_TPO_CONTA VARCHAR(02) DEFAULT "02" NOT NULL,
TB05_NUM_AGENCIA VARCHAR(05) NOT NULL,
TB05_CNPJ_TITULAR VARCHAR(14) NOT NULL,
TB05_SALDO DOUBLE NOT NULL,
PRIMARY KEY (TB05_NUM_CONTA, TB05_TPO_CONTA, TB05_NUM_AGENCIA));

ALTER TABLE TB05_CONTA_PJ
ADD FOREIGN KEY (TB05_CNPJ_TITULAR) REFERENCES TB02_PESSOA_JURIDICA(TB02_CNPJ);
 
ALTER TABLE TB05_CONTA_PJ
ADD FOREIGN KEY (TB05_NUM_AGENCIA) REFERENCES TB03_AGENCIA(TB03_NUM_AGENCIA);


DESC  TB01_PESSOA_FISICA;
DESC  TB02_PESSOA_JURIDICA;
DESC  TB03_AGENCIA;
DESC  TB04_CONTA_PF;
DESC  TB05_CONTA_PJ;