package ClassesMarketplace;

import DAO.GenericDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class ClassCategoria {
    private int ID_Categoria;
    private String nomeCategoria;

    public ClassCategoria() {
        this.ID_Categoria = 0;
        this.nomeCategoria = "";
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public int getID_Categoria() {
        return ID_Categoria;
    }

    public void setID_Categoria(int ID_Categoria) {
        this.ID_Categoria = ID_Categoria;
    }
    
    public void insertCategoria()
        throws ClassNotFoundException, SQLException {

        GenericDAO gDao = new GenericDAO();

        String sql = "INSERT INTO Categoria (Nome) "
                   + "VALUES (?)";

        try (Connection conn = gDao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, getNomeCategoria());

            ps.executeUpdate();
        }
    }
    
    public void AtualizarCategoria(String novoNome, int idCategoria)
        throws ClassNotFoundException, SQLException {
        GenericDAO gDao = new GenericDAO();
        Connection conn = gDao.getConnection();

        String sql = "UPDATE Categoria SET Nome = ? WHERE ID = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, novoNome);
        ps.setInt(2, idCategoria);

        ps.executeUpdate();

    }
    
    public List<ClassCategoria> findAllProduto() throws ClassNotFoundException, SQLException {
        List<ClassCategoria> lista = new ArrayList<>();
        GenericDAO gDao = new GenericDAO();
        Connection conn = gDao.getConnection();
        
        String sql = "SELECT ID, Nome FROM Categoria";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ClassCategoria ct = new ClassCategoria();
            ct.setID_Categoria(rs.getInt("ID"));
            ct.setNomeCategoria(rs.getString("Nome"));
            lista.add(ct);
        }
        rs.close();
        ps.close();
        conn.close();
        return lista;
    }
    
    public void carregarCategorias(JComboBox<String> comboBox) throws ClassNotFoundException {

        try {
            String sql = "SELECT Nome FROM Categoria ORDER BY Nome";
            
            GenericDAO gDao = new GenericDAO();
            Connection conn = gDao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            comboBox.removeAllItems();
            
            while (rs.next()) {
                
                String nome = rs.getString("Nome");
                
                comboBox.addItem(nome);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.getLogger(ClassCategoria.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
