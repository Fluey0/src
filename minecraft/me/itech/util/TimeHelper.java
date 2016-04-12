package me.itech.util;

public final class TimeHelper
{
    private long lastMS;
    
    public long getCurrentMS() {
        return System.nanoTime() / 1000000L;
    }
    
    public long getLastMS() {
        return this.lastMS;
    }
    
    public boolean hasReached(final float f) {
        return this.getCurrentMS() - this.lastMS >= f;
    }
    
    public boolean isDelayComplete(final long delay) {
        return System.currentTimeMillis() - this.lastMS >= delay;
    }
    
    public void reset() {
        this.lastMS = this.getCurrentMS();
    }
    
    public void setLastMS(final long lastMS) {
        this.lastMS = lastMS;
    }
    
    public void setLastMS() {
        this.lastMS = System.currentTimeMillis();
    }
    
    public int convertToMS(final int perSecond) {
        return 1000 / perSecond;
    }
}
