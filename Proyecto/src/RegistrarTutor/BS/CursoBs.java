package RegistrarTutor.BS;

import RegistrarTutor.Bean.Curso;
import RegistrarTutor.DAO.CursoDao;

public class CursoBs {
	public int registrarCurso(Curso curso) {
		CursoDao cursoDao = new CursoDao();
		int codigo= (Integer) cursoDao.registrarCurso(curso);
		return codigo;
	}
	
	public int eliminarCurso(Curso curso) {
		CursoDao cursoDao = new CursoDao();
		int codigo= (Integer) cursoDao.eliminarCurso(curso);
		return codigo;
	}
}
