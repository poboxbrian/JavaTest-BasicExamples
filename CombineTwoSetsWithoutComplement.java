import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombineTwoSetsWithoutComplement {
    public static String process(String phrase1, String phrase2) {
        phrase1 = phrase1.replaceAll("[^A-Za-z0-9 ]", " ");
        phrase2 = phrase2.replaceAll("[^A-Za-z0-9 ]", " ");
        phrase1 = phrase1.replaceAll("\\s+", " ");
        phrase2 = phrase2.replaceAll("\\s+", " ");

        Set<String> set1 = Arrays.stream(phrase1.split(" ")).collect(Collectors.toSet());
        Set<String> set2 = Arrays.stream(phrase2.split(" ")).collect(Collectors.toSet());
        List<String> combine = set1.stream().collect(Collectors.toList());
        combine.removeAll(set2);
        set2.removeAll(set1);
        combine.addAll(set2);
        
        Collections.sort(combine);
        // 189,819 is the length of the longest word on earth
        combine.sort((s1, s2) -> Math.abs(s1.length() - 200000) - Math.abs(s2.length() - 200000));

        return combine.toString().replaceAll(",","");
    }

    public static void main(String[] args) {
        String phrase1 = "This is a great time - to be a good software engineer.";
        String phrase2 = "Great software engineers think, \"this is as good a time as any.\"";
        System.out.println(process(phrase1, phrase2));
    }
}
