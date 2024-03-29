import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Picnic {
    public static void main(String[] args) {
        String fileName = "input.txt" ;
        String[] fruits = readFruits(fileName);

        int totalFruits = countFruits(fruits);
        String longestWord = LongestWord(fruits);
        Map<String, Integer> wordFrequencyMap = Frequency(fruits);

        System.out.println("Общее количество фруктов и овощей: " + totalFruits);
        System.out.println("Самое длинное слово: " + longestWord);
        System.out.println("Частота слов в файле:");
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String[] readFruits(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString().split("\\s+");
    }

    private static int countFruits(String[] fruits) {
        int fruitCount = 0;
        for (String item : fruits) {
            if (item.length() >= 2) {
                fruitCount++;
            }
        }
        return fruitCount;
    }

    private static String LongestWord(String[] words) {
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    private static Map<String, Integer> Frequency(String[] words) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }
        return wordFrequencyMap;
    }
}
