
//package git;
import java.util.*;
import java.io.*;

public class Index {
	
	private HashMap<String, String> map = new HashMap<String, String>();
	
	public Index() {
		
	}
	
	public void init() throws IOException {
//		 Path p = Paths.get("test.txt");
//	     try {
//	    	 Files.writeString(p, "example", StandardCharsets.ISO_8859_1);
//	     } 
//	     catch (IOException e) {
//	    	 e.printStackTrace();
//	     }
		
		File f1 = new File("test/index.txt");
		PrintWriter pw = new PrintWriter(f1);
		pw.append("");
		pw.close();
		File f2 = new File("test/objects");
		f2.mkdir();
	}
	
	
}
