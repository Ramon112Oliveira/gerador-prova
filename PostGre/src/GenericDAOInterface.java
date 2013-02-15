import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;

public interface GenericDAOInterface<T, PK> {

   public void setConnection(Connection conn);

   public void createTable() throws SQLException;

   public void dropTable() throws SQLException;

   public void create(T newInstance) throws SQLException;

   public T find(PK id) throws SQLException;

   public List<T> findAll() throws SQLException;

   public void update(T transientObject) throws SQLException;

   public void delete(PK id) throws SQLException;
}