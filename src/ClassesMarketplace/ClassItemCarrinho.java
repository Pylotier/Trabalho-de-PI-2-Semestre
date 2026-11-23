package ClassesMarketplace;

import DAO.GenericDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassItemCarrinho {
    private int individuoID_Registro;
    private int produtoID;
    
    
    private String nomeProduto;
    private float preco;
    private String categoria;
    private int Qtde;
    
    public ClassItemCarrinho() {
        this.individuoID_Registro = 0;
        this.produtoID = 0;
        this.Qtde = 0;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getIndividuoID_Registro() {
        return individuoID_Registro;
    }

    public void setIndividuoID_Registro(int individuoID_Registro) {
        this.individuoID_Registro = individuoID_Registro;
    }

    public int getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }

    public int getQtde() {
        return Qtde;
    }

    public void setQtde(int Qtde) {
        this.Qtde = Qtde;
    }
    
    public void AdicionarAoCarrinho(ClassItemCarrinho cic, int idSessao, int idProduto) throws SQLException, ClassNotFoundException{
        
        GenericDAO gDao = new GenericDAO();
        ClassCarrinho cr = new ClassCarrinho();
        Connection conn = gDao.getConnection();
        
        String sql = "INSERT INTO ItemCarrinho (CarrinhoID, ProdutoID, Qtde) VALUES (?,?,?))";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idSessao);
        ps.setInt(2, idProduto);
        ps.setInt(3, 1);
        ps.execute();
        ps.close();
       
        conn.close();
    }
    
    public List<ClassItemCarrinho> findAllProduto(int idSessao) throws ClassNotFoundException, SQLException {
        List<ClassItemCarrinho> lista = new ArrayList<>();
        GenericDAO gDao = new GenericDAO();
        Connection conn = gDao.getConnection();
        
        String sql = "SELECT prod.Nome AS Nome, " +
        "prod.Preco AS Preco, " +
        "cat.Nome AS Categoria, " +
        "prod.Qtde_Disponivel AS Qtde " +
        "FROM Produto AS prod " +
        "INNER JOIN Categoria AS cat " +
        "ON cat.ID = prod.CategoriaID " +
        "INNER JOIN ItemCarrinho AS item " +
        "ON prod.ID = item.ProdutoID " +
        "INNER JOIN Carrinho AS carr " +
        "ON carr.ClienteID = item.CarrinhoID\n" +
        "INNER JOIN Cliente AS cli " +
        "ON cli.IndividuoID_Registro = carr.ClienteID\n" +
        "WHERE cli.IndividuoID_Registro = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idSessao);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ClassItemCarrinho cic = new ClassItemCarrinho();
            cic.setNomeProduto(rs.getString("Nome"));
            cic.setPreco(rs.getFloat("Preco"));
            cic.setCategoria(rs.getString("Categoria"));
            cic.setQtde(rs.getInt("Qtde"));

            lista.add(cic);
        }
        rs.close();
        ps.close();
        conn.close();
        
        return lista;
    }
    
}
