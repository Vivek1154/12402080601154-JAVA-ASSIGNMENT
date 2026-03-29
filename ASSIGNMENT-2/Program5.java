import java.io.*;
import java.util.*;

public class Program5 {
    public static void main(String[] args) {

        HashMap<String, Integer> wordCount = new HashMap<>();

        try {
            File file = new File("input.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                String word = sc.next().toLowerCase();

                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }

            sc.close();

            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
