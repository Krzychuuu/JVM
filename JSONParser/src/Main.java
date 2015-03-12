import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class Main {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, FileNotFoundException, UnsupportedEncodingException {
		int[] tmpParts = {1,2,3};
		String[] tmpPartNames = {"Fellowship of the Ring", "Two Towers", "Return of the King"};
		Movie tempMovie = new Movie("Lord of the Rings", "Tolkien", 2002, true, tmpParts, tmpPartNames);
		System.out.println(toJSON.toJson(tempMovie));
		//do pliku txt
		PrintWriter writer = new PrintWriter(tempMovie.getClass().getName()+".txt", "UTF-8");
		writer.println(toJSON.toJson(tempMovie));
		writer.close();
	}

}
