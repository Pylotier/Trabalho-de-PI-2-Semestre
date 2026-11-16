package Interfaces;

import ClassesMarketplace.ClassIndividuo;
import java.sql.SQLException;


public interface InterCadastroUsuario {
    public void insertUsuario(ClassIndividuo ci) throws ClassNotFoundException, SQLException;
}
