CREATE DATABASE CRUD_PI
GO
USE CRUD_PI

CREATE TABLE Marca(
	ID_Marca INT PRIMARY KEY IDENTITY(1,1),
	Nome VARCHAR(80) NOT NULL
)

CREATE TABLE Categoria(
	ID_Categoria INT PRIMARY KEY IDENTITY(1,1),
	Nome VARCHAR(150) NOT NULL,
)

CREATE TABLE Fornecedor(
	ID_Fornecedor INT PRIMARY KEY IDENTITY(1,1),
	Nome VARCHAR(80) NOT NULL,
	CNPJ CHAR(14) CHECK(LEN(CNPJ) = 14) NOT NULL,
	Telefone VARCHAR(11) NOT NULL
)

CREATE TABLE EnderecoFornecedor(
	PRIMARY KEY (FornecedorID, Logradouro, Numero),
	FornecedorID INT IDENTITY(1,1),
	Logradouro VARCHAR(150),
	Numero INT,
	CEP VARCHAR(14) CHECK (LEN(CEP) = 8) NOT NULL,
	Complemento VARCHAR(255) DEFAULT('Sem Complemento')

)

CREATE TABLE Produto(
	ID_Produto INT PRIMARY KEY IDENTITY(1,1),
	Nome VARCHAR(150) NOT NULL,
	Preco DECIMAL(7,2) NOT NULL,
	Descricao VARCHAR(255) DEFAULT('Sem Descrição'),
	Qtde_Estoque INT DEFAULT(0) CHECK(Qtde_Estoque >= 0),
	CategoriaID INT,
	MarcaID INT,
	FornecedorID INT
	FOREIGN KEY(CategoriaID) REFERENCES Categoria(ID_Categoria),
	FOREIGN KEY(MarcaID) REFERENCES Marca(ID_Marca),
	FOREIGN KEY(FornecedorID) REFERENCES Fornecedor(ID_Fornecedor)
)

CREATE TABLE EnderecoProduto(
	PRIMARY KEY (ProdutoID, Logradouto, Numero),
	ProdutoID INT,
	Logradouto VARCHAR(100),
	Numero INT,
	CEP VARCHAR(14) CHECK (LEN(CEP) = 8),
	Complemento VARCHAR(255) DEFAULT('Sem Complemento'),
	FOREIGN KEY(ProdutoID) REFERENCES Produto(ID_Produto)
)



