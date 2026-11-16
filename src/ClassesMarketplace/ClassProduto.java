package ClassesMarketplace;

public class ClassProduto {
    private int ID_Produto;
    private String nomeProduto;
    private float preco;
    private int qtdeDisponivel;
    private String descricao;
    private int estadoProduto;
    
    private int categoriaID;
    private int enderecoProdutoID;
    private int comercianteID;

    public ClassProduto() {
        this.ID_Produto = 0;
        this.nomeProduto = "";
        this.preco = 0.0f;
        this.qtdeDisponivel = 0;
        this.descricao = "";
        this.estadoProduto = 0;
        
        this.categoriaID = 0;
        this.comercianteID = 0;
        this.enderecoProdutoID = 0;
    }

    public int getID_Produto() {
        return ID_Produto;
    }

    public void setID_Produto(int ID_Produto) {
        this.ID_Produto = ID_Produto;
    }
    
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQtdeDisponivel() {
        return qtdeDisponivel;
    }

    public void setQtdeDisponivel(int qtdeDisponivel) {
        this.qtdeDisponivel = qtdeDisponivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstadoProduto() {
        return estadoProduto;
    }

    public void setEstadoProduto(int estadoProduto) {
        this.estadoProduto = estadoProduto;
    }    

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public int getEnderecoProdutoID() {
        return enderecoProdutoID;
    }

    public void setEnderecoProdutoID(int enderecoProdutoID) {
        this.enderecoProdutoID = enderecoProdutoID;
    }

    public int getComercianteID() {
        return comercianteID;
    }

    public void setComercianteID(int comercianteID) {
        this.comercianteID = comercianteID;
    }
    
}
