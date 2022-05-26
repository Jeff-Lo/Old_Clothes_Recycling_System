import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	//mysql
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3307/finalproject?serverTimezone=UTC& characterEncoding=utf-8 & user=alpha & password=29055385";
	
	//userid&password
	static final String USER = "alpha";
	static final String PASS = "29055385";
	
	//query of SQL
	private String query;
	
	//connect to MySQL
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}
	
	//use SQL language and return result in an array
	public String[] doSQL(String SQLcode) throws SQLException {
		Connection conn = null;
		try {
			conn = getConnection();
			Statement stat = conn.createStatement();
			query = SQLcode;
			boolean hasResultSet = stat.execute(query);
			if (hasResultSet) {
				ResultSet result = stat.getResultSet();			
				ResultSetMetaData metaData = result.getMetaData();
				String[] info = new String[metaData.getColumnCount() - 1];
				String getResult = "";
				int x = metaData.getColumnCount();
				int j = 1;
				while (result.next()) {
					for (int i = 1; i <= x; i++) {
						if (i > 1 || j > 1) {
							getResult += ",";
						}
						getResult += result.getString(i);
					}
					j++;
				}		
				info = getResult.split(",");
				return info;
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			conn.close();
		}
		return null;
	}

}	