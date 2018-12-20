import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombineTwoSetsWithoutComplement {
    public static String process(String phrase1, String phrase2) {
        if (phrase1 != null) {
            phrase1 = phrase1.replaceAll("[^A-Za-z0-9 ]", " ");
            phrase1 = phrase1.replaceAll("\\s+", " ");
        }
        if (phrase2 != null) {
            phrase2 = phrase2.replaceAll("[^A-Za-z0-9 ]", " ");
            phrase2 = phrase2.replaceAll("\\s+", " ");
        }

        Set<String> set1 = new TreeSet<String>();
        Set<String> set2 = new TreeSet<String>();
        if (phrase1 != null && phrase1.isEmpty() == false) {
            set1.addAll(Arrays.stream(phrase1.split(" ")).collect(Collectors.toSet()));
        }
        if (phrase2 != null && phrase2.isEmpty() == false) {
            set2.addAll(Arrays.stream(phrase2.split(" ")).collect(Collectors.toSet()));
        }

        List<String> combine = set1.stream().collect(Collectors.toList());
        combine.removeAll(set2);
        set2.removeAll(set1);
        combine.addAll(set2);
        
        Collections.sort(combine);
        // 189,819 is the length of the longest word on earth
        combine.sort((s1, s2) -> Math.abs(s1.length() - 200000) - Math.abs(s2.length() - 200000));

        return combine.toString().replaceAll("[\\[\\],]","");
    }

    public static void main(String[] args) {
        String phrase1 = "This is a great time - to be a good software engineer.";
        String phrase2 = "Great software engineers think, \"this is as good a time as any.\"";
        String expectedResults = "engineers engineer Great great think This this any as be to";
        System.out.println("<["+process(phrase1, phrase2)+"]>");
        System.out.println("<["+expectedResults+"]>");
    
        phrase1 = "a b c d";
        phrase2 = "x y b z d";
        expectedResults = "a c x y z";
        System.out.println("<["+process(phrase1, phrase2)+"]>");
        System.out.println("<["+expectedResults+"]>");
    
        phrase1 = "";
        phrase2 = "a b c d";
        expectedResults = "a b c d";
        System.out.println("<["+process(phrase1, phrase2)+"]>");
        System.out.println("<["+expectedResults+"]>");
    
        phrase1 = "a b c d";
        phrase2 = "";
        expectedResults = "a b c d";
        System.out.println("<["+process(phrase1, phrase2)+"]>");
        System.out.println("<["+expectedResults+"]>");
    
        phrase1 = "";
        phrase2 = "";
        expectedResults = "";
        System.out.println("<["+process(phrase1, phrase2)+"]>");
        System.out.println("<["+expectedResults+"]>");
    
        phrase1 = null;
        phrase2 = "a b c d";
        expectedResults = "a b c d";
        System.out.println("<["+process(phrase1, phrase2)+"]>");
        System.out.println("<["+expectedResults+"]>");
    
        phrase1 = "a b c d";
        phrase2 = null;
        expectedResults = "a b c d";
        System.out.println("<["+process(phrase1, phrase2)+"]>");
        System.out.println("<["+expectedResults+"]>");
    
        phrase1 = null;
        phrase2 = null;
        expectedResults = "";
        System.out.println("<["+process(phrase1, phrase2)+"]>");
        System.out.println("<["+expectedResults+"]>");
    
        phrase1 = "123Word1 1 word2 123Word";
        phrase2 = "123Word word2 123Word1 2 ";
        expectedResults = "1 2";
        System.out.println("<["+process(phrase1, phrase2)+"]>");
        System.out.println("<["+expectedResults+"]>");
    
        phrase1 = "!";
        phrase2 = "@";
        expectedResults = "";
        System.out.println("<["+process(phrase1, phrase2)+"]>");
        System.out.println("<["+expectedResults+"]>");
    
        phrase1 = "a b c d";
        phrase2 = "a b c d";
        expectedResults = "";
        System.out.println("<["+process(phrase1, phrase2)+"]>");
        System.out.println("<["+expectedResults+"]>");
    
        phrase1 = " a b o d  ";
        phrase2 = "   a   b c d ";
        expectedResults = "c o";
        System.out.println("<["+process(phrase1, phrase2)+"]>");
        System.out.println("<["+expectedResults+"]>");
    
        phrase1 = "bbbb ee ez z";
        phrase2 = "d aaa cc ey";
        expectedResults = "bbbb aaa cc ee ey ez d z";
        System.out.println("<["+process(phrase1, phrase2)+"]>");
        System.out.println("<["+expectedResults+"]>");
    
    }
}
