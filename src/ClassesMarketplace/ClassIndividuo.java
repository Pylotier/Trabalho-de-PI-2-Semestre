package ClassesMarketplace;

import DAO.GenericDAO;
import Interfaces.InterAcesso;
import Interfaces.InterCadastroUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClassIndividuo implements InterAcesso, InterCadastroUsuario{
    private int ID_Registro;
    private String email;
    private String senha;
    private int estadoConta;

    public ClassIndividuo() {
        this.ID_Registro = 0;
        this.email = "";
        this.senha = "";
        this.estadoConta = 0;
    }

    public int getId() {
        return ID_Registro;
    }

    public void setId(int ID_Registro) {
        this.ID_Registro = ID_Registro;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getEstadoConta() {
        return estadoConta;
    }

    public void setEstadoConta(int estadoConta) {
        this.estadoConta = estadoConta;
    }

    @Override
    public void logIn(String usuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void logOff() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void insertUsuario(ClassIndividuo ci) throws ClassNotFoundException, SQLException {
        GenericDAO gDao = new GenericDAO();
        Connection conn = gDao.getConnection();
        String sql = "INSERT INTO Individuo (Email, Senha) VALUES (?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        //ps.setInt(1, ci.getId());
        ps.setString(1, ci.getEmail());
        ps.setString(2, ci.getSenha());
        //ps.setInt(4, ci.getEstadoConta());
        ps.execute();
        ps.close();
        conn.close();
    }
 
    
}
