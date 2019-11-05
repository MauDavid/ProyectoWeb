package RegistrarTutor.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import RegistrarTutor.Bean.Curso;


public class CursoDao extends BDConnection {
	public int  registrarCurso(Curso curso) {
		int resultado=0;
		try {
			getConnection();
			if (connection != null) {
				String query = "insert into curso(nombre,fechainicio,fechafin) values(?,?,?)";
				PreparedStatement preparedStatement= connection.prepareStatement(query);
				preparedStatement.setString(1, curso.getNombre());
				preparedStatement.setString(2, curso.getFechaInicio());
				preparedStatement.setString(3, curso.getFechaFin());
				resultado= preparedStatement.executeUpdate();
				if(resultado>=1) {
					System.out.println("Se registraron " + resultado + " columnas");
				} else {
					System.err.println("no se logro registrar ningun registro");
					resultado=-1;
				}
			}
		} catch (SQLException sqle ) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
    
	public int eliminarCurso(Curso curso) {
		int resultado=0;
		try {
			getConnection();
			if (connection != null) {
				String query = "delete from curso where nombre=?";
						PreparedStatement preparedStatement= connection.prepareStatement(query);
						preparedStatement.setString(1, curso.getNombre());
				resultado= preparedStatement.executeUpdate();
				if(resultado>=1) {
					System.out.println("Se eliminaron " + resultado + " columnas");
				} else {
					System.err.println("no se logro eliminar ningun registro");
					resultado=-1;
				}
			}
		} catch (SQLException sqle ) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
}
