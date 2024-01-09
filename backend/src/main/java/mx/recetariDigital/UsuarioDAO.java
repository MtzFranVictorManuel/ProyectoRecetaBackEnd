package mx.recetariDigital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAO {
    public boolean insertarUsuario(Usuario usuario) {
        String query = "INSERT INTO Usuarios (nombreUsuario, nombres, apellidos, correoElectronico, genero, contraseña) " +
                       "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, usuario.getNombreUsuario());
            statement.setString(2, usuario.getNombres());
            statement.setString(3, usuario.getApellidos());
            statement.setString(4, usuario.getCorreoElectronico());
            statement.setString(5, usuario.getGenero());
            statement.setString(6, usuario.getContraseña());

            int filasInsertadas = statement.executeUpdate();
            return filasInsertadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean verificarUsuario(String nombreUsuario, String contraseña) {
        String query = "SELECT COUNT(*) AS count FROM Usuarios WHERE nombreUsuario = ? AND contraseña = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, nombreUsuario);
            statement.setString(2, contraseña);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
