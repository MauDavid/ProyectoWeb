package RegistrarTutor.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import RegistrarTutor.Bean.Tutor;

public class TutorDao extends BDConnection {
	public int  registrarTutor(Tutor tutor) {
		int resultado=0;
		try {
			getConnection();
			if (connection != null) {
				String query = "insert into tutor(idcodigo,nombre,primerapellido,segundoapellido) values(?,?,?,?)";
				PreparedStatement preparedStatement= connection.prepareStatement(query);
				preparedStatement.setString(1, tutor.getIdcodigo());
				preparedStatement.setString(2, tutor.getNombre());
				preparedStatement.setString(3, tutor.getPrimerapellido());
				preparedStatement.setString(4, tutor.getSegundoapellido());
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
    
	public int eliminarTutor(Tutor tutor) {
		int resultado=0;
		try {
			getConnection();
			if (connection != null) {
				String query = "delete from tutor where idcodigo=?";
						PreparedStatement preparedStatement= connection.prepareStatement(query);
						preparedStatement.setString(1, tutor.getIdcodigo());
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
	public Tutor buscarTutor(Tutor tutor1) {
	       Tutor tutordao = new Tutor();
			try {
				getConnection();
				if (connection != null) {	
					String query ="SELECT * FROM tutor WHERE idcodigo = (?)";
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, tutor1.getIdcodigo());
					ResultSet rs = preparedStatement.executeQuery();
					//System.out.println("Numero de coincidencias: " + rs.getRow());
					if (rs.getRow() >= 0) {
						if (rs.next()) {
							tutordao.setIdcodigo(rs.getNString("idcodigo"));
							tutordao.setNombre(rs.getString(2));
							tutordao.setPrimerapellido(rs.getString(3));
							tutordao.setSegundoapellido(rs.getString(4));
						}else {
							tutordao.setCodigo(-1);// Error
						} 
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			cerrrarConexion();
			return tutordao;
	}	
	public int actualizarTutor(Tutor tutor2, Tutor tutor3) {
		int resultado=0;
		try {
			getConnection();
			if (connection != null) {
				String query = "UPDATE tutor SET idcodigo=(?), nombre=(?), primerapellido=(?), segundoapellido=(?) WHERE idcodigo = (?)";
				Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, tutor2.getIdcodigo());
				preparedStatement.setString(2, tutor2.getNombre());
				preparedStatement.setString(3, tutor2.getPrimerapellido());
				preparedStatement.setString(4, tutor2.getSegundoapellido());
				preparedStatement.setString(5, tutor3.getIdcodigo());
				resultado= preparedStatement.executeUpdate();
				if (resultado>=1) {
				
					System.err.println("Se actualizo la informacion correctamente");
				} else {
					
					System.err.println("No se puedo realizar la actualizacion");
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
}
