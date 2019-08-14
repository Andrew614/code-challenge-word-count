import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordCount {

	public static void main(String[] args) {
		try {
			Map<String, Integer> wordCountData = new HashMap<String, Integer>();
			File importFile = new File("Paragraph.txt");
			Scanner file = new Scanner(importFile);
			countWords(file, wordCountData);
			
			System.out.println(wordCountData);
			file.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("The file does not exist");
			e.printStackTrace();
		}
	}

	
	private static void countWords(Scanner file, Map<String, Integer> wordCountData) {
		List<String> wordsList = new ArrayList<String>();
		Set<String> noRepeatList = new HashSet<String>();
		while (file.hasNext()) {
			String word = file.next();
			wordsList.add(word);
			noRepeatList.add(word);
		}
		for (String noRepeatListWord : noRepeatList) {
			int wordCount = 0;
			for (String wordsListWord : wordsList) {
				if (noRepeatListWord.equals(wordsListWord)) {
					wordCount++;
				}
			}
			wordCountData.put(noRepeatListWord, wordCount);
		}
	}

}