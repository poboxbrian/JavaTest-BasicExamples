// Method reference for numeric predicates that operate on integers

interface IntPredicate {
    boolean test(int n);
}

class MyIntPredicates {
    static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i=2; i <= n/i; i++) {
            if((n % i) == 0) return false;
        }
        return true;
    }

    static boolean isEven(int n) { return (n % 2) == 0;}

    static boolean isPositive(int n) { return n > 0;}
}

class MethodRefDemo {
    static boolean numTest(IntPredicate p, int v) {
        return p.test(v);
    }

    public static void main(String args[]) {
        boolean result;

        // uses method references to static method
        result = numTest(MyIntPredicates::isPrime, 17);
        if(result) System.out.println("17 is prime");

        result = numTest(MyIntPredicates::isEven, 12);
        if(result) System.out.println("12 is even");

        result = numTest(MyIntPredicates::isPositive, 11);
        if(result) System.out.println("11 is positive");
    }
}

class MyIntNum {
    private int v;

    MyIntNum(int x) { v=x;}

    int getNum() { return v; }

    boolean isFactor(int n) { return (v%n) == 0; }

    boolean hasCommonFactor(int n) {
        for(int i=1; i <=n && i <= v; i++) {
            if ( (v%i == 0) && (n%i) == 0 ) return true;
        }
        return false;
    }
}

class MethodRefDemo2 {
    public static void main(String args[]) {
        boolean result;

        MyIntNum myNum = new MyIntNum(12);
        MyIntNum myNum2 = new MyIntNum(16);

        // a method ref to an instance method
        IntPredicate ip = myNum::isFactor;

        result = ip.test(3);
        if(result) System.out.println("3 is a factor of " + myNum.getNum());

        // a method ref to an instance method
        ip = myNum2::isFactor;
        result = ip.test(3);
        if(!result) System.out.println("3 is not a factor of " + myNum2.getNum());

        ip = myNum2::hasCommonFactor;
        result = ip.test(3);
        if(!result) System.out.println("3 is not a common factor of " + myNum2.getNum());

        ip = myNum2::hasCommonFactor;
        result = ip.test(4);
        if(result) System.out.println("4 is a common factor of " + myNum2.getNum());
    }
}

interface MyIntNumPredicate {
    boolean test(MyIntNum mv, int n);
}

class MethodRefDemo3 {
    public static void main(String args[]) {
        boolean result;

        MyIntNum myNum = new MyIntNum(12);
        MyIntNum myNum2 = new MyIntNum(16);

        //a method ref to object of type MyIntNum
        MyIntNumPredicate inp = MyIntNum::isFactor; 

        result = inp.test(myNum, 3);
        if(result) System.out.println("3 is a factor of " + myNum.getNum());

        result = inp.test(myNum2, 3);
        if(!result) System.out.println("3 is not a factor of " + myNum2.getNum());
    }
}