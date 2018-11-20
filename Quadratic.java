import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
// if I was going to use multiple members of Math, I could've done this
// import static java.lang.Math.*;

class Quadratic {
    public static void main(String args[]) {
        // a, b, and c represent coeffiecients in ax^2 + bx + c = 0
        double a, b, c, x;

        a = 4; b = 1; c = -3;

        x = (-b + sqrt(pow(b,2) - 4*a*c)) / (2*a);
        System.out.println("First solution: " + x);
        x = (-b - sqrt(pow(b,2) - 4*a*c)) / (2*a);
        System.out.println("Second solution: " + x);

    }
}