import static org.junit.Assert.*;

import java.util.ArrayList;

import org.fogbeam.example.opennlp.TokenizerMain;
import org.junit.Test;

public class TokenizerTest {

	@Test
	public void testTokenize() {
		String file = "inputs/file2.txt";
		int expected = 9;
		ArrayList<String> result = TokenizerMain.tokenize(file);
		assertEquals(expected, result.size());
	}

}
