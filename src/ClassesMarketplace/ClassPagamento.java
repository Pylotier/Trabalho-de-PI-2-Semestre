package ClassesMarketplace;

import DAO.GenericDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClassPagamento {
    private int ID_Pagamento;
    private String metodoPagamento;

    public ClassPagamento() {
        this.ID_Pagamento = 0;
        this.metodoPagamento = "";
    }

    public int getID_Pagamento() {
        return ID_Pagamento;
    }

    public void setID_Pagamento(int ID_Pagamento) {
        this.ID_Pagamento = ID_Pagamento;
    }    

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
    
    public void finalizarPagamento(int idSessao){
        
    }
}
