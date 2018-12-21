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

import Bean.ImpiegatoBean;

public class ImpiegatoDAO implements AbstractDAO<ImpiegatoBean>{
	
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
	
	private static final String TABLE_NAME = "Impiegato";

	@Override
	public synchronized int doSave(ImpiegatoBean impiegato) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		String querySQL = "INSERT INTO " + ImpiegatoDAO.TABLE_NAME + " (nome, cognome, matricola, username, password, domanda)" +
				"VALUES (?, ?, ?, ?, ?, ?)";
		try{
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, impiegato.getNome());
			preparedStatement.setString(2, impiegato.getCognome());
			preparedStatement.setString(3, impiegato.getMatricola());
			preparedStatement.setString(4, impiegato.getUsername());
			preparedStatement.setString(5, impiegato.getPassword());
			preparedStatement.setString(6, impiegato.getDomanda());
			
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
	public synchronized ImpiegatoBean doRetrieveByKey(ImpiegatoBean impiegato) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		ImpiegatoBean i = new ImpiegatoBean();
		
		String querySQL = "SELECT * FROM " + ImpiegatoDAO.TABLE_NAME + " WHERE matricola = ?";
		
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

			preparedStatement.setString(1, impiegato.getMatricola());

			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			
			while(result.next()){
				
				i.setNome(result.getString("nome"));
				i.setCognome(result.getString("cognome"));
				i.setMatricola(result.getString("matricola"));
				i.setUsername(result.getString("username"));
				i.setPassword(result.getString("password"));
				i.setDomanda(result.getString("domanda"));
				
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

		return i;
	}

	@Override
	public synchronized List<ImpiegatoBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		List<ImpiegatoBean> impiegati = new ArrayList<ImpiegatoBean>();
		ImpiegatoBean i = new ImpiegatoBean();
		
		String querySQL = "SELECT * FROM " + ImpiegatoDAO.TABLE_NAME;
		
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			
			while(result.next()){
				
				i.setNome(result.getString("nome"));
				i.setCognome(result.getString("cognome"));
				i.setMatricola(result.getString("matricola"));
				i.setUsername(result.getString("username"));
				i.setPassword(result.getString("password"));
				i.setDomanda(result.getString("domanda"));
				
				impiegati.add(i);
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

		return impiegati;
	}

	@Override
	public synchronized boolean doUpdate(ImpiegatoBean impiegato) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String querySQL = "UPDATE " + ImpiegatoDAO.TABLE_NAME + " SET nome = ?, cognome = ?, matricola = ?, username = ?, password = ?, domanda = ?";
		
		try{
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);
			
			preparedStatement.setString(1, impiegato.getNome());
			preparedStatement.setString(2, impiegato.getCognome());
			preparedStatement.setString(3, impiegato.getMatricola());
			preparedStatement.setString(4, impiegato.getUsername());
			preparedStatement.setString(5, impiegato.getPassword());
			preparedStatement.setString(6, impiegato.getDomanda());
			
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
	public synchronized boolean doDelete(ImpiegatoBean impiegato) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String querySQL = "DELETE FROM " + ImpiegatoDAO.TABLE_NAME + " WHERE matricola = ?";
		
		try{
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);
			
			preparedStatement.setString(1, impiegato.getMatricola());
			
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
