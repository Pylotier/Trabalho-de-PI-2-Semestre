package ClassesMarketplace;

import DAO.GenericDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassCliente extends ClassIndividuo{
    private String CPF;
    
    private int individuo_Registro;

    public ClassCliente(){
        this.individuo_Registro = 0;
        this.CPF = "";
    }
    
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getIndividuo_Registro() {
        return individuo_Registro;
    }

    public void setIndividuo_Registro(int individuo_Registro) {
        this.individuo_Registro = individuo_Registro;
    }
    
    public int insertCliente(ClassCliente cliente) throws ClassNotFoundException, SQLException {
        GenericDAO gDao = new GenericDAO();
        ClassCarrinho cr = new ClassCarrinho();
        Connection conn = gDao.getConnection();
        
        // INSERT em individuo
        String sqlIndividuo = "INSERT INTO Individuo (Email, Senha) VALUES (?,?)";
        PreparedStatement psIndiv = conn.prepareStatement(sqlIndividuo);
        psIndiv.setString(1, cliente.getEmail());
        psIndiv.setString(2, cliente.getSenha());
        psIndiv.execute();
        psIndiv.close();

        
        
        // Retorna o ID_Individuo recentimento criado
        String retornoIdIndividuo = "SELECT indi.ID_Registro FROM Individuo AS indi WHERE indi.Email = ?";
        PreparedStatement psRetornaID = conn.prepareStatement(retornoIdIndividuo);
        psRetornaID.setString(1, getEmail());
        
        ResultSet rs = psRetornaID.executeQuery();
        
        if (rs.next()) {
            cliente.setIndividuo_Registro(rs.getInt("ID_Registro"));
            System.out.print(getIndividuo_Registro());
        }

        rs.close();
        psRetornaID.close();
        
        // Cria o Cliente
        String sqlCliente = "INSERT INTO Cliente (IndividuoID_Registro, CPF) VALUES (?,?)";
        PreparedStatement psCliente = conn.prepareStatement(sqlCliente);
        psCliente.setInt(1, getIndividuo_Registro());
        psCliente.setString(2, getCPF());
        psCliente.execute();
        psCliente.close();
        
        // Cria o carrinho pertecendo ao Cliente
        conn.close();
        
        return getIndividuo_Registro();
    }

    @Override
    public int logIn(String usuario, String senha) {
        try {
            GenericDAO gDao = new GenericDAO();
            Connection conn = gDao.getConnection();
            String sql = "SELECT ID_Registro, senha FROM Individuo WHERE Individuo.Email = ?";
            
            PreparedStatement psLogin = conn.prepareStatement(sql);
            psLogin.setString(1, usuario);
                
            try (ResultSet rs = psLogin.executeQuery()){
                if (rs.next()){
                    String senhaBanco = rs.getString("Senha");

                    if (senhaBanco.equals(senha)){
                        return rs.getInt("ID_Registro");
                    }
                }
            }                       
        } catch (ClassNotFoundException ex) {
            System.getLogger(ClassComerciante.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(ClassComerciante.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return 0; 
    }

    @Override
    public void logOff() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void iniciarSessao(int id) {
        this.individuo_Registro = id;
    }

    @Override
    public void encerrarSecao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
