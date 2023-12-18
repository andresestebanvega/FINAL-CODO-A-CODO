package infrastructure.persistence.memory;

import java.util.ArrayList;
import java.util.List;

import infrastructure.persistence.*;
import models.Usuario;

public class MemoryRepositoryImpl implements IPersistencia {

	private static List<Usuario> usuarioGuardados = new ArrayList<>();
	
	@Override
	public void guardarUsuario(Usuario newUsuario) {
		
		MemoryRepositoryImpl.usuarioGuardados.add(newUsuario);
		System.out.println("USUARIO GUARDADO EN MEMORIA ...");
	}

	@Override
	public Usuario getUsuarioById(String idUsuarioBuscado) {
		
		 int index = Integer.parseInt(idUsuarioBuscado) - 1;
	        if (index >= 0 && index < usuarioGuardados.size()) {
	            return usuarioGuardados.get(index);
	        }
	        return null; // Manejar el caso si el índice está fuera de rango
		
	}

	@Override
	public ArrayList<Usuario> getAll() {
		
		return new ArrayList<>(usuarioGuardados); // Devolver una copia de la lista para evitar modificaciones externas
	}

	@Override
	public Usuario update(Usuario datosParaActualizar) {
		
		for (Usuario usuario : usuarioGuardados) {
            if (usuario.getIdUsuario() == (datosParaActualizar.getIdUsuario())) {
                // Actualizar los datos del usuario
                usuario.setNombre(datosParaActualizar.getNombre());
                usuario.setApellido(datosParaActualizar.getApellido());
                return usuario;
            }
        }
        return null; // Manejar el caso si no se encuentra el usuario a actualizar
	}

	@Override
	public void delete(int id) {
		
		usuarioGuardados.removeIf(usuario -> usuario.getIdUsuario()==(id)); // Eliminar usuario por ID
		
	}

}
