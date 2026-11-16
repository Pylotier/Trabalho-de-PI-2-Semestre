package ClassesMarketplace;
// Usado tanto para os endereços de entrga quanto para estoque
public class ClassEnderecoProduto {
    private int ID;
    private String logradouro;
    private int numero;
    private String CEP;
    private String complemento;

    public ClassEnderecoProduto() {
        this.ID = 0;
        this.logradouro = "";
        this.numero = 0;
        this.CEP = "";
        this.complemento = "";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }   
 
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
    
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    } 
    
}
