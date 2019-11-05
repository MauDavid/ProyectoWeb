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


@WebServlet("/TutorBuscarControl")
public class TutorBuscarControl extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    public TutorBuscarControl() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		HttpSession misesion = request.getSession();
		int codigo = 0;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String idcodigo = (String) request.getParameter("tutor.codigo");
		if(idcodigo == null || idcodigo.isEmpty())
		{
			rd= request.getRequestDispatcher("BuscarTutor.jsp");
			codigo=-1;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("introduca el id  " + codigo);
		}
		else
		{
			Tutor tutor1 = new Tutor();
			TutorBs tutorbs = new TutorBs();
			tutor1.setIdcodigo(idcodigo);
			String resp=tutorbs.buscarTutor(tutor1);
			if (resp=="existe")
			{
				
				System.out.println("respuesta: "+resp);
				rd = request.getRequestDispatcher("ModificarTutor.jsp");
				codigo = 1;
				misesion.setAttribute("codigo", codigo);
				rd.forward(request, response);
			}
			else
			{
				System.out.println("Esta mal");
			}
		}
	}
}
