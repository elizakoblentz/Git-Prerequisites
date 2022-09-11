
//package git;
import java.util.*;
import java.io.*;

public class Index {
	
	private HashMap<String, String> map = new HashMap<String, String>();
	
	public static void main (String[]args) throws IOException{
		Index inx = new Index();
		inx.init();
		inx.add("foo.txt");
		inx.add("bar.txt");
		inx.add("foobar.txt");
//		inx.remove("foo.txt");
	}
	
	public Index() {
		
	}
	
	public void init() throws FileNotFoundException {
		File f1 = new File("test/index.txt");
		PrintWriter pw = new PrintWriter(f1);
		pw.append("");
		pw.close();
		File f2 = new File("test/objects");
		f2.mkdir();
	}
	
	public void add(String fileName) throws IOException {
		File f = new File("test/" + fileName);
		if (f.exists()) {
			Blob bob = new Blob("test/" + fileName);
			map.put(fileName, bob.getHashed());
			PrintWriter pw = new PrintWriter("test/index.txt");
			for (String s : map.keySet())
				pw.append(s + ": " + map.get(s) + "\n");
			pw.close();
		}
	}
	
	public void remove(String fileName) throws IOException {
		File f = new File("test/objects/" + map.get(fileName) + ".txt");
		f.delete();
		map.remove(fileName);
		PrintWriter pw = new PrintWriter("test/index.txt");
		for (String s: map.keySet())
			pw.append(s + ": " + map.get(s) + "\n");
		pw.close();
	}
}
