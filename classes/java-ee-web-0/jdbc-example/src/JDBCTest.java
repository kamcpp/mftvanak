import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://10.10.42.18/testdb", "normaluser", "normal12345");
		Statement s = c.createStatement();
		String sqlQuery = "INSERT INTO `user` (`username`, `password`, `name`, `family`) VALUES ('asdsd', 'asdasd', 'name', 'family')";
		s.execute(sqlQuery);
		c.close();
		System.out.println("Done.");
	}
}
