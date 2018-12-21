package Model;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDAO <T> {

	public abstract int doSave(T entity) throws SQLException;

	public abstract T doRetrieveByKey(T entity) throws SQLException;
	
	public abstract List<T> doRetrieveAll() throws SQLException;

	public abstract boolean doUpdate(T entity) throws SQLException;

	public abstract boolean doDelete(T entity) throws SQLException;
}
