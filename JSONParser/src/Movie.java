
public class Movie {
	
	public String title;
	public String author;
	public int first_aired;
	public boolean avaible;
	public int[] parts;
	public String[] part_names;
	
	public Movie(String title, String author, int first_aired, boolean avaible, int[] parts, String[] part_names) {
		super();
		this.title = title;
		this.author = author;
		this.first_aired = first_aired;
		this.avaible = avaible;
		this.parts = parts;
		this.part_names = part_names;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getFirst_aired() {
		return first_aired;
	}
	public void setFirst_aired(int first_aired) {
		this.first_aired = first_aired;
	}
	public boolean isAvaible() {
		return avaible;
	}
	public void setAvaible(boolean avaible) {
		this.avaible = avaible;
	}
	public int[] getParts() {
		return parts;
	}
	public void setParts(int[] parts) {
		this.parts = parts;
	}
	public String[] getPart_names() {
		return part_names;
	}
	public void setPart_names(String[] part_names) {
		this.part_names = part_names;
	}

}
