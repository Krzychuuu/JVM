package serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;


public class Login implements Externalizable{

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return username + " " + password;
		
	}
	
	private String username;
	private transient String password;
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(getPassword());
		out.writeObject(getUsername());
		
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		this.setPassword((String) (in.readObject()));
		this.setUsername((String) (in.readObject()));
		
	}
	
	
}