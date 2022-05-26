import java.sql.SQLException;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws SQLException {
		Login login = new Login();
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setVisible(true);
	}

}