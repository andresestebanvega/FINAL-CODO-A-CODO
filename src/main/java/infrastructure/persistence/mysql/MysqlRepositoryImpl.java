package infrastructure.persistence.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import infrastructure.persistence.IPersistencia;
import models.Usuario;

public class MysqlRepositoryImpl implements IPersistencia {

	private Connection conexion;
	
	public MysqlRepositoryImpl() {
		conexion = ConexionBD.getConnection();
	}
	
	
	@Override
	public void guardarUsuario(Usuario newUsuario) {
		String query = "INSERT INTO users (nombre,apellido,email,provincia,ciudad,USER_NAME, direccion, passwordd) VALUES (?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement statement = conexion.prepareStatement(query);
			
			statement.setString(1, newUsuario.getNombre());
			statement.setString(2, newUsuario.getApellido());
			statement.setString(3, newUsuario.getEmail());
			statement.setString(4, newUsuario.getProvincia());
			statement.setString(5, newUsuario.getCiudad());
			statement.setString(6, newUsuario.getUsuario());
			statement.setString(7, newUsuario.getDireccion());
			statement.setString(8, newUsuario.getPasswordd());

			
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Usuario getUsuarioById(String idUsuarioBuscado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Usuario> getAll() {
		
		/*
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		String query = "SELECT * FROM users";
		
		try {
			PreparedStatement statement = conexion.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				// obtener los datos de cada usuario en el resultado
				int id = result.getInt("id");
				String nombre = result.getString("nombre");
				String apellido = result.getString("apellido");
				String email = result.getString("email");
				String provincia = result.getString("provincia");
				String ciudad = result.getString("ciudad");
				String usuario = result.getString("USER_NAME");
				String direccion = result.getString("direccion");
				String passwordd = result.getString("passwordd");
				
				// crear un nuevo objeto 
				Usuario usuarioNew = new Usuario(nombre, apellido, email, provincia, ciudad, usuario, direccion,passwordd);
				usuarios.add(usuarioNew);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarios;

		 */
		return null;
	}

	@Override
	public Usuario update(Usuario datosParaActualizar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
