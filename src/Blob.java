
import java.util.*;
import java.io.*;
import java.math.*;
import java.security.*;

public class Blob {

	private String hashed;
	private String contents;
	
	public static void main (String[]args) throws IOException{
		Blob bob = new Blob("something.txt");
	}
	
	public Blob(String fileName) throws IOException {
		String output = "";
		
		try {
			File f = new File(fileName);
			Scanner input = new Scanner(f);
			while (input.hasNextLine())
				output += input.nextLine();
			input.close();
		}
		catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		
		contents = output;
		hashed = getSHA1(contents);
		createFile();
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
	
	public void createFile() throws IOException {
		File f = new File("test/objects/" + hashed + ".txt");
		PrintWriter pw = new PrintWriter(f);
		pw.append(contents);
		pw.close();
	}
}
