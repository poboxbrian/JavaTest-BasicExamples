import java.util.*;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.IntStream;

import java.util.Map;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


public class CountingDuplicates {
    private static int duplicateCount(String text) {
      int[] alpha = IntStream.iterate(0, n -> 0).limit(26).toArray();
      int[] digit = IntStream.iterate(0, n -> 0).limit(10).toArray();
      
      for(int i=0; i<text.length(); i++) {
        if (Character.isLetter(text.charAt(i))) {
          alpha[Character.toLowerCase(text.charAt(i)) - 'a']++;
        } else if (Character.isDigit(text.charAt(i))) {
          digit[text.charAt(i) - '0']++;
        }
      }
                         
      int iCount = 0;
      for (int a: alpha) {
        if (a > 1) iCount++;
      }
      for (int a: digit) {
        if (a > 1) iCount++;
      }
      return iCount;
    }

    private static int duplicateCount_manipulateString(String text) {
        int iCount = 0;
        text = text.toLowerCase();
        while (text.length() > 0) {
            String found = text.substring(0,1);
            text = text.substring(1);
            if (text.contains(found)) iCount++;
            text = text.replace(found, "");
        }
        return iCount;
    }

    private static int duplicateCount_mapping(String text) {
        return (int) charFrequenciesMap(text).values().stream()
            .filter(i -> i > 1)
            .count();
    }

    private static Map<Character, Long> charFrequenciesMap(final String text) {
        return text.codePoints()
            .map(Character::toLowerCase)
            .mapToObj(c -> (char) c)
            .collect(groupingBy(identity(), counting()));
    }

    public static void main(String args[]) {
        String s= "abcde";
        System.out.println(s+"-> "+duplicateCount(s));
        s= "abcdea";
        System.out.println(s+"-> "+duplicateCount(s));
        s= "abcdeab";
        System.out.println(s+"-> "+duplicateCount(s));
        s= "indivisibility";
        System.out.println(s+"-> "+duplicateCount(s));

        s= "abcde";
        System.out.println(s+"-> "+duplicateCount_manipulateString(s));
        s= "abcdea";
        System.out.println(s+"-> "+duplicateCount_manipulateString(s));
        s= "abcdeab";
        System.out.println(s+"-> "+duplicateCount_manipulateString(s));
        s= "indivisibility";
        System.out.println(s+"-> "+duplicateCount_manipulateString(s));

        s= "abcde";
        System.out.println(s+"-> "+duplicateCount_mapping(s));
        s= "abcdea";
        System.out.println(s+"-> "+duplicateCount_mapping(s));
        s= "abcdeab";
        System.out.println(s+"-> "+duplicateCount_mapping(s));
        s= "indivisibility";
        System.out.println(s+"-> "+duplicateCount_mapping(s));
    }

/*

*/

}





