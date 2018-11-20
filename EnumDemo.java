enum Tools {
    SCREWDRIVER, WRENCH, HAMMER, PLIERS
}

class EnumDemo {
    public static void main(String args[]) {
        for(Tools tool : Tools.values()) {
            System.out.println("Enum - " + tool + " ordinal is " + tool.ordinal());
        }
    
    }
}