import java.lang.reflect.*;

public class toJSON {
	
	public static String toJson(Object o) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		String json = "";
		
		Field[] fields = o.getClass().getDeclaredFields();
		//classname
		json += "{\n\t\"" + o.getClass().getName() + "\": {\n\t\t";
		//fields
		for (Field field : fields) {
			//check if array
			if(field.getType().isArray()){
				json += "\"" + field.getName() + "\":";
				Class cType = field.getType().getComponentType();
			    Object array = field.get(o);
				int length = Array.getLength(array);
			    for (int i = 0; i < length; i ++) {
			        Object arrayElement = Array.get(array, i);
			        json += "\n\t\t\t\"" + arrayElement + "\"";
			    }
				if(field != fields[fields.length-1]) {
					json += ",\n\t\t";
				}
			}
			//non array
			else {
				json += "\"" + field.getName() + "\": \"" + field.get(o) + "\"";
				if(field != fields[fields.length-1]) {
					json += ",\n\t\t";
				}
			}
		}
		json += "\n\t}\n}";
		return json;
		
	}
}
