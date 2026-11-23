package ClassesMarketplace;

import DAO.GenericDAO;
import Interfaces.InterAcesso;
import Interfaces.InterGerenciarProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassComerciante extends ClassIndividuo implements InterGerenciarProduto, InterAcesso{
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
    public int logIn(String usuario, String senha) {
        try {
            GenericDAO gDao = new GenericDAO();
            Connection conn = gDao.getConnection();
            String sql = "SELECT ID_Registro, senha FROM Individuo WHERE Individuo.Email = ?";
            //String sql = "SELECT ID_Registro, senha FROM Individuo INNER JOIN Comerciante " +
            //" ON Individuo.ID_Registro = Comerciante.IndividuoID_Registro " +
            //" WHERE Individuo.Email = ?' AND Comerciante.CNPJ = ?";
            
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
        this.individuoID_Registro = id;
    }

    @Override
    public void encerrarSecao() {
        this.individuoID_Registro = 0;
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
    public void ExcluirProduto(int Id) {
        try{
            GenericDAO gDao = new GenericDAO();
            Connection conn = gDao.getConnection();

            String sql = "DELETE FROM Produto WHERE ID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Id);
            
            ps.execute();
            ps.close();

            conn.close();
        } catch (ClassNotFoundException ex) {
            System.getLogger(ClassComerciante.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(ClassComerciante.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @Override
    public void OffSaleProduto(int Id) {
        try {
            GenericDAO gDao = new GenericDAO();
            Connection conn = gDao.getConnection();
            
            String sql = "UPDATE Produto SET Estado_Produto = 0 WHERE ID = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Id);
            
            ps.execute();
            ps.close();
            
            conn.close();
        } catch (ClassNotFoundException ex) {
            System.getLogger(ClassAdministrador.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(ClassAdministrador.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @Override
    public void AtualizarProtudo(ClassProduto cp, ClassEnderecoProduto cend, int id) {
        try {
            GenericDAO gDao = new GenericDAO();
            Connection conn = gDao.getConnection();
            
            String sql = "UPDATE Produto SET "
            + "Nome = ?, "
            + "Preco = ?, "
            + "Qtde = ?, "
            + "Descricao = ?, "
            + "CategoriaID = ?"
            + "CEP = ?, "
            + "Logradouro = ?, "
            + "Numero = ?, "
            + "Complemento = ? "
            + "WHERE ID = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cp.getNomeProduto());
            ps.setFloat(2, cp.getPreco());
            ps.setInt(3, cp.getQtdeDisponivel());
            ps.setString(4, cp.getDescricao());
            ps.setString(5, cp.getNomeCategoria());
            ps.setString(6, cend.getCEP());
            ps.setString(7, cend.getLogradouro());
            ps.setInt(8, cend.getNumero());
            ps.setString(9, cend.getComplemento());
            ps.setInt(10, id);
            
            ps.execute();
            ps.close();
            
            conn.close();
        } catch (ClassNotFoundException ex) {
            System.getLogger(ClassAdministrador.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(ClassAdministrador.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public int insertUsuario(ClassComerciante cm) throws ClassNotFoundException, SQLException{
        GenericDAO gDao = new GenericDAO();
        Connection conn = gDao.getConnection();
        
        // INSERT em individuo
        String sqlIndividuo = "INSERT INTO Individuo (Email, Senha) VALUES (?,?)";
        PreparedStatement psIndiv = conn.prepareStatement(sqlIndividuo);
        psIndiv.setString(1, cm.getEmail());
        psIndiv.setString(2, cm.getSenha());
        psIndiv.execute();
        psIndiv.close();
        
        
        // Retorna o ID_Individuo recentimento criado
        String retornoIdIndividuo = "SELECT indi.ID_Registro FROM Individuo AS indi WHERE indi.Email = ?";
        PreparedStatement psRetornaID = conn.prepareStatement(retornoIdIndividuo);
        psRetornaID.setString(1, cm.getEmail());
        
        ResultSet rs = psRetornaID.executeQuery();
        
        if (rs.next()) {
            cm.setIndividuoID_Registro(rs.getInt("ID_Registro"));
            System.out.print(cm.getIndividuoID_Registro());
        }

        rs.close();
        psRetornaID.close();
        
        // Cria o Cliente
        String sqlCliente = "INSERT INTO Comerciante (IndividuoID_Registro, Nome, CNPJ, Telefone) VALUES (?,?,?,?)";
        PreparedStatement psComerciante = conn.prepareStatement(sqlCliente);
        psComerciante.setInt(1, cm.getIndividuoID_Registro());
        psComerciante.setString(2, getNomeComerciante());
        psComerciante.setString(3, getCNPJ());
        psComerciante.setString(4, getTelefone());
        psComerciante.execute();
        psComerciante.close();
        
        // Cria o carrinho pertecendo ao Cliente
        conn.close();
        
        return cm.getIndividuoID_Registro();
    }

    @Override
    public String definirNome(int idSessao) {
        try {
            GenericDAO gDao = new GenericDAO();
            Connection conn = gDao.getConnection();
            String retornoNome = "SELECT " +
                    "SUBSTRING(Email, 1, CHARINDEX('@', Email) - 1) AS Email_Nome " +
                    "FROM Individuo AS indi";
            PreparedStatement psRetornaNome = conn.prepareStatement(retornoNome);
            psRetornaNome.setInt(1, idSessao);
            
            ResultSet rs = psRetornaNome.executeQuery();
            
            if (rs.next()) {
                String nome = rs.getString("Email_Nome");
                return nome;
            }
            
            rs.close();
            psRetornaNome.close();
            
        } catch (ClassNotFoundException ex) {
            System.getLogger(ClassComerciante.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(ClassComerciante.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return "Não Achado";
    }


}   
   