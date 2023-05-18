package proyectoliga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

    public void insertUser(String newUsername, String newPasswd) {

        String insert = "insert into usuarios (usuario, contraseña) values ('" + newUsername + "','" + newPasswd + "')";

        try ( Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/liga", "root", "renaido");  PreparedStatement ps = conexion.prepareStatement(insert)) {
            int filasInsertadas = ps.executeUpdate(insert);
            System.out.println("Filas insertadas: " + filasInsertadas);
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
        }

    }

    public boolean comprobarUser(String userField, String passwdField) {

        String query = "select count(*) from usuarios where usuario = '" + userField + "' and contraseña = '" + passwdField + "';";
        boolean resultadoConsulta = true;
        try ( Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/liga", "root", "renaido");  PreparedStatement ps = conexion.prepareStatement(query)) {
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {

                resultado.getInt(1);
                
                System.out.println(resultado.getInt(1));
                
                if (resultado.getInt(1) == 1) {

                    resultadoConsulta = true;
                } else {
                    resultadoConsulta = false;
                }

            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
        }

        return resultadoConsulta;
    }

}
