package RegistrarTutor.BS;

import RegistrarTutor.Bean.Tutor;
import RegistrarTutor.DAO.TutorDao;


public class TutorBs {
	private static String nombreBusq;
	public int registrarTutor(Tutor tutor) {
		TutorDao tutorDao = new TutorDao();
		int codigo= (Integer) tutorDao.registrarTutor(tutor);
		return codigo;
	}
	
	public int eliminarTutor(Tutor tutor) {
		TutorDao tutorDao = new TutorDao();
		int codigo= (Integer) tutorDao.eliminarTutor(tutor);
		return codigo;
	}
	
	public String buscarTutor(Tutor tutor1) {
        String res="";
		TutorDao tutorDao = new TutorDao();
		Tutor tutorbus = new Tutor();
		tutorbus= tutorDao.buscarTutor(tutor1);
		if ((tutorbus.getIdcodigo()!=null)&&tutorbus.getNombre()!=null)
		{
			System.out.println("se encontro la siguiente coincidencia");
			System.out.println("para el id se encontro: "+ tutorbus.getIdcodigo());
			nombreBusq= tutorbus.getIdcodigo();
			System.out.println("para el nombre  se encontro: " + tutorbus.getNombre());
			System.out.println("para el primer apellido se encontro: " + tutorbus.getPrimerapellido());
			System.out.println("para el segundo apellido se encontro: " + tutorbus.getSegundoapellido());
			res="existe";
		}
		else
		{
			System.out.println("no existe");
			res="no existe";
		}
		
		return res;
	}
	public int actualizarTutor(Tutor tutor2) {
		
		Tutor tutor3 = new Tutor();
		tutor3.setIdcodigo(nombreBusq);
		TutorDao tutorDao1 = new TutorDao();
		int codigo=(Integer)tutorDao1.actualizarTutor(tutor2, tutor3);
		return codigo;
	}
}
