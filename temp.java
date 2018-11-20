import java.util.*;
//import java.util.Arrays;
//import java.util.stream;

public class temp {
    private static int dblLinear (int n) {
        Set<Integer> set = new HashSet<Integer>();
        int iCount = 0;

        for (int i=0; iCount <= n; i++) {
          if (i == 0) {
            set.add(1);
            iCount++;
          } else if (set.contains(i)) {
            set.add(2*i + 1);
            set.add(3*i + 1);
            iCount++;
          }
        }
        
        Integer[] array = set.stream().toArray(x -> new Integer[x]);
        Arrays.sort(array);
        
        return array[n];
        
    }

    public static void main(String args[]) {
        int n = 10;
        int result = dblLinear(n);
        System.out.println("kataJohn -- " + result);

    }

}





