import java.util.*;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class MexicanWave {
    // I think this is the better solution
    private static String[] waveStream(String str) {
        return IntStream
                .range(0, str.length())
                .mapToObj(x -> new StringBuilder(str).replace(x, x+1, String.valueOf(str.charAt(x)).toUpperCase()).toString())
                .filter(x -> !x.equals(str))
                .toArray(String[]::new);
    }

    private static String[] wave(String str) {
        int cNum = 0;
        for(int i=0; i<str.length(); i++) {
          if (Character.isLetter(str.charAt(i)))
            cNum++;
        }
        String[] result = new String[cNum];
        
        cNum = -1;
        for(int i=0; i<str.length(); i++) {
          if (Character.isLetter(str.charAt(i))) {
            cNum++;
            result[cNum] = str.substring(0,i) + Character.toUpperCase(str.charAt(i)) + str.substring(i+1);
          }
        }
        return result;
      }

    public static void main(String args[]) {
        String s = "";
        
        s = "two words";
        String[] result= wave(s);
        System.out.println(s + "\nwave\n-> "); 
        Arrays.stream(result).forEach(x -> System.out.print("\""+x+"\", "));
        
        result= waveStream(s);
        System.out.println("\nwaveStream\n-> "); 
        Arrays.stream(result).forEach(x -> System.out.print("\""+x+"\", "));
        

    }
}





