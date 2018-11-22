import java.util.*;
import java.util.regex.Pattern;

public class TimeTrialStats {
    private static String stat(String strg) {
        List<Integer> lStats = new ArrayList<Integer>();
        int bufAndMedian = 0;
        int avg = 0;
        int len = 0;
        for (String s:strg.split(", ")) {
            bufAndMedian = (Integer.parseInt(s.substring(0, s.indexOf('|'))) * 3600 )
                          +(Integer.parseInt(s.substring(s.indexOf('|')+1, s.lastIndexOf('|'))) * 60 )
                          + Integer.parseInt(s.substring(s.lastIndexOf('|')+1));
            lStats.add(bufAndMedian);
            avg += bufAndMedian;
            len++;
        }
        
        if (len < 1) return "Range: 00|00|00 Average: 00|00|00 Median: 00|00|00";
        if (len == 1)
            return "Range: 00|00|00 Average: "+formatTime(lStats.get(0))
                                  +" Median: "+formatTime(lStats.get(0));

        Collections.sort(lStats);
        
        bufAndMedian = 0;
        if ((len % 2) == 1) {
            bufAndMedian = lStats.get(len/2);
        } else {
            bufAndMedian = (lStats.get(len/2-1)+lStats.get(len/2)) / 2;
        }

        return ("Range: "+formatTime(Collections.max(lStats) - Collections.min(lStats))
            +" Average: "+formatTime(avg/len)
             +" Median: "+formatTime(bufAndMedian) );
    }
  
    private static String formatTime(int buf) {
        return ((String.format("%02d",(buf/3600)))
        +"|"+(String.format("%02d",((buf%3600)/60)))
        +"|"+(String.format("%02d",((buf%3600)%60))));
    }

    public static String statByStreaming(String strg) {
        if (strg.equals("")) return "";
        Integer[] stats =
          Arrays.asList(strg.split(", "))
                .stream()
                .map(TimeTrialStats::toSeconds)
                .sorted()
                .toArray(Integer[]::new);
        int range = stats[stats.length - 1] - stats[0];
        int avg = Arrays.stream(stats).mapToInt(Integer::intValue).sum() / stats.length;
        int median = stats.length % 2 != 0 ?
          stats[stats.length / 2] :
          (stats[stats.length / 2] + stats[stats.length / 2 - 1]) / 2;
        return String.format("Range: %s Average: %s Median: %s", secToSt(range), secToSt(avg), secToSt(median));
    }
      
    private static int toSeconds(String st) {
    String[] time = st.split(Pattern.quote("|"));
    return Integer.parseInt(time[0]) * 3600 +
            Integer.parseInt(time[1]) * 60 +
            Integer.parseInt(time[2]);
    }
    
    private static String secToSt(int val) {
    int h = (int) val / 3600;
    int m = (int) (val - 3600 * h) / 60;
    return String.format("%02d", h) + "|" + 
            String.format("%02d", m) + "|" + 
            String.format("%02d", (int) (val - 3600 * h - 60 * m));
    }

    public static void main(String args[]) {
        String s = "";
        
        s = "01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17";
        System.out.println(s + " \n-> " + stat(s));
        s = "02|15|59, 2|47|16, 02|17|20, 2|32|34, 2|17|17, 2|22|00, 2|31|41";
        System.out.println(s + " \n-> " + stat(s));
        
        s = "01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17";
        System.out.println(s + " \n-> " + statByIndexing(s));
        s = "02|15|59, 2|47|16, 02|17|20, 2|32|34, 2|17|17, 2|22|00, 2|31|41";
        System.out.println(s + " \n-> " + statByIndexing(s));
        
        s = "01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17";
        System.out.println(s + " \n-> " + statByStreaming(s));
        s = "02|15|59, 2|47|16, 02|17|20, 2|32|34, 2|17|17, 2|22|00, 2|31|41";
        System.out.println(s + " \n-> " + statByStreaming(s));
        

    }

}





