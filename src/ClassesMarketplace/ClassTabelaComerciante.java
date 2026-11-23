package ClassesMarketplace;

import DAO.GenericDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassTabelaComerciante {
    private int idProduto;
    private String nomeProduto;
    private float preco;
    private String nomeCategoria;
    private int estado;
    private int qtde;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
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

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
    
    public List<ClassTabelaComerciante> findAllProduto(int idSessao) throws ClassNotFoundException, SQLException {
        List<ClassTabelaComerciante> lista = new ArrayList<>();
        GenericDAO gDao = new GenericDAO();
        Connection conn = gDao.getConnection();
        
        String sql = "SELECT prod.ID AS ID, "
            + "prod.Nome AS Nome, "
            + "prod.Preco AS Preco, "
            + "cat.Nome AS Categoria, "
            + "prod.Qtde_Disponivel AS Qtde, "
            + "prod.Estado_Produto AS Estado "
            + "FROM Produto AS prod INNER JOIN Categoria AS cat "
            + "ON cat.ID = prod.CategoriaID "
            + "INNER JOIN Comerciante AS com "
            + "ON com.IndividuoID_Registro = prod.ComercianteID "
            + "WHERE com.IndividuoID_Registro = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idSessao);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ClassTabelaComerciante ctcom = new ClassTabelaComerciante();
            ctcom.setIdProduto(rs.getInt("ID"));
            ctcom.setNomeProduto(rs.getString("Nome"));
            ctcom.setPreco(rs.getFloat("Preco"));
            ctcom.setNomeCategoria(rs.getString("Categoria"));
            ctcom.setQtde(rs.getInt("Qtde"));
            ctcom.setEstado(rs.getInt("Estado"));

            lista.add(ctcom);
        }
        rs.close();
        ps.close();
        conn.close();
        return lista;
    }
}
