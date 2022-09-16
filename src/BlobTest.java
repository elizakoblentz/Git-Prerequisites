import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;

import org.junit.Test;

public class BlobTest {

	

	@Test
	public void testBlob() {
		File testFile=new File("tester.txt");
		PrintWriter pw;
		try {
			pw = new PrintWriter("tester.txt");
			pw.append("this is a test");
			pw.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		try {
			Blob bob = new Blob("tester.txt");
			bob.getHashed();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
		
		
		
		
		
		
		fail("Not yet implemented");

}
}
