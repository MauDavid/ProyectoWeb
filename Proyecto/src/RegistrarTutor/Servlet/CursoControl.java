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


@WebServlet("/CursoControl")
public class CursoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CursoControl() {
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
		String fechainicio = (String) request.getParameter("curso.fechainicio");
		String fechafin = (String) request.getParameter("curso.fechafin");
		if (nombre==null || nombre.isEmpty() ) {
			rd= request.getRequestDispatcher("RegistrarCurso.jsp");
			codigo=-2;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("introduca un nombre  " + codigo);
		} 
		else if (fechainicio==null || fechainicio.isEmpty() ) {
			rd= request.getRequestDispatcher("RegistrarCurso.jsp");
			codigo=-3;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("introduca una fecha de inicio " + codigo);
		} 
		else if(fechafin==null || fechafin.isEmpty()) {
			rd= request.getRequestDispatcher("RegistrarCurso.jsp");
			codigo=-4;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("introduca una fecha de fin " + codigo);
		} else {
			Curso curso = new Curso();
			curso.setNombre(nombre);
			curso.setFechaInicio(fechainicio);
			curso.setFechaFin(fechafin);
			CursoBs cursobs = new CursoBs();
			int resultado = cursobs.registrarCurso(curso);
			System.out.println("--->resultado " + resultado);
			if (resultado ==1) {
				System.out.println("--->Dentro del if" + resultado);
				rd = request.getRequestDispatcher("ExitoTutor.jsp");
				codigo = 1;
				misesion.setAttribute("codigo", codigo);
				rd.forward(request, response);
			}
		}

	}
	}


}
