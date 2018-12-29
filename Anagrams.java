import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * Scans a dictionary into a HashSet and then compares all possible 
 * substrings to the contents of the hashset.
 * 
 * Also gives an example of testing the time to run 
 * */
public class Anagrams {

    public static void main(String[] args) throws IOException {
        // load the dictionary into a set for fast lookups
        Set<String> dictionary = new HashSet<String>();
        Scanner filescan = new Scanner(new File("dictionary.txt"));
        while (filescan.hasNext()) {
            dictionary.add(filescan.nextLine().toLowerCase());
        }
        filescan.close();

        // scan for input
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scan.next().toLowerCase();
        System.out.println();
        scan.close();

        // store list of results, each result is a list of strings
        List<List<String>> results = new ArrayList<List<String>>();

        long time = System.currentTimeMillis();

        // start the search, pass empty stack to represent words found so far
        search(input, dictionary, new Stack<String>(), results);

        time = System.currentTimeMillis() - time;

        // list the results found
        for (List<String> result : results) {
            for (String word : result) {
                System.out.print(word + " ");
            }
            System.out.println("(" + result.size() + " words)");
        }
        System.out.println();
        System.out.println("Took " + time + "ms");
    }

    public static void search(String input, Set<String> dictionary,
            Stack<String> words, List<List<String>> results) {

        for (int i = 0; i < input.length(); i++) {
            // take the first i characters of the input and see if it is a word
            String substring = input.substring(0, i + 1);

            if (dictionary.contains(substring)) {
                words.push(substring);
                if (i == input.length() - 1) {
                    results.add(new ArrayList<String>(words));
                } else {
                    search(input.substring(i + 1), dictionary, words, results);
                }
                words.pop();
            }
        }
    }

}
