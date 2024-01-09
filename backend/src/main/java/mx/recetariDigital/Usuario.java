package mx.recetariDigital;

public class Usuario {
    private int idUsuarios;
    private String nombreUsuario;
    private String nombres;
    private String apellidos;
    private String correoElectronico;
    //private String genero;
    private String contraseña;

    // Constructor vacío (puedes agregar otros constructores según necesites)
    public Usuario() {
    }

    // Getters y Setters para los campos
    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

   /*  public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }*/

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
