package DreamDress.DreamDress.dto;

public class LocationTraditionnelDto {
private Long id;
	
	private String nom;
	private String description;
	
	private String image;
	private Integer prix;
	private Long taille;

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getPrix() {
		return prix;
	}
	public void setPrix(Integer prix) {
		this.prix = prix;
	}
	public Long getTaille() {
		return taille;
	}
	public void setTaille(Long taille) {
		this.taille = taille;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
