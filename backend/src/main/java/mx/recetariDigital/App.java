package mx.recetariDigital;

import com.google.gson.Gson;
import static spark.Spark.*;
import spark.Spark;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Configurar los encabezados CORS
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Request-Method", "GET, POST, PUT, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
            // Aquí puedes configurar otros encabezados según sea necesario
        });
        
        // Configuración de Spark
        //port(8080);

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Endpoint POST para crear un nuevo usuario
        Spark.post("/usuarios", (req, res) -> {
            Gson gson = new Gson();
            Usuario nuevoUsuario = gson.fromJson(req.body(), Usuario.class);
            usuarioDAO.insertarUsuario(nuevoUsuario);
            return "Usuario creado exitosamente";
        });

        // Endpoint GET para verificar si un usuario existe
        Spark.post("/login", (req, res) -> {
            String nombreUsuario = req.queryParams("username");
            String contraseña = req.queryParams("password");

            boolean usuarioExiste = usuarioDAO.verificarUsuario(nombreUsuario, contraseña);

            if (usuarioExiste) {
                return "Inicio de sesión exitoso";
            } else {
                res.status(401);
                return "Error al iniciar sesión";
            }
        });
    }
}
