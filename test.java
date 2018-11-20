import java.util.*;

public class test {

    public static void main(String args[]) {
        String s = "733049910872815764";
        int sz = 5;
        
        if ((s.length() < sz) || (sz < 1)) {    
            //return "";
            System.out.println("empty");
            return;
        }
        
        char[] sBuf = new char[s.length()/sz];
          
        for (int i=0; i<(s.length()/sz); i++) {
          for (int j=0; j<sz; j++) {
            if ((Math.pow((Character.getNumericValue(s.charAt((i*sz)+j))),3)%2) == 0) {
              for (int k=0; k<sz; k++) {
                sBuf[(i*sz)+0] = s.charAt((i*sz)+(sz-k));
              }
            } else{
              sBuf[(i*sz)+sz-1] = s.charAt(i*sz);
              for (int k=1; k<sz; k++) {
                sBuf[(i*sz)+k] = s.charAt((i*sz)+k);
              }
            }
            
          }
        }
        
          //System.out.println("iKeep=" + iKeep + "\n");
          //System.out.println("sizeKeep=" + sizeKeep + "\n");
          System.out.println("sBuf=" + new String(sBuf) + "\n");
    }

}



