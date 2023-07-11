package toto;

import java.util.List;

public class Service {
	
	private ArticleDAOImp impl;
	public Service(ArticleDAOImp impl) {
		this.impl= impl;
	}
	 public void remiseArticle(List<Article> lesArticles , double remise) {
		 for(Article unArticle : lesArticles) {
			 unArticle.setPrix(unArticle.getPrix() * remise);
			 impl.editArticle(unArticle);
		 }
		 
		 
	 }

}
