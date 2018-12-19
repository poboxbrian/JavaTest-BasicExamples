import java.util.*;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class temp {
    private static int duplicateCount(String text) {
      int[] alpha = IntStream.iterate(0, n -> n + 0).limit(26).toArray();
      int[] digit = IntStream.iterate(0, n -> n + 0).limit(10).toArray();
      
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
        System.out.println(a+"-> "+iCount);

      }
      for (int a: digit) {
        System.out.println(a+"-> "+iCount);
        if (a > 1) iCount++;
      }
      return iCount;
    }
    public static void main(String args[]) {
        String s= "abcde";
        System.out.println(" \n-> "+duplicateCount(s));
        s= "abcdea";
        System.out.println(" \n-> "+duplicateCount(s));
        s= "indivisibility";
        System.out.println(" \n-> "+duplicateCount(s));

    }

/*

*/

}





