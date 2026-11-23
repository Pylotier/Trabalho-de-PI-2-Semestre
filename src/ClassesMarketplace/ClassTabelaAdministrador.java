
package ClassesMarketplace;

import DAO.GenericDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassTabelaAdministrador {
    private int ID_Produto;
    private String nomeProduto;
    private float preco;
    private String nomeCategoria;
    private String nomeComerciante;
    private int ID_Comerciante;

    public ClassTabelaAdministrador() {
        this.ID_Produto = 0;
        this.nomeProduto = "";
        this.preco = 0.0f;
        this.nomeCategoria = "";
        this.nomeComerciante = "";
        this.ID_Comerciante = 0;
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

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getNomeComerciante() {
        return nomeComerciante;
    }

    public void setNomeComerciante(String nomeComerciante) {
        this.nomeComerciante = nomeComerciante;
    }

    public int getID_Comerciante() {
        return ID_Comerciante;
    }

    public void setID_Comerciante(int ID_Comerciante) {
        this.ID_Comerciante = ID_Comerciante;
    }
    
    public List<ClassTabelaAdministrador> findAllProduto() throws ClassNotFoundException, SQLException {
        List<ClassTabelaAdministrador> lista = new ArrayList<>();
        GenericDAO gDao = new GenericDAO();
        Connection conn = gDao.getConnection();
        
        String sql = "SELECT prod.ID AS IDProduto, "
        + "prod.Nome AS NomeProduto, "
        + "prod.Preco AS Preco, "
        + "cat.Nome AS Categoria, "
        + "com.Nome AS Comerciante, "
        + "com.IndividuoID_Registro AS IDComerciante FROM Produto AS prod INNER JOIN Categoria AS cat "
        + "ON cat.ID = prod.CategoriaID "
        + "INNER JOIN Comerciante AS com "
        + "ON com.IndividuoID_Registro = prod.ComercianteID";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ClassTabelaAdministrador cta = new ClassTabelaAdministrador();
            cta.setID_Produto(rs.getInt("IDProduto"));
            cta.setNomeProduto(rs.getString("NomeProduto"));
            cta.setPreco(rs.getFloat("Preco"));
            cta.setNomeCategoria(rs.getString("Categoria"));
            cta.setNomeComerciante(rs.getString("Comerciante"));
            cta.setID_Comerciante(rs.getInt("IDComerciante"));

            lista.add(cta);
        }
        rs.close();
        ps.close();
        conn.close();
        return lista;
    }
    
}
