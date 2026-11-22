package ClassesMarketplace;

import DAO.GenericDAO;
import Interfaces.InterGerenciarProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassAdministrador extends ClassIndividuo implements InterGerenciarProduto{
    private int individuo_Registro;
    private String ususario;
    
    public ClassAdministrador() {
        this.individuo_Registro = 0;
        this.ususario = "";
    }
    
    public ClassAdministrador(String ususario, String senha) {
        this.ususario = ususario;
    }

    public int getIndividuo_Registro() {
        return individuo_Registro;
    }

    public void setIndividuo_Registro(int Individuo_Registro) {
        this.individuo_Registro = Individuo_Registro;
    }
    
    public String getUsusario() {
        return ususario;
    }

    public void setUsusario(String ususario) {
        this.ususario = ususario;
    }

    @Override
    public void iniciarSessao(int id) {
        this.individuo_Registro = id;
    }
    
    public int insertAdministrador(ClassAdministrador ca) throws ClassNotFoundException, SQLException {
        GenericDAO gDao = new GenericDAO();
        ClassCarrinho cr = new ClassCarrinho();
        Connection conn = gDao.getConnection();
        
        // INSERT em individuo
        String sqlIndividuo = "INSERT INTO Individuo (Email, Senha) VALUES (?,?)";
        PreparedStatement psIndiv = conn.prepareStatement(sqlIndividuo);
        psIndiv.setString(1, ca.getEmail());
        psIndiv.setString(2, ca.getSenha());
        psIndiv.execute();
        psIndiv.close();

        
        
        // Retorna o ID_Individuo recentimento criado
        String retornoIdIndividuo = "SELECT indi.ID_Registro FROM Individuo AS indi WHERE indi.Email = ?";
        PreparedStatement psRetornaID = conn.prepareStatement(retornoIdIndividuo);
        psRetornaID.setString(1, getEmail());
        
        ResultSet rs = psRetornaID.executeQuery();
        
        if (rs.next()) {
            ca.setIndividuo_Registro(rs.getInt("ID_Registro"));
            System.out.print(getIndividuo_Registro());
        }

        rs.close();
        psRetornaID.close();
        
        // Cria o Cliente
        String sqlAdministador = "INSERT INTO Administrador (ID, Usuario) VALUES (?,?)";
        PreparedStatement psCliente = conn.prepareStatement(sqlAdministador);
        psCliente.setInt(1, getIndividuo_Registro());
        psCliente.setString(2, getUsusario());
        psCliente.execute();
        psCliente.close();
        
        // Cria o carrinho pertecendo ao Cliente
        conn.close();
        
        return getIndividuo_Registro();
    }

    @Override
    public void encerrarSecao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public void RegistrarProduto(String nome, double preco, String descricao, int qtde) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void AplicarPromocao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
    public List<ClassProduto> findAllProduto() throws ClassNotFoundException, SQLException {
        List<ClassProduto> lista = new ArrayList<>();
        GenericDAO gDao = new GenericDAO();
        Connection conn = gDao.getConnection();

        String sql = "SELECT " +
            "prod.nome AS NomeProduto, " +
            "prod.preco AS PrecoProduto, " +
            "prod.Qtde_Disponivel AS Quantidade, " +
            "cat.nome AS NomeCategoria " +
            "FROM Produto AS prod " +
            "INNER JOIN Categoria AS cat " +
            "ON cat.ID = prod.CategoriaID " +
            "INNER JOIN Avaliacao AS ava " +
            "ON prod.ID = ava.ProdutoID";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            ClassProduto cp = new ClassProduto();
            cp.setNomeProduto(rs.getString("NomeProduto"));
            cp.setPreco(rs.getFloat("PrecoProduto"));
            cp.setQtdeDisponivel(rs.getInt("Quantidade"));
            cp.setNomeCategoria(rs.getString("NomeCategoria"));
            lista.add(cp);
        }
        rs.close();
        ps.close();
        conn.close();
        return lista;
    }

    @Override
    public void ExcluirProduto(int Id, String nomeComerciante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void OffSaleProduto(int Id, String nomeComerciante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
