
//package git;
import java.util.*;
import java.io.*;

public class Index {
	
	private HashMap<String, String> map = new HashMap<String, String>();
	
	public Index() {
		
	}
	
	public void init() throws IOException {
		File f1 = new File("test/index.txt");
		PrintWriter pw = new PrintWriter(f1);
		pw.append("");
		pw.close();
		File f2 = new File("test/objects");
		f2.mkdir();
	}
	
	
}
