package ClassesMarketplace;

import DAO.GenericDAO;
import Interfaces.InterAcesso;
import Interfaces.InterGerenciarProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClassComerciante extends ClassIndividuo implements InterAcesso, InterGerenciarProduto{
    private int individuoID_Registro;
    private String CNPJ;
    private String telefone;
    private String nomeComerciante;

    public ClassComerciante() {
        this.individuoID_Registro = 0;
        this.CNPJ = "";
        this.telefone = "";
        this.nomeComerciante = "";
    }

    public int getIndividuoID_Registro() {
        return individuoID_Registro;
    }

    public void setIndividuoID_Registro(int individuoID_Registro) {
        this.individuoID_Registro = individuoID_Registro;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeComerciante() {
        return nomeComerciante;
    }

    public void setNomeComerciante(String nomeComerciante) {
        this.nomeComerciante = nomeComerciante;
    }

    // ACESSO
    @Override
    public void logIn(String usuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void logOff() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    // OPERAÇÕES DE GERENCIAR PRODUTO
    @Override
    public void RegistrarProduto(String nome, double preco, String descricao, int qtde) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void AplicarPromocao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClassProduto AtualizarProtudo(String nome, double preco, String descricao, int qtde) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ExcluirProduto(int Id, String nomeComerciante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void OffSaleProduto(int Id, String nomeComerciante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void insertUsuario(ClassComerciante cc) throws ClassNotFoundException, SQLException{
        GenericDAO gDao = new GenericDAO();
        Connection conn = gDao.getConnection();
        String sql = "INSERT INTO Individuo (Email, Senha) VALUES (?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        //ps.setInt(1, ci.getId());
        ps.setString(1, cc.getEmail());
        ps.setString(2, cc.getSenha());
        //ps.setInt(4, ci.getEstadoConta());
        ps.execute();
        
        sql = "INSERT INTO Comerciante (IndividuoID_Registro, Nome, CNPJ, Telefone) VALUES (?,?,?,?)";
        ps = conn.prepareStatement(sql);
        
        //ps.setInt(1, ci.getId());
        ps.setString(1, cc.getNomeComerciante());
        ps.setString(2, cc.getCNPJ());
        ps.setString(3, cc.getTelefone());
        //ps.setInt(4, ci.getEstadoConta());
        
        ps.close();
        conn.close();
    }
}   
   