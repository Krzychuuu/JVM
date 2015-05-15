package serializable;

import java.io.Serializable;
import java.util.List;


public class Classes implements Serializable {

	private List<Student> attemdeesList;

	public List<Student> getAttemdeesList() {
		return attemdeesList;
	}

	public void setAttemdeesList(List<Student> attemdeesList) {
		this.attemdeesList = attemdeesList;
	}
	
	public String toString() {
		String s = "";
		for (Student student : attemdeesList) {
			s += "\n" + student.getFirstName() + " " + student.getLastName() + " " + student.getStudentBookId() + " " +
		student.getLogin().getUsername() + " " + student.getLogin().getPassword();
		}
		return s;
	}
	
	
}