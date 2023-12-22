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

    public PrimerServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IPersistencia persistenciaSistema = new MemoryRepositoryImpl();

		Usuario usuarioEncontrado = persistenciaSistema.getUsuarioById(request.getParameter("id"));

		UsuarioMapper mapper = new UsuarioMapper();

		String usuarioEncontradoJson = mapper.toJson(usuarioEncontrado);



		ArrayList<Usuario> listaDeUsuarios = sistemaPersistencia.getAll();

		String usuariosJson = mapper.toJson(listaDeUsuarios);

		PrintWriter out = response.getWriter();
		out.write("<h1>REQUEST CONTESTADA DESDE EL SERVLET<h1>");
		out.write("<p>podria ser un párrafo también<p>");
		out.write(usuarioEncontradoJson);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombreInput");
		String apellido = request.getParameter("apellidoInput");
		String email = request.getParameter("emailInput");
		String provincia = request.getParameter("provinciaInput");
		String ciudad = request.getParameter("ciudadInput");
		String usuario = request.getParameter("usuarioInput");
		String direccion = request.getParameter("direccionInput");
		String passwordd = request.getParameter("passworddInput");

		System.out.println("nombre de usuario: " + nombre + " " + apellido + "email: " + email + "direccion: "
						+ direccion + "provincia: " + provincia + "ciudad: " + ciudad + "usuario: " + usuario
						+ "passwordd: " + passwordd);
		
//		//response.getWriter().write("nombre de usuario: " + nombre + " " + apellido +" ha sido dado de alta");
	
		Usuario newUsuario = new Usuario(nombre, apellido, email, provincia, ciudad, usuario,direccion, passwordd);
		
		// persistir el objeto
		
		sistemaPersistencia.guardarUsuario(newUsuario);

		// para devolver el usuario creado tenemos que darle formato Json
		String userJsonFake = String.format(

				"{\"nombre\": \"%s\", \"apellido\": \"%s\", \"email\": \"%s\", \"direccion\": \"%s\"" +
						", \"provincia\": \"%s\", \"ciudad\": \"%s\", \"usuario\": \"%s\", \"passwordd\": \"%s\"  }",

				newUsuario.getNombre(), newUsuario.getApellido(), newUsuario.getEmail(), newUsuario.getDireccion(),
				newUsuario.getProvincia(), newUsuario.getCiudad(), newUsuario.getUsuario(), newUsuario.getPasswordd()
		);

		// podemos utilizar una libreria como Jackson para manipular los json
		UsuarioMapper mapper = new UsuarioMapper();

		String usuarioJson = mapper.toJson(newUsuario);

		response.getWriter().write(usuarioJson);


		response.sendRedirect("login.html");
		
	}

}
