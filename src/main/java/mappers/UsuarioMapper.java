package mappers;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Usuario;

public class UsuarioMapper {

	ObjectMapper mapper;

	public UsuarioMapper() {
		this.mapper = new ObjectMapper();

	}

	public String toJson(Usuario usuario) {
		try {
			return mapper.writeValueAsString(usuario);
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
		return null;
	}

	/*
	public String toJson(ArrayList<Usuario> listaUsuarios) {
		
		try {
            return mapper.writeValueAsString(listaUsuarios);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "[]"; 
        }
	}
*/
	public String toJson(ArrayList<Usuario> listaUsuarios) {

		StringBuilder listaUsuariosString = new StringBuilder();

		for (int i = 0; i < listaUsuarios.size(); i++) {
			try {
				listaUsuariosString.append(mapper.writeValueAsString(listaUsuarios.get(i)));
				if (i < listaUsuarios.size() - 1) {
					listaUsuariosString.append(",");
				}
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}

		return "[" + listaUsuariosString.toString() + "]";
	}

}
