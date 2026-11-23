package ClassesMarketplace;

public class ClassSolicitacao {
    private int ID_Solicitacao;
    private String descricao;

    public ClassSolicitacao() {
        this.ID_Solicitacao = 0;
        this.descricao = "";
    }
    
    public int getID_Solicitacao() {
        return ID_Solicitacao;
    }

    public void setID_Solicitacao(int ID_Solicitacao) {
        this.ID_Solicitacao = ID_Solicitacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
