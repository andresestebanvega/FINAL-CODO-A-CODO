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

import com.fasterxml.jackson.databind.ObjectMapper;


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
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String direccion = request.getParameter("direccion");
		String provincia = request.getParameter("provincia");
		String ciudad = request.getParameter("ciudad");
		String usuario = request.getParameter("usuario");
		String passwordd = request.getParameter("passwordd");

		System.out.println("nombre de usuario: " + nombre + " " + apellido);
		
//		response.getWriter().write("nombre de usuario: " + nombre + " " + apellido +" ha sido dado de alta");
	
		Usuario newUsuario = new Usuario(nombre, apellido, email, direccion, provincia, ciudad, usuario, passwordd);
		
		// persistir el objeto
		
		sistemaPersistencia.guardarUsuario(newUsuario);

		response.sendRedirect("login.html");
		
	}

}
