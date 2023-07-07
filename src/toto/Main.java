package toto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;



public class Main {

	public static void main(String[] args) {

		Connection conn = null;
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://localhost/snackmounir?" +
		                                   "user=root&password=");
		    Statement stmt = conn.createStatement();
		    String sql = "SELECT * FROM article";
		    ResultSet res = stmt.executeQuery(sql);
		    while(res.next()) {
                int id = res.getInt("id");
                String libelé = res.getString("libelé");
                int prix = res.getInt("prix");
                
                System.out.printf("%d\t%s\t\t%d\n", 
                        id,
                        libelé,
                        prix);
                        
        }
		   

		    // Do something with the Connection

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

}
