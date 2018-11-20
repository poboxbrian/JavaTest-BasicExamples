/*
Sieve of Eratosthenes Algorithm

Create a list of consecutive integers from 2 to n: (2, 3, 4, …, n).
Initially, let p equal 2, the first prime number.
Starting from p, count up in increments of p and mark each of these 
    numbers greater than p itself in the list. These numbers will be 
    2p, 3p, 4p, etc.; note that some of them may have already been 
    marked.
Find the first number greater than p in the list that is not marked. 
    If there was no such number, stop. Otherwise, let p now equal 
    this number (which is the next prime), and repeat from step 3.

*/

class FindPrime {
    public static void main(String args[]) {
        int[] iArr = new int[99];
        for (int i = 2; i < 100; i++) {
            iArr[i-2] = i;
        }
        int iBuf = 0;
        for (int i = 2; i < 100; i++) {
            iBuf = i + i;
            while (iBuf < 100) {
                iArr[iBuf - 2] = 0;
                iBuf += i;
            }
        }

        for (int i = 2; i < 100; i++) {
            if (iArr[i-2] > 0) {
                System.out.println(iArr[i-2] + "\n");

            }
        }

    }
}

/* Here is another find prime method
*/
 class ShortFindPrime {
     public static void main(String args[]) {
        int n = Integer.parseInt(args[0]);
        boolean bPrime = true;

        if (n > 2)  {
            for (int i=2; i <= n/i; i++) {
                if ((n%i) == 0) bPrime = false;
            }
        }
        System.out.println("Is prime = " + bPrime);
     }
 }