package ClassesMarketplace;

public class ClassAvaliacao {
    private int ID_Avaliacao;
    private float valorAvaliacao;
    
    private int produtoID;
    private int individuo_Registro;
    
    public ClassAvaliacao() {
        this.ID_Avaliacao = 0;
        this.valorAvaliacao = 0.0f;
        this.produtoID = 0;
        this.individuo_Registro = 0;
    }

    public int getID_Avaliacao() {
        return ID_Avaliacao;
    }

    public void setID_Avaliacao(int ID_Avaliacao) {
        this.ID_Avaliacao = ID_Avaliacao;
    }

    public float getValorAvaliacao() {
        return valorAvaliacao;
    }

    public void setValorAvaliacao(float valorAvaliacao) {
        this.valorAvaliacao = valorAvaliacao;
    }

    public int getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }

    public int getIndividuo_Registro() {
        return individuo_Registro;
    }

    public void setIndividuo_Registro(int individuo_Registro) {
        this.individuo_Registro = individuo_Registro;
    }
        
    
}
