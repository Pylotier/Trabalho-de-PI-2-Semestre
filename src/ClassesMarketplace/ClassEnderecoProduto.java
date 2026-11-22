package ClassesMarketplace;
// Usado tanto para os endereços de entrga quanto para estoque

import DAO.GenericDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassEnderecoProduto {
    private int ID;
    private String logradouro;
    private int numero;
    private String CEP;
    private String complemento;

    public ClassEnderecoProduto() {
        this.ID = 0;
        this.logradouro = "";
        this.numero = 0;
        this.CEP = "";
        this.complemento = "";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }   
 
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
    
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    } 
    
    public int insertEnderecoProduto(ClassEnderecoProduto cend) throws ClassNotFoundException, SQLException {
        GenericDAO gDao = new GenericDAO();
        Connection conn = gDao.getConnection();
           
        // INSERT em Produto
        String sqlProduto = "INSERT INTO EnderecoEstoque (Logradouro, Numero, CEP, Complemento) VALUES (?,?,?,?)";
        PreparedStatement psProduto = conn.prepareStatement(sqlProduto);
        psProduto.setString(1, cend.getLogradouro());
        psProduto.setInt(2, cend.getNumero());
        psProduto.setString(3, cend.getCEP());
        psProduto.setInt(4, cend.getNumero());        
        psProduto.execute();
        psProduto.close();
        
        // Retorna o ID da categoria selecionada
        String retornoIdIndividuo = "SELECT ende.ID FROM EnderecoEstoque AS ende WHERE ende.Logradouro = ? AND ende.Numero = ?";
        PreparedStatement psRetornaID = conn.prepareStatement(retornoIdIndividuo);
        psRetornaID.setString(1, getLogradouro());
        psRetornaID.setInt(2, getNumero());
        
        ResultSet rs = psRetornaID.executeQuery();
        
        if (rs.next()) {
            cend.setID(rs.getInt("ID"));
            System.out.print(getID());
        }

        rs.close();
        psRetornaID.close();
     

        conn.close();
        
        return getID();
    }
}
