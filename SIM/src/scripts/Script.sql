DROP DATABASE IF EXISTS bd_sim;
CREATE DATABASE bd_sim;
USE bd_sim;

CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY auto_increment,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    telefone VARCHAR(13),
    dataNascimento DATE
);

CREATE TABLE Vendedor (
    idVendedor INT PRIMARY KEY auto_increment,
    cpf VARCHAR(11) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    dataAdmissao DATE
);

CREATE TABLE Venda (
    idVenda INT PRIMARY KEY auto_increment,
    vendaValor FLOAT,
    dataVenda DATE,
    FK_Cliente_idCliente INT,
    FK_Vendedor_idVendedor INT
);

CREATE TABLE ListaProdutos (
    quantidade INT,
    FK_Venda_idVenda INT,
    FK_Produto_idProduto INT
);

CREATE TABLE Produto (
    idProduto INT PRIMARY KEY auto_increment,
    descricao VARCHAR(50),
    valor FLOAT,
    quantidade INT
);

CREATE TABLE Endereco (
    idEndereco INT PRIMARY KEY auto_increment,
    rua VARCHAR(50),
    numero INT,
    bairro VARCHAR(50),
    cidade VARCHAR(50),
    estado VARCHAR(50)
);

CREATE TABLE ClienteEndereco (
    FK_Cliente_idCliente INT,
    FK_Endereco_idEndereco INT
);
 
ALTER TABLE Venda ADD CONSTRAINT FK_Venda_1
    FOREIGN KEY (FK_Cliente_idCliente)
    REFERENCES Cliente (idCliente);
 
ALTER TABLE Venda ADD CONSTRAINT FK_Venda_2
    FOREIGN KEY (FK_Vendedor_idVendedor)
    REFERENCES Vendedor (idVendedor);
 
ALTER TABLE ListaProdutos ADD CONSTRAINT FK_ListaProdutos_0
    FOREIGN KEY (FK_Venda_idVenda)
    REFERENCES Venda (idVenda);
 
ALTER TABLE ListaProdutos ADD CONSTRAINT FK_ListaProdutos_1
    FOREIGN KEY (FK_Produto_idProduto)
    REFERENCES Produto (idProduto);
 
ALTER TABLE ClienteEndereco ADD CONSTRAINT FK_ClienteEndereco_0
    FOREIGN KEY (FK_Cliente_idCliente)
    REFERENCES Cliente (idCliente);
 
ALTER TABLE ClienteEndereco ADD CONSTRAINT FK_ClienteEndereco_1
    FOREIGN KEY (FK_Endereco_idEndereco)
    REFERENCES Endereco (idEndereco);

CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL ON bd_sim.* TO admin@localhost;