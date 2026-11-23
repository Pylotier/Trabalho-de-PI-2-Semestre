package ClassesMarketplace;

import DAO.GenericDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassProduto {
    private int ID_Produto;
    private String nomeProduto;
    private float preco;
    private int qtdeDisponivel;
    private String descricao;
    private int estadoProduto;
    private String nomeCategoria;

    
    private int categoriaID;
    private int enderecoProdutoID;
    private int comercianteID;
    
    private int produtoSelecionado;

    public ClassProduto() {
        this.ID_Produto = 0;
        this.nomeProduto = "";
        this.preco = 0.0f;
        this.qtdeDisponivel = 0;
        this.descricao = "";
        this.estadoProduto = 0;
        
        this.categoriaID = 0;
        this.comercianteID = 0;
        this.enderecoProdutoID = 0;
        
        this.nomeCategoria = "";
        this.produtoSelecionado = 0;
    }

    public int getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(int produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public int getID_Produto() {
        return ID_Produto;
    }

    public void setID_Produto(int ID_Produto) {
        this.ID_Produto = ID_Produto;
    }
    
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQtdeDisponivel() {
        return qtdeDisponivel;
    }

    public void setQtdeDisponivel(int qtdeDisponivel) {
        this.qtdeDisponivel = qtdeDisponivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstadoProduto() {
        return estadoProduto;
    }

    public void setEstadoProduto(int estadoProduto) {
        this.estadoProduto = estadoProduto;
    }    

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public int getEnderecoProdutoID() {
        return enderecoProdutoID;
    }

    public void setEnderecoProdutoID(int enderecoProdutoID) {
        this.enderecoProdutoID = enderecoProdutoID;
    }

    public int getComercianteID() {
        return comercianteID;
    }

    public void setComercianteID(int comercianteID) {
        this.comercianteID = comercianteID;
    }
    public String getNomeCategoria() {
    return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
    
    
    public void insertProduto(ClassEnderecoProduto cend, int idEnderecoProduto, String valorCategoria, int idSessao) throws ClassNotFoundException, SQLException {
        GenericDAO gDao = new GenericDAO();
        Connection conn = gDao.getConnection();
        ClassProduto cp = new ClassProduto();
        
        // Retorna o ID da categoria selecionada
        // Retorna o ID da categoria selecionada
        String retornoId = "SELECT ID FROM Categoria WHERE Nome = ?";
        PreparedStatement psRetornaID = conn.prepareStatement(retornoId);
        psRetornaID.setString(1, valorCategoria);
        
        ClassCategoria cte = new ClassCategoria();
        
        ResultSet rs = psRetornaID.executeQuery();
        
        if (rs.next()) {
            cte.setID_Categoria(rs.getInt("ID"));
            System.out.print(cte.getNomeCategoria());
        }

        rs.close();
        psRetornaID.close();
        
        // INSERT em Produto
        String sqlProduto = "INSERT INTO Produto (Nome, Preco, Qtde_Disponivel, Descricao, CategoriaID, EnderecoEstoqueID, ComercianteID) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement psProduto = conn.prepareStatement(sqlProduto);
        psProduto.setString(1, getNomeProduto());
        psProduto.setFloat(2, getPreco()*0.70f);
        psProduto.setInt(3, getQtdeDisponivel());
        psProduto.setString(4, getDescricao());
        psProduto.setInt(5, cte.getID_Categoria());
        psProduto.setInt(6,idEnderecoProduto);
        psProduto.setInt(7, idSessao);
        psProduto.execute();
        psProduto.close();
        
        // Cria o carrinho pertecendo ao Cliente
        psProduto.close();
        conn.close();

    }
    
    public List<ClassProduto> findAllProduto() throws ClassNotFoundException, SQLException {
        List<ClassProduto> lista = new ArrayList<>();
        GenericDAO gDao = new GenericDAO();
        Connection conn = gDao.getConnection();

        String sql = "SELECT " +
            "prod.nome AS NomeProduto, " +
            "prod.preco AS PrecoProduto, " +
            "prod.Qtde_Disponivel AS Quantidade, " +
            "cat.nome AS NomeCategoria " +
            "FROM Produto AS prod " +
            "INNER JOIN Categoria AS cat " +
            "ON cat.ID = prod.CategoriaID " +
            "WHERE prod.Estado_Produto != 0";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            ClassProduto cp = new ClassProduto();
            cp.setNomeProduto(rs.getString("NomeProduto"));
            cp.setPreco(rs.getFloat("PrecoProduto"));
            cp.setQtdeDisponivel(rs.getInt("Quantidade"));
            cp.setNomeCategoria(rs.getString("NomeCategoria"));
            lista.add(cp);
        }
        rs.close();
        ps.close();
        conn.close();
        return lista;
    }
    
    
}
