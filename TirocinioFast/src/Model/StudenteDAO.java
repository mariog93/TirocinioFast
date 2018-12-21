package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Bean.StudenteBean;

public class StudenteDAO implements AbstractDAO<StudenteBean>{

	private static DataSource ds;

	static {
		try {

			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/TirocinioFast");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	private static final String TABLE_NAME = "Studente";

	@Override
	public synchronized int doSave(StudenteBean studente) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		String querySQL = "INSERT INTO " + StudenteDAO.TABLE_NAME
				+ " (nome, cognome, matricola, luogoNascita, dataNascita, "
				+ "indirizzo, citta, codiceFiscale, telefono, email, username, password, domanda) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, studente.getNome());
			preparedStatement.setString(2, studente.getCognome());
			preparedStatement.setString(3, studente.getMatricola());
			preparedStatement.setString(4, studente.getLuogoNascita());
			preparedStatement.setString(5, studente.getDataNascita());
			preparedStatement.setString(6, studente.getIndirizzo());
			preparedStatement.setString(7, studente.getCitta());
			preparedStatement.setString(8, studente.getCodiceFiscale());
			preparedStatement.setString(9, studente.getTelefono());
			preparedStatement.setString(10, studente.getEmail());
			preparedStatement.setString(11, studente.getUsername());
			preparedStatement.setString(12, studente.getPassword());
			preparedStatement.setString(13, studente.getDomanda());

			preparedStatement.execute();
			result = preparedStatement.getGeneratedKeys();

			if (result.next() && result != null) {
				return result.getInt(1);
			} else {
				return -1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
			} catch (Exception rse) {
				rse.printStackTrace();
			}
			try {
				preparedStatement.close();
			} catch (Exception sse) {
				sse.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception cse) {
				cse.printStackTrace();
			}
		}

		return -1;
	}


	@Override
	public synchronized StudenteBean doRetrieveByKey(StudenteBean studente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		StudenteBean s = new StudenteBean();

		String querySQL = "SELECT * FROM " + StudenteDAO.TABLE_NAME + " WHERE matricola = ?";

		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

			preparedStatement.setString(1, studente.getMatricola());

			preparedStatement.execute();
			result = preparedStatement.getResultSet();

			while (result.next()) {

				s.setNome(result.getString("nome"));
				s.setCognome(result.getString("cognome"));
				s.setMatricola(result.getString("matricola"));
				s.setLuogoNascita(result.getString("luogoNascita"));
				s.setDataNascita(result.getString("dataNascita"));
				s.setIndirizzo(result.getString("citta"));
				s.setCodiceFiscale(result.getString("codiceFiscale"));
				s.setTelefono(result.getString("telefono"));
				s.setEmail(result.getString("email"));
				s.setUsername(result.getString("username"));
				s.setPassword(result.getString("password"));
				s.setDomanda(result.getString("domanda"));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception sse) {
				sse.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception cse) {
				cse.printStackTrace();
			}
		}

		return s;
	}

	@Override
	public synchronized List<StudenteBean> doRetrieveAll() throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		List<StudenteBean> studenti = new ArrayList<StudenteBean>();
		StudenteBean s = new StudenteBean();

		String querySQL = "SELECT * FROM " + StudenteDAO.TABLE_NAME; 

		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

			preparedStatement.execute();
			result = preparedStatement.getResultSet();

			while (result.next()) {

				s.setNome(result.getString("nome"));
				s.setCognome(result.getString("cognome"));
				s.setMatricola(result.getString("matricola"));
				s.setLuogoNascita(result.getString("luogoNascita"));
				s.setDataNascita(result.getString("dataNascita"));
				s.setIndirizzo(result.getString("citta"));
				s.setCodiceFiscale(result.getString("codiceFiscale"));
				s.setTelefono(result.getString("telefono"));
				s.setEmail(result.getString("email"));
				s.setUsername(result.getString("username"));
				s.setPassword(result.getString("password"));
				s.setDomanda(result.getString("domanda"));

				studenti.add(s);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception sse) {
				sse.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception cse) {
				cse.printStackTrace();
			}
		}

		return studenti;
	}


	@Override
	public synchronized boolean doUpdate(StudenteBean studente) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String querySQL = "UPDATE " + StudenteDAO.TABLE_NAME + " SET nome = ?, cognome = ?, luogoNascita = ?, dataNascita = ?,"
				+ " indirizzo = ?, citta = ?, codiceFiscale = ?, telefono = ?, password = ?, domanda = ? WHERE matricola = ?";

		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

			preparedStatement.setString(1, studente.getMatricola());

			preparedStatement.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception sse) {
				sse.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception cse) {
				cse.printStackTrace();
			}
		}

		return false;
	}


	@Override
	public boolean doDelete(StudenteBean studente) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String querySQL = "DELETE FROM " + StudenteDAO.TABLE_NAME + " WHERE matricola = ?";
		
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

			preparedStatement.setString(1, studente.getMatricola());

			preparedStatement.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception sse) {
				sse.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception cse) {
				cse.printStackTrace();
			}
		}

		return false;
	}

}
