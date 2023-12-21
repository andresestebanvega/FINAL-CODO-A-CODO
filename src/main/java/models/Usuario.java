package models;

import java.util.UUID;

public class Usuario {

    private int user_Id;

    private String nombre;
    private String apellido;

    private String email;
    private String provincia;
    private String ciudad;
    private String usuario;
    private String direccion;
    private String passwordd;

    public Usuario(String nombre, String apellido, String email, String direccion, String provincia, String ciudad, String usuario, String passwordd) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.direccion = direccion;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.usuario = usuario;
        this.passwordd = passwordd;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getPasswordd() {
        return passwordd;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPasswordd(String passwordd) {
        this.passwordd = passwordd;
    }


    public int getUser_Id() { return user_Id;
    }
    public void setUser_Id(int user_Id) { this.user_Id = user_Id;
    }
}














