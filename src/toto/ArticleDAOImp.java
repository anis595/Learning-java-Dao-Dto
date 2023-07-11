package toto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ArticleDAOImp implements IArticleDAO {
static Connection conn = null;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dbName = "snackmounir"; 
			String dbUserName = "root"; 
			String dbPassword = ""; 
			String connectionString = "jdbc:mysql://localhost:3306/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword ;
			conn = DriverManager.getConnection(connectionString);
			
			
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
@Override
public void addArticle(Article unArticle) {
	PreparedStatement stmtAddArticle;
	try {
		stmtAddArticle = conn.prepareStatement("INSERT INTO article (libelle, prix) VALUES (?,?)");
		stmtAddArticle.setString(1, unArticle.getLibelle());
		stmtAddArticle.setDouble(2, unArticle.getPrix());
		int nbInserted =  stmtAddArticle.executeUpdate();
		System.out.println(nbInserted);
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
	

@Override
public void deleteArticle(int Id) {
	PreparedStatement stmtDeleteArticle;
	try {
		stmtDeleteArticle = conn.prepareStatement("DELETE FROM article WHERE id = ?");
		stmtDeleteArticle.setInt(1, Id);
		int nbInserted =  stmtDeleteArticle.executeUpdate();
		System.out.println(nbInserted);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
}
@Override
public void editArticle(Article unArticle) {
	PreparedStatement stmtEditArticle;
	try {
		stmtEditArticle = conn.prepareStatement("UPDATE article SET libelle = ?, prix = ? WHERE id = ? ");
		stmtEditArticle.setString(1, unArticle.getLibelle());
		stmtEditArticle.setDouble(2, unArticle.getPrix());
		stmtEditArticle.setInt(3, unArticle.getId());
		int nbInserted =  stmtEditArticle.executeUpdate();
		System.out.println(nbInserted);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
@Override
public Article getArticle(int Id) {
	PreparedStatement stmtArticle;
	Article newArticle = null;
	try {
		stmtArticle = conn.prepareStatement("SELECT * FROM article WHERE id= ?");
		stmtArticle.setInt(1, Id);
		ResultSet res = stmtArticle.executeQuery();
		if(res.next()) {
			newArticle = new Article(res.getInt("id"), res.getString("libelle"), res.getDouble("prix"));
		}
   
		
	} catch (SQLException e) {
		e.printStackTrace();
	}		
	return newArticle;
	
}
@Override
public List<Article> getAllArticle() {
	List<Article> mesArticles = new ArrayList<Article>();
	PreparedStatement stmtArticle;
	try {
		stmtArticle = conn.prepareStatement("SELECT * FROM articles");
		
		ResultSet res = stmtArticle.executeQuery();	
		while(res.next()) {
    	   	mesArticles.add(new Article(res.getInt("id"),res.getString("libelle") ,res.getInt("prix") ));				
    	   	}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return mesArticles;
	
}}
