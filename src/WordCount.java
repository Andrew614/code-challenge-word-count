import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		try {
			File importFile = new File("Paragraph.txt");
			Scanner file = new Scanner(importFile);
			
			while (file.hasNext()) {
				String word = file.next();
				System.out.println(word);
			}
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file does not exist");
			e.printStackTrace();
		}
	}

}
