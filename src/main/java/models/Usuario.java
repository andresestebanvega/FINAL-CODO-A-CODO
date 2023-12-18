package models;

import java.util.UUID;

public class Usuario {
	
	private static int contador;
	
	private int idUsuario;
	private UUID idUUID;
	private String nombre;
	private String apellido;

	private String email;
	private String provincia;
	private String ciudad;
	private String usuario;
	private String direccion;
	private String password;

	
	public Usuario(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.idUsuario = ++contador;
		this.idUUID = UUID.randomUUID(); // modo alternativo
	}
	
	public Usuario(int id, String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.idUsuario = id;
		this.idUUID = UUID.randomUUID(); // modo alternativo
	}

	public Usuario(int id, String nombre, String apellido, String email, String provincia, String ciudad, String usuario, String direccion, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.idUsuario = id;
		this.idUUID = UUID.randomUUID(); // modo alternativo
		this.email = email;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.usuario = usuario;
		this.direccion = direccion;
		this.password = password;

	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public UUID getIdUUID() {
		return idUUID;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEmail(String email) { this.email = email;
	}

	public void setProvincia(String provincia) { this.provincia = provincia;
	}

	public void setCiudad(String ciudad) { this.ciudad = ciudad;
	}

	public void setUsuario(String usuario) { this.usuario = usuario;
	}

	public void setDireccion(String direccion) { this.direccion = direccion;
	}

	public void setPassword(String password) { this.password = password;
	}



    public String getEmail() { return email;
    }

	public String getProvincia() { return provincia;
	}

	public String getCiudad() { return ciudad;
	}

	public String getUsuario() { return usuario;
	}

	public String getDireccion() { return direccion;
	}

	public String getPassword() { return password;
	}
}
