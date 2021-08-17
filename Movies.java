package Main;

public class Movies {

	private String Name, Author, Genre, Image, Description;
	private int ID, Duration, Rate;
	
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public int getDuration() {
		return Duration;
	}
	public void setDuration(int duration) {
		Duration = duration;
	}
	public int getRate() {
		return Rate;
	}
	public void setRate(int rate) {
		Rate = rate;
	}	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
	public Movies(String name, String author, String genre, String image, String description, int duration, int rate) {
		super();
		Name = name;
		Author = author;
		Genre = genre;
		Image = image;
		Description = description;
		Duration = duration;
		Rate = rate;
	}
	public Movies() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
