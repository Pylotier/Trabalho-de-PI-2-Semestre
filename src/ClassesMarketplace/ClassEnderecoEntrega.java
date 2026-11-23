package ClassesMarketplace;
// Usado tanto para os endereços de entrga quanto para estoque

public class ClassEnderecoEntrega {
    private int CompraID;
    
    private String logradouro;
    private int numero;
    private String CEP;
    private String complemento;

    public ClassEnderecoEntrega() {
        this.CompraID = 0;
        this.logradouro = "";
        this.numero = 0;
        this.CEP = "";
        this.complemento = "";
    }

    public int getID() {
        return CompraID;
    }

    public void setID(int CompraID) {
        this.CompraID = CompraID;
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
