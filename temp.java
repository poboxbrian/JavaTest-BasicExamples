import java.util.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class temp {
    private static String[] wave(String str) {
        int cNum = 0;
        for(int i=0; i<str.length(); i++) {
          if (Character.isLetter(str.charAt(i)))
            cNum++;
        }
        String[] result = new String[cNum];
        StringBuilder sbBuf = new StringBuilder();
        
        cNum = -1;
        for(int i=0; i<str.length(); i++) {
          if (Character.isLetter(str.charAt(i))) {
            cNum++;
            sbBuf.replace(0,-1,str);
            sbBuf.setCharAt(i,Character.toUpperCase(str.charAt(i)));
            result[cNum] = sbBuf.toString();
          }
        }
        return result;
    }

    public static void main(String args[]) {
        String s = "";
        
        s = "two words";
        String[] result= wave(s);
        System.out.println(s + " \n-> "); 
        Arrays.stream(result).forEach(x -> System.out.print("\""+x+"\", "));
//        s = " gap ";
//        System.out.println(s + " \n-> " + wave(s));
        

    }

/*
import java.util.Arrays;
import java.util.function.Function;

public class PangramChecker {
  public boolean check(String sentence){
        for (char c = 'a'; c<='z'; c++)
            if (!sentence.toLowerCase().contains("" + c))
                return false;
        return true;

  }
}

*/

}





