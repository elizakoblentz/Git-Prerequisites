
import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.time.LocalDateTime;

public class Commit {

	private static String pTree;
	private static String parent;
	private static String other;
	private static String summary;
	private static String author;
	private static String date;
	private static String fileName;
	
	public Commit(String pointer, String s, String a, String p) throws FileNotFoundException {
		pTree = pointer;
		summary = s;
		author = a;
		date = "" + LocalDateTime.now();
		if (p != null)
			parent = p;
		else
			parent = null;
		other = null;
		
		fileName = getSHA1();
		
		if (parent != null) {
			Scanner input = new Scanner(new File("test/objects/" + parent));
			String contents = "";
			contents += input.nextLine() + "\n";
			contents += input.nextLine() + "\n";
			contents += fileName + "\n";
			input.nextLine();
			contents += input.nextLine() + "\n";
			contents += input.nextLine() + "\n";
			contents += input.nextLine() + "\n";
			
			PrintWriter pw = new PrintWriter("test/objects/" + parent);
			pw.append(contents);
			pw.close();
		}
	}
	
	private String getSHA1(){
		String value = "" + summary + date + author + parent;
		String output = "";

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			digest.update(value.getBytes("utf8"));
			output = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception exception){
			exception.printStackTrace();
		}

		return output; 
	}
	
	public static String getDate() {
		return date;
	}
	
	public void writeFile() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter("test/objects/" + new File(fileName));
		pw.append(pTree + "\n");
		if (parent != null)
			pw.append(parent + "\n");
		pw.append(other + "\n");
		pw.append(author + "\n");
		pw.append(date + "\n");
		pw.append(summary + "\n");
		pw.close();
	}

}
