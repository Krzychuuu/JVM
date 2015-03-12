import java.io.*;

public class Main {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException {
		int[] tmpParts = {1,2,3};
		String[] tmpPartNames = {"Fellowship of the Ring", "Two Towers", "Return of the King"};
		Movie tempMovie = new Movie("Lord of the Rings", "Tolkien", 2002, true, tmpParts, tmpPartNames);
		System.out.println(toJSON.toJson(tempMovie));
		//do pliku txt
		
		PrintWriter writer = new PrintWriter(tempMovie.getClass().getName()+".txt", "UTF-8");
		writer.println(toJSON.toJson(tempMovie));
		writer.close();
		
		BufferedReader br = new BufferedReader(new FileReader(tempMovie.getClass().getName()+".txt"));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        String everything = sb.toString();
	        fromJSON.fromJson(everything);
	    } finally {
	        br.close();
	    }
	}

}
