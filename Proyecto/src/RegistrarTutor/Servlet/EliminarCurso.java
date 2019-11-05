package RegistrarTutor.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import RegistrarTutor.BS.CursoBs;
import RegistrarTutor.Bean.Curso;



/**
 * Servlet implementation class EliminarCurso
 */
@WebServlet("/EliminarCurso")
public class EliminarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EliminarCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		HttpSession misesion = request.getSession();
		int codigo = 0;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		String nombre = (String) request.getParameter("curso.nombre");
		if (nombre==null || nombre.isEmpty() ) {
			rd= request.getRequestDispatcher("EliminarCurso.jsp");
			codigo=-1;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("introduca un nombre  " + codigo);
		}  else {
			Curso curso = new Curso();
			curso.setNombre(nombre);
			CursoBs tutorbs = new CursoBs();
			int resultado = tutorbs.eliminarCurso(curso);
			System.out.println("--->resultado " + resultado);
			if (resultado ==1) {
				System.out.println("--->Dentro del if" + resultado);
				rd = request.getRequestDispatcher("ExitoEliminarTutor.jsp");
				codigo = 1;
				misesion.setAttribute("codigo", codigo);
				rd.forward(request, response);
			}
		}

	}


}
