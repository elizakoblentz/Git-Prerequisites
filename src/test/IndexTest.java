package test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import Git.Index;
import Git.Blob;
public class IndexTest {

	

	@Test
	public void testIndex() {
		Index i=new Index();
		
		fail("Not yet implemented");
	}

	@Test
	public void testInit() {
		Index i=new Index();
		try {
			i.init();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Path path= Paths.get("test/objects/");
		Files.exists(path);
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() throws FileNotFoundException {
		
		Index i=new Index();
		i.init();
		try {
			i.add("bla.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			i.add("foo.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			i.add("bar.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() throws FileNotFoundException {
		
		Index i=new Index();
		i.init();
		
		
		try {
			i.remove("bla.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			i.add("bar.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			i.add("foo.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			i.remove("bar.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		fail("Not yet implemented");
	}
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

}
}
