package serializable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Student extends Person implements Serializable {

	public String getStudentBookId() {
		return studentBookId;
	}
	public void setStudentBookId(String studentBookId) {
		this.studentBookId = studentBookId;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	private String studentBookId;
	private Login login;
	
	private void writeObject(ObjectOutputStream os) {
		try {
			os.defaultWriteObject();
			os.writeObject(getFirstName());
			os.writeObject(getLastName());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void readObject(ObjectInputStream is) {
		try {
			is.defaultReadObject();
			String firstName = (String) is.readObject();
			String lastName = (String) is.readObject();
			setFirstName(firstName);
			setLastName(lastName);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}