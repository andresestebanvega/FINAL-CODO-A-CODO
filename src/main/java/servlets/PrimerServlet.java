package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import infrastructure.persistence.*;
import infrastructure.persistence.memory.*;
import infrastructure.persistence.mysql.MysqlRepositoryImpl;
import mappers.UsuarioMapper;
import models.Usuario;

@WebServlet(urlPatterns = "/endpoint")
public class PrimerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
//	IPersistencia sistemaPersistencia = new MemoryRepositoryImpl();
//	IPersistencia sistemaPersistencia = new FileRepositoryImpl();
	IPersistencia sistemaPersistencia = new MysqlRepositoryImpl();
	UsuarioMapper mapper = new UsuarioMapper();
   
    public PrimerServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Usuario> listaDeUsuarios = sistemaPersistencia.getAll();
		
		String usuariosJson = mapper.toJson(listaDeUsuarios);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().write(usuariosJson);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombreInput");
		String apellido = request.getParameter("apellidoInput");
		
		System.out.println("nombre de usuario: " + nombre + " " + apellido);
		
//		response.getWriter().write("nombre de usuario: " + nombre + " " + apellido +" ha sido dado de alta");
	
		Usuario usuario = new Usuario(nombre, apellido);
		
		// persistir el objeto
		
		sistemaPersistencia.guardarUsuario(usuario);
		
		// para devolver el usuario creado tenemos que darle formato Json
		String userJsonFake = String.format(
				
				"{\"id\": \"%s\", \"nombre\": \"%s\"  }",
				usuario.getIdUsuario(), usuario.getNombre()
				
				);
		
		/* 
		 * { 
		 * 	 "nombre" : "Semper",
		 *   "apellido" : "Evincere"
		 *  }
		 * 
		 * 
		 * 
		 * 
		 * */ 
		// podemos utilizar una libreria como Jackson para manipular los json
		UsuarioMapper mapper = new UsuarioMapper();
		
		String usuarioJson = mapper.toJson(usuario);
		
		response.getWriter().write(usuarioJson);
		
//		response.sendRedirect("confirmacion.html");
		
	}

}
