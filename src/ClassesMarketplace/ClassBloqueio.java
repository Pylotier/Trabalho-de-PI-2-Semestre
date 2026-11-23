package ClassesMarketplace;

public class ClassBloqueio {
    private int administradorID;
    private int comercianteID;
    private String descricao;

    public ClassBloqueio() {
        this.administradorID = 0;
        this.comercianteID = 0;
        this.descricao = "";
    }
    
    public int getAdministradorID() {
        return administradorID;
    }

    public void setAdministradorID(int administradorID) {
        this.administradorID = administradorID;
    }

    public int getComercianteID() {
        return comercianteID;
    }

    public void setComercianteID(int comercianteID) {
        this.comercianteID = comercianteID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
