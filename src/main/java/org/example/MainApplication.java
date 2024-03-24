package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        Map<String, Integer> englishWordCount = new HashMap<>();
        Map<String, Integer> nonEnglishWordCount = new HashMap<>();

        try {
            File file = new File("src/main/java/org/example/input.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                if (isEnglishWord(word)) {
                    englishWordCount.put(word, englishWordCount.getOrDefault(word, 0) + 1);
                } else {
                    nonEnglishWordCount.put(word, nonEnglishWordCount.getOrDefault(word, 0) + 1);
                }
            }

            scanner.close();

            System.out.println("English Words:");
            for (Map.Entry<String, Integer> entry : englishWordCount.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            System.out.println("\nNon-English Words:");
            for (Map.Entry<String, Integer> entry : nonEnglishWordCount.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    private static boolean isEnglishWord(String word) {
        return word.matches("[a-zA-Z]+");
    }
}
