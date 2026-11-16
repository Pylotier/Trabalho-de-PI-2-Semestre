package ClassesMarketplace;

import Interfaces.InterAcesso;
import Interfaces.InterGerenciarProduto;

public class ClassAdministrador extends ClassIndividuo{
    private int individuo_Registro;
    private String ususario;
    
    public ClassAdministrador() {
        this.individuo_Registro = 0;
        this.ususario = "";
    }
    
    public ClassAdministrador(String ususario, String senha) {
        this.ususario = ususario;
    }

    public int getIndividuo_Registro() {
        return individuo_Registro;
    }

    public void setIndividuo_Registro(int Individuo_Registro) {
        this.individuo_Registro = Individuo_Registro;
    }
    
    public String getUsusario() {
        return ususario;
    }

    public void setUsusario(String ususario) {
        this.ususario = ususario;
    }

}
