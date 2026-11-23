package ClassesMarketplace;

public class ClassCompra{
    private int ID_Compra;
    private String dataCompra;
    private float valorTotal;
    
    private int pagamentoID;
    private int individuo_Registro;

    public ClassCompra() {
        this.ID_Compra = 0;
        this.dataCompra = "";
        this.valorTotal = 0.0f;
        this.pagamentoID = 0;
        this.individuo_Registro = 0;
    }

    public int getID_Compra() {
        return ID_Compra;
    }
    
    public void setIdCompra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
    }
    
    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public void setID_Compra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
    }

    public int getPagamentoID() {
        return pagamentoID;
    }

    public void setPagamentoID(int pagamentoID) {
        this.pagamentoID = pagamentoID;
    }

    public int getIndividuo_Registro() {
        return individuo_Registro;
    }

    public void setIndividuo_Registro(int individuo_Registro) {
        this.individuo_Registro = individuo_Registro;
    }
    
}
