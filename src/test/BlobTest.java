package test;

import static org.junit.jupiter.api.Assertions.*;
import Git.Blob;
import Git.Commit;
import Git.Index;
import Git.Tree;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BlobTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		Path p = Paths.get("test.txt");
        try {
            Files.writeString(p, "content of file", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception 
	{
		File f = new File ("test.txt");
		f.delete();
	}

	@Test
	void test() throws IOException {
		Blob b = new Blob ("test.txt");
		File file2  = new File ("objects/fd288b3ad773918453bdd49a5e59bffd435c5ce1");
		assertTrue (file2.exists());
	}

}
