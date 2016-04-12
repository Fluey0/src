package me.itech.util;

public class Timer
{
    private long prevTime;
    
    public Timer() {
        this.prevTime = 0L;
    }
    
    public boolean hasTimePassed(final long milSec) {
        return this.getTime() - this.prevTime >= milSec;
    }
    
    public void reset() {
        this.prevTime = this.getTime();
    }
    
    public long getTime() {
        return System.nanoTime() / 1000000L;
    }
}
