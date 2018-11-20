class ReverseString {
    String str;

    ReverseString(String s) {
        str = s;
    }

    void reverseString(int iNdx) {
        if(iNdx != str.length()-1) reverseString(iNdx+1);

        System.out.println(str.charAt(iNdx));
    }
}

class RevStrDemo {
    public static void main(String arg[]) {
        ReverseString s = new ReverseString("abcdef");
        s.reverseString(0);
    }
}