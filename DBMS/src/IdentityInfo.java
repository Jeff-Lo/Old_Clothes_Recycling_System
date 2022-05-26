import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;

public class IdentityInfo {
	private int apply_id;
	private String users_name;
	private String users_account;
	private String users_passwords;
	private String users_phone_number;
	private String users_check_number;
	private int check_identity;
	private String checker;

	
	//connect database(INSERT INTO)
	public IdentityInfo (String name,String accountNum,String password,String phonenumber,String checkNum,int identity) throws SQLException {
		this.apply_id=0;
		this.users_name=name;
		this.users_account=accountNum;
		this.users_passwords=password;
		this.users_phone_number=phonenumber;
		this.users_check_number=checkNum;
		this.check_identity=identity;
		this.checker="U";
			
		boolean exist=false;
		boolean hasApplied = false;
		Connection conn = Database.getConnection();
		try {
			Statement stat1=conn.createStatement();
			ResultSet result=stat1.executeQuery("SELECT users_account FROM finalproject.users");
			while(result.next()) {
				if(result.getString("users_account").equals(users_account)) {
					exist=true;
				}
			}
			Statement stat2=conn.createStatement();
			ResultSet result2=stat2.executeQuery("SELECT users_account FROM finalproject.special_identity");
			while(result2.next()) {
				if(result2.getString("users_account").equals(users_account)) {
					hasApplied=true;
				}
			}
			
				
			if(exist && hasApplied) {
				Database database = new Database();
				String[] a = database.doSQL("SELECT MAX(apply_id) FROM finalproject.users");
				//apply_id = Integer.parseInt(a[0]) + 1;
					
				PreparedStatement stat = conn.prepareStatement("INSERT INTO finalproject.special_identity(users_name,users_account,users_passwords,users_phone_number,users_check_number,check_identity,checker) VALUES(?,?,?,?,?,?,?)");
				//stat.setInt(1,apply_id);
				stat.setString(2,users_name);
				stat.setString(3,users_account);
				stat.setString(4,users_passwords);
				stat.setString(5,users_phone_number);
				stat.setString(6,users_check_number);
				stat.setInt(7,check_identity);
				stat.setString(8,checker);
				stat.execute();
			}
		}
		finally {
			   conn.close();
		}
	}
	

	public String getUsers_name() {
		return users_name;
	}

	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}

	public String getUsers_account() {
		return users_account;
	}

	public void setUsers_account(String users_account) {
		this.users_account = users_account;
	}

	public String getUsers_passwords() {
		return users_passwords;
	}

	public void setUsers_passwords(String users_passwords) {
		this.users_passwords = users_passwords;
	}

	public String getUsers_phone_number() {
		return users_phone_number;
	}

	public void setUsers_phone_number(String users_phone_number) {
		this.users_phone_number = users_phone_number;
	}

	public String getUsers_check_number() {
		return users_check_number;
	}

	public void setUsers_check_number(String users_check_number) {
		this.users_check_number = users_check_number;
	}

	public int getCheck_identity() {
		return check_identity;
	}

	public void setCheck_identity(int check_identity) {
		this.check_identity = check_identity;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	
	
}
