package serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class Main {
	
	String FILE_NAME = "serialized.object";
		
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Main main = new Main();
		
		Login login1 = new Login();
		login1.setUsername("User1");
		login1.setPassword("Pwd1");
		
		Login login2 = new Login();
		login2.setUsername("User2");
		login2.setPassword("Pwd2");

		Student student1 = new Student();
		student1.setFirstName("Student1");
		student1.setLastName("Student11");
		student1.setStudentBookId("Id1");
		student1.setLogin(login1);
		
		Student student2 = new Student();
		student2.setFirstName("Student2");
		student2.setLastName("Student22");
		student2.setStudentBookId("Id2");
		student2.setLogin(login2);
		
		List<Student> attendeesList = new ArrayList<>();
		attendeesList.add(student1);
		attendeesList.add(student2);
		Classes classes1 = new Classes();
		classes1.setAttemdeesList(attendeesList);
		
		main.serializeObject(classes1);
		
		Classes classes2 = (Classes) main.deserializeObject();
		System.out.println(classes2.toString());

	}
	
	public void serializeObject(Object object) throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
		out.writeObject(object);
		out.close();
	}
	
	public Object deserializeObject() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
		Object result = in.readObject();
		in.close();
		return result;
	}

}