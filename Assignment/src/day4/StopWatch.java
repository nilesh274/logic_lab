package day4;
public class StopWatch {
    private boolean running;
    private int ticks;

    public StopWatch() {
        this.running = false;
        this.ticks = 0;
    }

    public void start() {
        this.running = true;
    }

    public void stop() {
        this.running = false;
    }

    public void reset() {
        this.ticks = 0;
    }

    public void tick() {
        if (running) {
            ticks++;
        }
    }

    public int elapsed() {
        return ticks;
    }

    public boolean isRunning() {
        return running;
    }


    public static void main(String[] args) {
        StopWatch sw = new StopWatch();

        sw.start();
        for (int i = 0; i < 1000; i++) {
            sw.tick(); 
        }
        
        sw.stop();
        System.out.println("Elapsed after 1000 ticks: " + sw.elapsed()); 

        for (int i = 0; i < 500; i++) {
            sw.tick();
        }
        System.out.println("Elapsed after ticking while stopped: " + sw.elapsed()); 

        sw.reset();
        System.out.println("Elapsed after reset: " + sw.elapsed()); 
    }
}