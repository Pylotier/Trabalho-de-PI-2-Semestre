CREATE DATABASE PI_MarktMoveis
GO
USE PI_MarktMoveis
SELECT * FROM Individuo

CREATE TABLE Individuo(
	ID_Registro INT PRIMARY KEY IDENTITY(1,1),
	Email VARCHAR(150) UNIQUE NOT NULL,
	Senha VARCHAR(255) NOT NULL,
	Estado_Conta INT DEFAULT(1) NOT NULL
)
GO

CREATE TABLE Cliente(
	IndividuoID_Registro INT PRIMARY KEY,
	CPF VARCHAR(11) CHECK(LEN(CPF) = 11),
	FOREIGN KEY (IndividuoID_Registro) REFERENCES Individuo(ID_Registro)
)
GO

CREATE TABLE Comerciante(
	IndividuoID_Registro INT PRIMARY KEY,
	Nome VARCHAR(60) NOT NULL,
	CNPJ CHAR(14) UNIQUE NOT NULL CHECK(LEN(CNPJ) = 14),
	Telefone VARCHAR(13) CHECK (LEN(Telefone) IN (10,11)) NOT NULL,
	FOREIGN KEY (IndividuoID_Registro) REFERENCES Individuo(ID_Registro)
)
GO

CREATE TABLE Administrador(
	ID INT PRIMARY KEY,
	Usuario VARCHAR(60) UNIQUE NOT NULL,
	FOREIGN KEY (ID) REFERENCES Individuo(ID_Registro)

	--Senha VARCHAR(255) NOT NULL
)
GO

CREATE TABLE Solicitacao(
	ID INT PRIMARY KEY IDENTITY(1,1),
	Descricao VARCHAR(255) DEFAULT('Sem descrição'),
	AdministradorID INT,
	ComercianteID INT,
	FOREIGN KEY (AdministradorID) REFERENCES Administrador(ID),
	FOREIGN KEY (ComercianteID) REFERENCES Comerciante(IndividuoID_Registro)
)
GO

CREATE TABLE BloqueioUsuarios(
	AdministradorID INT,
	ComercianteID INT,

	PRIMARY KEY (AdministradorID, ComercianteID),

	Descricao VARCHAR(255) DEFAULT('Sem descrição'),
	FOREIGN KEY (AdministradorID) REFERENCES Administrador(ID),
	FOREIGN KEY (ComercianteID) REFERENCES Comerciante(IndividuoID_Registro)
)
GO

CREATE TABLE Categoria(
	ID INT PRIMARY KEY IDENTITY(1,1),
	Nome VARCHAR(60) NOT NULL
)
GO

CREATE TABLE EnderecoEstoque(
	ID INT PRIMARY KEY IDENTITY(1,1),
	Logradouro VARCHAR(100) NOT NULL,
	Numero INT NOT NULL,
	CEP CHAR(8) CHECK (LEN(CEP) = 8) NOT NULL,
	Complemento VARCHAR(255) DEFAULT('Sem Complemento')
)
GO

CREATE TABLE Produto(
	ID INT PRIMARY KEY IDENTITY(1,1),
	Nome VARCHAR(100) NOT NULL,
	Preco DECIMAL(7,2) CHECK (Preco > 0.0) NOT NULL,
	Qtde_Disponivel INT CHECK(Qtde_Disponivel >= 0) NOT NULL,
	Descricao VARCHAR(255) DEFAULT('Sem descrição'),
	Estado_Produto INT DEFAULT(1),
	CategoriaID INT,
	EnderecoEstoqueID INT,
	ComercianteID INT,
	FOREIGN KEY (CategoriaID) REFERENCES Categoria(ID),
	FOREIGN KEY (EnderecoEstoqueID) REFERENCES EnderecoEstoque(ID),
	FOREIGN KEY (ComercianteID) REFERENCES Comerciante(IndividuoID_Registro)
)
GO

CREATE TABLE Promocao(
	ProdutoID INT,
	Data_Inicio DATE NOT NULL,
	Data_Termino DATE NOT NULL,
	CHECK (Data_Termino > Data_Inicio),
	Porcentual_Desconto INT CHECK (Porcentual_Desconto > 0) NOT NULL,
	PRIMARY KEY (ProdutoID, Data_Inicio),
	FOREIGN KEY (ProdutoID) REFERENCES Produto(ID)
)
GO

CREATE TABLE Avaliacao(
	ID INT PRIMARY KEY IDENTITY(1,1),
	Valor_Avaliacao DECIMAL(2,1)
	CHECK(Valor_Avaliacao BETWEEN 1.0 AND 5.0) NOT NULL,
	ClienteID INT,
	ProdutoID INT,
	FOREIGN KEY (ClienteID) REFERENCES Cliente(IndividuoID_Registro),
	FOREIGN KEY (ProdutoID) REFERENCES Produto(ID)
)
GO

CREATE TABLE Carrinho(
	ClienteID INT PRIMARY KEY,
	Preco_Total DECIMAL(7,2) CHECK (Preco_Total >= 0) DEFAULT(0),
	FOREIGN KEY (ClienteID) REFERENCES Cliente(IndividuoID_Registro)
)
GO

CREATE TABLE ItemCarrinho(
	CarrinhoID INT,
	ProdutoID INT,
	PRIMARY KEY (CarrinhoID, ProdutoID),
	Qtde INT CHECK (Qtde > 0) NOT NULL,
	FOREIGN KEY (CarrinhoID) REFERENCES Carrinho(ClienteID),
	FOREIGN KEY (ProdutoID) REFERENCES Produto(ID)
)
GO

CREATE TABLE Pagamento(
	ID INT PRIMARY KEY IDENTITY(1,1),
	Metodo_Pagamento VARCHAR(40) NOT NULL
)
GO

CREATE TABLE Compra(
	ID INT PRIMARY KEY IDENTITY(1,1),
	Data_Compra DATE NOT NULL,
	Valor_Total DECIMAL(7,2) CHECK (Valor_Total > 0.0) NOT NULL,
	ClienteID INT,
	PagamentoID INT,
	FOREIGN KEY (ClienteID) REFERENCES Cliente(IndividuoID_Registro),
	FOREIGN KEY (PagamentoID) REFERENCES Pagamento(ID)
)
GO

CREATE TABLE EnderecoEntrega(
	CompraID INT PRIMARY KEY,
	Logradouro VARCHAR(100) NOT NULL,
	Numero INT NOT NULL,
	CEP CHAR(8) CHECK (LEN(CEP) = 8) NOT NULL,
	Complemento VARCHAR(255) DEFAULT('Sem Complemento'),
	FOREIGN KEY (CompraID) REFERENCES Compra(ID)
)
GO

CREATE TABLE ItemCompra(
	ID INT PRIMARY KEY IDENTITY(1,1),
	Nome VARCHAR(100) NOT NULL,
	Preco_Unitario DECIMAL(7,2) CHECK (Preco_Unitario > 0.0) NOT NULL,
	Descricao VARCHAR(200) DEFAULT('Sem descrição') NOT NULL,
	Qtde INT CHECK(Qtde > 0),
	CompraID INT,
	ProdutoID INT,
	FOREIGN KEY (CompraID) REFERENCES compra(ID),
	FOREIGN KEY (ProdutoID) REFERENCES Produto(ID)
)
GO