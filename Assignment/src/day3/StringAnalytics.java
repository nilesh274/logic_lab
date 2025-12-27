package day3;
import java.util.Scanner;

public class StringAnalytics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";

        do {
            System.out.println("Enter text to analyze:");
            input = sc.nextLine();
        } while (input.isEmpty());

        analyzeText(input);

        sc.close();
    }

    public static void analyzeText(String s) {
        int sentenceCount = 0;
        int digitCount = 0;
        int letterCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.' || c == '!' || c == '?') {
                sentenceCount++;
            }
            if (Character.isDigit(c)) {
                digitCount++;
            } else if (Character.isLetter(c)) {
                letterCount++;
            }
        }

        String[] rawWords = s.trim().split("\\s+");
        int wordCount = (s.trim().isEmpty()) ? 0 : rawWords.length;

        String longestWord = "";

        for (String word : rawWords) {
            StringBuilder clean = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (Character.isLetterOrDigit(ch)) {
                    clean.append(ch);
                }
            }
            String current = clean.toString();
            if (current.length() > longestWord.length()) {
                longestWord = current;
            }
        }

        int[] vowels = countVowels(s);

        System.out.println("Words: " + wordCount);
        System.out.println("Sentences: " + sentenceCount);
        System.out.println("Digits: " + digitCount + ", Letters: " + letterCount);
        System.out.println("Longest word: \"" + longestWord + "\"");
        
        char[] vRef = {'a', 'e', 'i', 'o', 'u'};
        System.out.print("Vowel freq: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(vRef[i] + "=" + vowels[i] + (i < 4 ? " " : ""));
        }
        System.out.println();
    }

    public static int[] countVowels(String s) {
        int[] counts = new int[5];
        String lower = s.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (c == 'a') counts[0]++;
            else if (c == 'e') counts[1]++;
            else if (c == 'i') counts[2]++;
            else if (c == 'o') counts[3]++;
            else if (c == 'u') counts[4]++;
        }
        return counts;
    }
}