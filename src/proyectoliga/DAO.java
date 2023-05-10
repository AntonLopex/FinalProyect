package proyectoliga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

    public void insertUser(String newUsername, String newPasswd) {
        
        

        String insert = "insert into usuarios values ('"+ newUsername +"','" + newPasswd + "')";
        
          try ( Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/liga", "root", "renaido");
                PreparedStatement ps = conexion.prepareStatement(insert)) {
                int filasInsertadas = ps.executeUpdate(insert);
                System.out.println("Filas insertadas: " + filasInsertadas);
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
        }
        
    }
    
    public void comprobarUser(){
        
        
        String query = "select usuario , contraseña from usuarios";
        
         try ( Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/traballadores", "root", "renaido");
                PreparedStatement ps = conexion.prepareStatement(query)) {
                ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    
                    
                              
                }                          
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
        }
        
    }
    
}