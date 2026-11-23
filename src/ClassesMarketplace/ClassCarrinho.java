package ClassesMarketplace;

import DAO.GenericDAO;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClassCarrinho {
    private float precoTotal;
    private int individuoID_Registro;

    public ClassCarrinho() {
        this.precoTotal = 0.0f;
        this.individuoID_Registro = 0;
    }
    
    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }
    
    public int getIndividuoID_Registro() {
        return individuoID_Registro;
    }

    public void setIndividuoID_Registro(int individuoID_Registro) {
        this.individuoID_Registro = individuoID_Registro;
    }
    
    public void insertCarrinho(int idPessoa)
        throws ClassNotFoundException, SQLException {

    GenericDAO gDao = new GenericDAO();

    String sql = "INSERT INTO Carrinho (ClienteID, Preco_total) "
               + "VALUES (?, ?)";

    try (Connection conn = gDao.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idPessoa);
        ps.setFloat(2, getPrecoTotal());

        ps.executeUpdate();
    }
}
    
}
