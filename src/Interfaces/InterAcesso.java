package Interfaces;

public interface InterAcesso {
    public int logIn(String usuario, String senha);
    public void logOff();
    public void iniciarSessao(int id);
    public void encerrarSecao();
}
