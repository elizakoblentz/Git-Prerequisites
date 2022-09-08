
import java.util.*;
import java.io.*;
import java.math.*;
import java.security.*;

public class Blob {

	private String hashed;
	private String contents;
	
	public Blob(String fileName) throws IOException {
		Blob b = new Blob("something.txt");
	}
	
	private String getSHA1 (String s1){
		String value = s1;
		String output = "";

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			digest.update(s1.getBytes("utf8"));
			output = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception exception){

			exception.printStackTrace();
		}

		return output; 
	}
	
}
