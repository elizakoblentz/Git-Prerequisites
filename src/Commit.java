
import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;

public class Commit {

	private static String pTree;
	private static String parent;
	private static String other;
	private static String summary;
	private static String author;
	private static String date;
	
	public Commit(String pointer, String s, String a) {
		pTree = pointer;
		parent = null;
		other = null;
		summary = s;
		author = a;
		date = getDate();
	}
	
	private String getSHA1 (String s1){
		String value = s1;
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
	
	public void writeFile() {
		
	}
}
