/*
Compare to files.
*/

import java.io.*;

class CompFiles {
    public static void main(String args[]) {
        int i=0, j=0;

        // Make sure both files are specified
        if (args.length != 2) {
            System.out.println("Usage: CompFiles f1 f2");
            return;
        }

        //Compare the files
        try (FileInputStream f1 = new FileInputStream(args[0]);
             FileInputStream f2 = new FileInputStream(args[1]))
        {
            // Check contents of each file
            do {
                i = f1.read();
                j = f2.read();
                if (i !=j) break;
            } while (i != -1 && j != -1);

            if (i != j) System.out.println("Files differ.");
            else System.out.println("Files are the same.");
        } catch(IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
    }
}