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

import Bean.TutorBean;

public class TutorAccademicoDAO implements AbstractDAO<TutorBean>{
	
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
	
	private static final String TABLE_NAME = "TutorAccademico";

	@Override
	public synchronized int doSave(TutorBean tutor) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		String querySQL = "INSERT INTO " + TutorAccademicoDAO.TABLE_NAME + " (nome, cognome, matricola, username, password, domanda)" +
				"VALUES (?, ?, ?, ?, ?, ?)";
		
		try{
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, tutor.getNome());
			preparedStatement.setString(2, tutor.getCognome());
			preparedStatement.setString(3, tutor.getMatricola());
			preparedStatement.setString(4, tutor.getUsername());
			preparedStatement.setString(5, tutor.getPassword());
			preparedStatement.setString(6, tutor.getDomanda());
			
			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			
			if(result.next() && result != null){
				return result.getInt(1);
			}else{
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
	public synchronized TutorBean doRetrieveByKey(TutorBean tutor) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		TutorBean t = new TutorBean();
		
		String querySQL = "SELECT * FROM " + TutorAccademicoDAO.TABLE_NAME + " WHERE matricola = ?";
		
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

			preparedStatement.setString(1, tutor.getMatricola());

			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			
			while(result.next()){
				
				t.setNome(result.getString("nome"));
				t.setCognome(result.getString("cognome"));
				t.setMatricola(result.getString("matricola"));
				t.setUsername(result.getString("username"));
				t.setPassword(result.getString("password"));
				t.setDomanda(result.getString("domanda"));
				
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

		return t;
	}

	@Override
	public synchronized List<TutorBean> doRetrieveAll() throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		List<TutorBean> tutor = new ArrayList<TutorBean>();
		TutorBean t = new TutorBean();
		
		String querySQL = "SELECT * FROM " + TutorAccademicoDAO.TABLE_NAME;
		
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			
			while(result.next()){
				
				t.setNome(result.getString("nome"));
				t.setCognome(result.getString("cognome"));
				t.setMatricola(result.getString("matricola"));
				t.setUsername(result.getString("username"));
				t.setPassword(result.getString("password"));
				t.setDomanda(result.getString("domanda"));
				
				tutor.add(t);
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

		return tutor;
	}

	@Override
	public synchronized boolean doUpdate(TutorBean tutor) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String querySQL = "UPDATE " + TutorAccademicoDAO.TABLE_NAME + " SET nome = ?, cognome = ?, matricola = ?, username = ?, password = ?, domanda = ?";
		
		try{
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);
			
			preparedStatement.setString(1, tutor.getNome());
			preparedStatement.setString(2, tutor.getCognome());
			preparedStatement.setString(3, tutor.getMatricola());
			preparedStatement.setString(4, tutor.getUsername());
			preparedStatement.setString(5, tutor.getPassword());
			preparedStatement.setString(6, tutor.getDomanda());
			
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
	public synchronized boolean doDelete(TutorBean tutor) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String querySQL = "DELETE FROM " + TutorAccademicoDAO.TABLE_NAME + " WHERE matricola = ?";
		
		try{
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);
			
			preparedStatement.setString(1, tutor.getMatricola());
			
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
