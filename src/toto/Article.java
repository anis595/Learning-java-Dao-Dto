package toto;

public class Article {
	
	@Override
	public String toString() {
		return "Article [Id=" + Id + ", libelle=" + libelle + ", prix=" + prix + "]";
	}

	private int Id;
	private String libelle;
	private double prix;
	
	public Article( int Id, String libelle, double prix) {
		this.Id = Id;
		this.libelle = libelle;
		this.prix = prix;
	}

	    public int getId() {
	        return Id;
	    }

	    public String getLibelle() {
	        return libelle;
	    }

	    public double getPrix() {
	        return prix;
	    }
	    
	    
	    
	

}
