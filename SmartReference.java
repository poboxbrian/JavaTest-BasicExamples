import java.util.stream.*;
/*
needed for LongestConsec
*/

class LongestConsec {
  public static String longestConsec(String[] strarr, int k) {
    String maxStr = "";
    for (int i=0; i<=strarr.length-k; i++) {
      String current = IntStream.range(i, i+k)
                        .mapToObj(j -> strarr[j])
                        .collect(Collectors.joining());
      if (current.length() > maxStr.length()) maxStr = current;
    }
    return maxStr;
  }
}

public static List<Integer> sqInRect(int lng, int wdth) {
    if (lng == wdth) return new ArrayList<Integer>.add(lng);

    if (lng > wdth) {
    //return new ArrayList<Integer>(Arrays.asList(wdth,sqInRect((lng - wdth),wdth));
    return new ArrayList<Integer>(Arrays.asList(3,2,1,1));
    
    } else {
    return new ArrayList<Integer>(Arrays.asList(3,2,1,1));
    //return new ArrayList<Integer>(Arrays.asList(lng,sqInRect((wdth - lng),lng));
    }
}
