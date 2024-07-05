import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/estudiantes2024a";
        String user = "root";
        String password = "123456";

        String nombre="Ana Garcia";
        String cedula="3470940478";
        double b1=12.4;
        double b2=17.4;

        String sql = "INSERT INTO estudiantes (cedula, nombre, b1, b2) VALUES (?, ?, ?, ?)";


        try (Connection connection= DriverManager.getConnection(url,user,password)){
            PreparedStatement cadenaPreparada = connection.prepareStatement(sql);

            cadenaPreparada.setString(1, cedula);
            cadenaPreparada.setString(2, nombre);
            cadenaPreparada.setDouble(3, b1);
            cadenaPreparada.setDouble(4, b2);

            cadenaPreparada.executeUpdate();
            System.out.println("Estudiante insertado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}