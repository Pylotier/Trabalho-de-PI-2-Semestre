package ClassesMarketplace;

import Interfaces.InterAcesso;

public abstract class ClassIndividuo implements InterAcesso{
    private int ID_Registro;
    private String email;
    private String senha;
    private int estadoConta;

    public ClassIndividuo() {
        this.ID_Registro = 0;
        this.email = "";
        this.senha = "";
        this.estadoConta = 0;
    }

    public int getId() {
        return ID_Registro;
    }

    public void setId(int ID_Registro) {
        this.ID_Registro = ID_Registro;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getEstadoConta() {
        return estadoConta;
    }

    public void setEstadoConta(int estadoConta) {
        this.estadoConta = estadoConta;
    }

}
