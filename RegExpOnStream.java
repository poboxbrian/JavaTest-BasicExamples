import java.util.*;

public class RegExpOnStream {

    public static void main(String args[]) {

        List<String> arr = new ArrayList<String>();
       arr.add(";~P)");arr.add("p-p)");arr.add("oP)");arr.add("'8D)");arr.add(":-D)");
       arr.add("'~D)");arr.add(":2-p)");arr.add("8~))");arr.add("~:X)");arr.add("~;x)");
       arr.add(";-)))");arr.add("5~XD)");arr.add(";8))");arr.add("'))");arr.add("'D)");
       arr.add(";p)");arr.add("d:2))");arr.add(":DD)");arr.add(";~x)");arr.add("4D)");
       arr.add(";~-D)");arr.add(":~xd)");arr.add(";D)");arr.add("o))");arr.add("od)");   
       // 4    
        
       arr.add(":)"); arr.add(";~p"); arr.add("5)"); arr.add(":D"); arr.add(":)"); 
       arr.add("-:~D"); arr.add(";X"); arr.add("o2p"); arr.add("opo)"); arr.add("8d"); 
       arr.add("'~XD"); arr.add(";)"); arr.add(":2P"); arr.add(";x"); arr.add(":D"); 
       arr.add(":P"); arr.add("8~D"); arr.add(";)"); arr.add(";x"); arr.add(";oX"); 
       arr.add(";)"); arr.add(":P"); arr.add(":--)"); arr.add("8D"); arr.add(";-d"); 
       arr.add(":)"); arr.add("pd;");
        //8

        arr.add(";~8P"); arr.add(";8P"); arr.add("4xD"); arr.add("o:-)"); arr.add(":-D"); 
        arr.add("~')"); arr.add(";x"); arr.add("(8)"); arr.add("o8)"); arr.add("4x"); 
        arr.add("'d"); arr.add(";px)"); arr.add(";8X)"); arr.add(":)"); arr.add(":p)"); 
        arr.add("5x)"); arr.add("x:oD"); arr.add("(-d"); arr.add(";~D"); arr.add("'~x"); 
        arr.add(":Dd"); arr.add("8d"); arr.add(";)"); arr.add("(8x"); arr.add(":)"); 
        arr.add(":d"); arr.add("8d");
        //5

        arr.add("p)"); arr.add(";X"); arr.add(":))"); arr.add("oxp"); arr.add("4))"); 
        arr.add("ox"); arr.add("5-D"); arr.add(";d)"); arr.add(";-)"); arr.add("oD"); 
        arr.add("5-X"); arr.add(";8p"); arr.add("ppX"); arr.add(";~)"); arr.add("p-P"); 
        arr.add("p~D"); arr.add("4P"); arr.add(";)"); arr.add(":)"); arr.add("5)"); 
        arr.add(";-)"); arr.add("5~D"); arr.add("p)"); arr.add("4D"); arr.add(";~D"); 
        arr.add(";~d"); arr.add(";D"); arr.add(":d");
        //7

        arr.add(";)"); arr.add("4)"); arr.add("oD"); arr.add(":8)x"); arr.add("8)"); 
        arr.add(":X"); arr.add("4x)"); arr.add("p8)"); arr.add("8(D"); arr.add(";-X"); 
        arr.add("5P"); arr.add("8p"); arr.add(";~D"); arr.add(";P"); arr.add("8-x"); 
        arr.add(":8D"); arr.add("5D"); arr.add(";)"); arr.add("'D"); arr.add(":dx"); 
        arr.add("'xP"); arr.add("4)"); arr.add(":~D"); arr.add(":~D"); arr.add(";D"); 
        arr.add("'-D"); arr.add("5)"); arr.add(":D)"); arr.add("5X"); arr.add(";~8X"); 
        arr.add(":d"); arr.add("pD"); arr.add("4X");
        //6


        int count = 0;

        /* Clear way to see it
    
        for (String emot : arr) {
            if( emot.matches( "[:;][-~]?[\\)D]" ) ) {
        System.out.println("emot=" + emot + "\n");
        count++;
            }
        }
        */


        import java.util.Arrays;
        import java.util.Comparator;
        
        public class Order {
          public static String order(String words) {
            return Arrays.stream(words.split(" "))
              .sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
              .reduce((a, b) -> a + " " + b).get();
          }
        }

        return Arrays.stream(words.split(" "))
        .sorted(Comparator.comparing(s -> Integer.valueOf(s
        .replaceAll("\\D", ""))))
        .reduce((a, b) -> a + " " + b).get();
   
        return Arrays.stream(words.split(" "))
        .sorted(Comparator.comparing(s -> Integer.valueOf(s
          .replaceAll("\\D", ""))))
          .reduce((a,b) -> a + " " + b).get();
  


        // Better way to implement
        // Could get rid of "count" variable storage
        count = (int)arr.stream().filter( x -> x.matches("[:;][-~]?[\\)D]") ).count();

        System.out.println("count=" + count + "\n");
    }

}