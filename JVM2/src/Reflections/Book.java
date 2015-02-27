package Reflections;

public class Book {

	public String title;
	public String author;
	public int YearOfPublishing;
	public Integer Amount;
	
	public Book(String title, String author, int yearOfPublishing,
			Integer amount) {
		super();
		this.title = title;
		this.author = author;
		YearOfPublishing = yearOfPublishing;
		Amount = amount;
	}
	
	public Book() {
		
	}

	public void ChangeYOP(int new_yop)
	{
		this.YearOfPublishing = new_yop; 
	}
}
