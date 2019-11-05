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

import RegistrarTutor.BS.TutorBs;
import RegistrarTutor.Bean.Tutor;


@WebServlet("/TutorControl")
public class TutorControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TutorControl() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		HttpSession misesion = request.getSession();
		int codigo = 0;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String idcodigo = (String) request.getParameter("tutor.codigo");
		String nombre = (String) request.getParameter("tutor.nombre");
		String primerapellido = (String) request.getParameter("tutor.primerapellido");
		String segundoapellido = (String) request.getParameter("tutor.segundoapellido");
		if (idcodigo==null || idcodigo.isEmpty()) {
			rd= request.getRequestDispatcher("RegistrarTutor.jsp");
			codigo=-1;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("introduca un nombre  " + codigo);
		}
		else if (nombre==null || nombre.isEmpty() ) {
			rd= request.getRequestDispatcher("RegistrarTutor.jsp");
			codigo=-2;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("introduca un nombre  " + codigo);
		} 
		else if (primerapellido==null || primerapellido.isEmpty() ) {
			rd= request.getRequestDispatcher("RegistrarTutor.jsp");
			codigo=-3;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("introduca un primer apellido " + codigo);
		} 
		else if(segundoapellido==null || segundoapellido.isEmpty()) {
			rd= request.getRequestDispatcher("RegistrarTutor.jsp");
			codigo=-4;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("introduca un segundo apellido " + codigo);
		} else {
			Tutor tutor = new Tutor();
			tutor.setIdcodigo(idcodigo);
			tutor.setNombre(nombre);
			tutor.setPrimerapellido(primerapellido);
			tutor.setSegundoapellido(segundoapellido);
			TutorBs tutorbs = new TutorBs();
			int resultado = tutorbs.registrarTutor(tutor);
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
