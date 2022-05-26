import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;

public class UserInfo {
	private int users_id;
	private String users_name;
	private String users_account;
	private String users_passwords;
	private String users_phone_number;
	private int users_identity;
	
	//connect database(INSERT INTO)
	public UserInfo (String name,String accountNum,String password,String phonenumber) throws SQLException {
		this.users_id=0;
		this.users_name=name;
		this.users_account=accountNum;
		this.users_passwords=password;
		this.users_phone_number=phonenumber;
		this.users_identity=0;
			
		boolean exist=false;
		Connection conn = Database.getConnection();
		try {
			Statement stat1=conn.createStatement();
			ResultSet result=stat1.executeQuery("SELECT users_id,users_account,users_passwords,users_identity FROM finalproject.users");
			while(result.next()) {
				if(result.getString("users_account").equals(users_account) && result.getString("users_passwords").equals(users_passwords)) {
					users_id = result.getInt("users_id");
					users_identity = result.getInt("users_identity");
					exist=true;
				}
			}
				
			if(!exist) {
				Database database = new Database();
				String[] a = database.doSQL("SELLECT MAX(users_id) FROM finalproject.users");
				users_id = Integer.parseInt(a[0]) + 1;
					
				PreparedStatement stat = conn.prepareStatement("INSERT INTO finalproject.users VALUES(?,?,?,?,?,?,?)");
				stat.setInt(1,users_id);
				stat.setString(2,users_name);
				stat.setString(3,users_account);
				stat.setString(4,users_passwords);
				stat.setString(5,users_phone_number);
				stat.setInt(6,users_identity);
				stat.execute();
			}
		}
		finally {
			   conn.close();
		}
	}
	
	public String getName() {
		return users_name;
	}
	
	public int getID() {
		return users_id;
	}
	
	public String getAccount() {
		return users_account;
	}
	
	public String getPassword() {
		return users_passwords;
	}
	
}
