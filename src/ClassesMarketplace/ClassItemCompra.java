package ClassesMarketplace;

public class ClassItemCompra {
    private int ID_Compra;
    private String nomeProduto;
    private float precoUnitario;
    private int qtde;
    private String descricao;
    
    private int compraID;
    private int produtoID;

    public ClassItemCompra() {
        this.ID_Compra = 0;
        this.nomeProduto = "";
        this.precoUnitario = 0.0f;
        this.qtde = 0;
        this.descricao = "";
        this.compraID = 0;
        this.produtoID = 0;
    }
    
    public int getID_Compra() {
        return ID_Compra;
    }

    public void setID_Compra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
    }
    
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getCompraID() {
        return compraID;
    }

    public void setCompraID(int compraID) {
        this.compraID = compraID;
    }

    public int getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }

}
