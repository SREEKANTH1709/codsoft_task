import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText="";

        System.out.println("Enter 1 or 2 to specify your choice for input:\n1: Data from file\n2: Input String");
        int ch=scanner.nextInt();
        if(ch==1){

            System.out.print("Enter the path to the file: ");
            scanner.nextLine();
            String filePath = scanner.nextLine();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                StringBuilder content = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }

                inputText = content.toString();
                System.out.println("File content:\n" + inputText);

            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
        }
        else if(ch==2){
            System.out.println("Enter a text:");
            scanner.nextLine();
            inputText = scanner.nextLine().trim();

            if (inputText.isEmpty()) 
                System.out.println("Input text is empty!");
        }
        else{
            System.out.println("Invalid choice!");
            System.exit(1);
        }

        String[] words = inputText.split("[\\s\\p{Punct}]+");
        int totalWords = words.length;

        System.out.println("Total words: " + totalWords);

        String[] stopWords = {"the", "and", "is", "of", "in", "to", "a"}; // Example list
        int nonStopWordCount = 0;
        for (String word : words) {
        if (!isStopWord(word, stopWords)) {
            nonStopWordCount++;
            }
        }
        System.out.println("Total non-stop words: " + nonStopWordCount);
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word frequency statistics:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        scanner.close();
    }
    private static boolean isStopWord(String word, String[] stopWords) {
        for (String stopWord : stopWords) {
            if (word.equalsIgnoreCase(stopWord)) {
                return true;
            }
        }
        return false;
    }
}
