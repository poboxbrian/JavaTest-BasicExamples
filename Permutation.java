/**
 * This solution for finding all permutations is based upon a recursion tree
 * ABC
 * -> ABC - BAC - CBA
 * ->-> ABC - ACB    BAC - BCA   CBA - CAB
 * 
 * NOTE: For doing anagrams this is not efficient, ie. it's time and resource
 */

public class Permutation {

    public static void main (String[] args) {
        String str = "abc";

        Permutation permutation = new Permutation();
        permutation.permute("", str); 
    }
    
    private static void permute(String prefix, String str) {
        if (str.length() == 0) 
            System.out.println(prefix);
        else {
            for (int i = 0; i < str.length(); i++)
            permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
        }
    }


}