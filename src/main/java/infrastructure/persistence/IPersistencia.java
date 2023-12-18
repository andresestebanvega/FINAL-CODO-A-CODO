package infrastructure.persistence;

import java.util.ArrayList;

import models.Usuario;

public interface IPersistencia {
	
	// CRUD
	
	// CREATE
	void guardarUsuario(Usuario newUsuario);
	
	// READ
	Usuario getUsuarioById(String idUsuarioBuscado);
	ArrayList<Usuario> getAll();
	
	// UPDATE
	Usuario update(Usuario datosParaActualizar);
	
	// DELETE
	void delete(int id);
	
	
}
