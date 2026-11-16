package ClassesMarketplace;

public class ClassPromocao {
    private int comercianteID;
    private int produtoID;
    
    private String dataInicio;
    private String dataTermino;
    private int porcentualDescont;
    
    public ClassPromocao(){
        this.comercianteID = 0;
        this.produtoID = 0;
        this.dataInicio = "";
        this.dataTermino = "";
        this.porcentualDescont = 0;
    }
  
    public int getComercianteID() {
        return comercianteID;
    }

    public void setComercianteID(int comercianteID) {
        this.comercianteID = comercianteID;
    }

    public int getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public int getPorcentualDescont() {
        return porcentualDescont;
    }

    public void setPorcentualDescont(int porcentualDescont) {
        this.porcentualDescont = porcentualDescont;
    }
    
    
}
