package DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class TestarConecxao {
    public static void main(String[] args){
            GenericDAO gDaoSQLSever = new GenericDAO();

            try{
                Connection c = gDaoSQLSever.getConnection();
                String sgbd = c.getMetaData().getDatabaseProductName();
                System.out.println(sgbd);
            } catch (ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }
        }    
}
