// Simulate a traffic light

enum TrafficLightColor {
    RED(6000), YELLOW(2000), GREEN(5000);

    private int tlcTime; // time in ms to stay this color

    TrafficLightColor(int t) { tlcTime = t; }

    int getDelay() { return tlcTime; }

    TrafficLightColor next() {
        if (ordinal() == values().length - 1) {
            return values()[0];
        } else {
            return values()[ordinal() + 1];
        }
    }
}

class TrafficLightSimulator implements Runnable {
    private TrafficLightColor tlc;
    private boolean stop = false;
    private boolean changed = false;

    TrafficLightSimulator (TrafficLightColor init) {
        tlc = init;
    }

    TrafficLightSimulator() {
        tlc = TrafficLightColor.RED;
    }

    public void run() {
        while(!stop) {
            try {
                Thread.sleep(tlc.getDelay());
            } catch(InterruptedException exc) {
                System.out.println(exc);
            }
            changeColor();
        }
    }

    synchronized void changeColor() {
        tlc = tlc.next();
        changed = true;
        notify(); //signal light has changed
    }

    synchronized void waitForChange() {
        try {
            while(!changed) wait();
            changed = false;
        } catch(InterruptedException exc) {
            System.out.println(exc);
        }
    }

    synchronized TrafficLightColor getColor() {
        return tlc;
    }

    // stop the traffic light
    synchronized void cancel() {
        stop = true;
    }
}

class TrafficLightDemo {
    public static void main (String args[]) {
        TrafficLightSimulator t1 = new TrafficLightSimulator(TrafficLightColor.GREEN);
        Thread thrd = new Thread(t1);
        thrd.start();

        for(int i=0; i < 9; i++) {
            System.out.println(t1.getColor());
            t1.waitForChange();
        }

        t1.cancel();
    }
}
