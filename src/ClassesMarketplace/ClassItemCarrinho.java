package ClassesMarketplace;

public class ClassItemCarrinho {
    private int individuoID_Registro;
    private int produtoID;
    private int Qtde;

    public ClassItemCarrinho() {
        this.individuoID_Registro = 0;
        this.produtoID = 0;
        this.Qtde = 0;
    }
    
    public int getIndividuoID_Registro() {
        return individuoID_Registro;
    }

    public void setIndividuoID_Registro(int individuoID_Registro) {
        this.individuoID_Registro = individuoID_Registro;
    }

    public int getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }

    public int getQtde() {
        return Qtde;
    }

    public void setQtde(int Qtde) {
        this.Qtde = Qtde;
    }
    
}
