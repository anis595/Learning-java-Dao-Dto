package toto;

public class Article {
	
	@Override
	public String toString() {
		return "Article [Id=" + Id + ", libelle=" + libelle + ", prix=" + prix + "]";
	}

	private int Id;
	private String libelle;
	public void setId(int id) {
		Id = id;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	private double prix;
	
	public Article(int id, String libelle, double prix) {
		super();
		Id = id;
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
