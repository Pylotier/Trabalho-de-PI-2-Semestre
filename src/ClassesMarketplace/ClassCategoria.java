package ClassesMarketplace;

public class ClassCategoria {
    private int ID_Categoria;
    private String nomeCategoria;

    public ClassCategoria() {
        this.ID_Categoria = 0;
        this.nomeCategoria = "";
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public int getID_Categoria() {
        return ID_Categoria;
    }

    public void setID_Categoria(int ID_Categoria) {
        this.ID_Categoria = ID_Categoria;
    }
    
}
