package ClassesMarketplace;

public class ClassCliente {
    private String CPF;
    
    private int individuo_Registro;

    ClassCliente(){
        this.CPF = "";
    }
    
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getIndividuo_Registro() {
        return individuo_Registro;
    }

    public void setIndividuo_Registro(int individuo_Registro) {
        this.individuo_Registro = individuo_Registro;
    }
    
}
