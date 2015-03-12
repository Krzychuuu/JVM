
public class fromJSON {
//	String str = 
//	        "{"
//	            + "'title': 'Computing and Information systems',"
//	            + "'id' : 1,"
//	            + "'children' : 'true',"
//	            + "'groups' : [{"
//	                + "'title' : 'Level one CIS',"
//	                + "'id' : 2,"
//	                + "'children' : 'true',"
//	                + "'groups' : [{"
//	                    + "'title' : 'Intro To Computing and Internet',"
//	                    + "'id' : 3,"
//	                    + "'children': 'false',"
//	                    + "'groups':[]"
//	                + "}]" 
//	            + "}]"
//	        + "}";



	    fromJSON json = new fromJSON(str);
	    Iterator<String> iterator =  json.keys();

	    System.out.println("Fields:");
	    while (iterator.hasNext() ){
	       System.out.println(String.format("public String %s;", iterator.next()));
	    }

	    System.out.println("public void Parse (String str){");
	    System.out.println("JSONObject json = new JSONObject(str);");

	    iterator  = json.keys();
	    while (iterator.hasNext() ){
	       String key = iterator.next();
	       System.out.println(String.format("this.%s = json.getString(\"%s\");",key,key ));

	    System.out.println("}");
}
