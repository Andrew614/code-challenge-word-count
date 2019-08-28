import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class WordCount {

	public static void main(String[] args) {
		try {
			File importFile = new File("Paragraph.txt");
			Scanner file = new Scanner(importFile);

			Map<String, Integer> wordCountData = new HashMap<String, Integer>();
			countWords(file, wordCountData);
			Map<String, Integer> result = sortByValue(wordCountData);

			System.out.println(result);
			file.close();

		} catch (FileNotFoundException e) {
			System.out.println("The file does not exist");
			e.printStackTrace();
		}
	}

	// counts each word occurrence and put it into a HashMap
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

	// sorts HashMap by values
	private static <key, value extends Comparable<? super value>> Map<key, value> sortByValue(
			Map<key, value> wordCountData) {
		List<Entry<key, value>> list = new ArrayList<>(wordCountData.entrySet());
		list.sort(Entry.comparingByValue(Comparator.reverseOrder()));

		Map<key, value> result = new LinkedHashMap<>();
		for (Entry<key, value> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}

		return result;
	}

}