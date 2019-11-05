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

@WebServlet("/TutorModificarControl")
public class TutorModificarControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TutorModificarControl() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		HttpSession misession = request.getSession();
		
		int codigo = 0;
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String idcodigo= (String) request.getParameter("tutor.codigo");
		String nombre=(String) request.getParameter("tutor.nombre");
		String primerapellido=(String) request.getParameter("tutor.primerapellido");
		String segundoapellido=(String) request.getParameter("tutor.segundoapellido");
		if(idcodigo == null || idcodigo.isEmpty())
		{
			rd = request.getRequestDispatcher("error.jsp");
			codigo = -1;
			misession.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("----> Resultado:"+codigo);
		}
		else
		{
			Tutor tutor1 = new Tutor();
			tutor1.setIdcodigo(idcodigo);
			tutor1.setNombre(nombre);
			tutor1.setPrimerapellido(primerapellido);
			tutor1.setSegundoapellido(segundoapellido);
			TutorBs tutorbs1 = new TutorBs();
			int resultado = tutorbs1.actualizarTutor(tutor1);
			
			System.out.println("el resultado"+resultado);
			
			if (resultado == 1) {
				rd = request.getRequestDispatcher("ExitoModificar.jsp");
				codigo = 1;
				misession.setAttribute("codigo", codigo);
				rd.forward(request, response);
			}else {
				System.err.println("----> error :"+codigo);
			}
			
		}
	}

}
