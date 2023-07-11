package toto;



public class Main {

	public static void main(String[] args) {
		ArticleDAOImp impl = new ArticleDAOImp();
		Article salade = new Article(6, "salade", 5);
		impl.addArticle(salade);
		impl.deleteArticle(10);
		impl.editArticle( new Article (15, "saloon",6));
		impl.getArticle(0);
		impl.getAllArticle();
		Service monService = new Service(new ArticleDAOImp()); 
		
		
		monService.remiseArticle(impl.getAllArticle(), 2);
		
	}
}
