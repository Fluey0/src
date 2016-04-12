package me.itech.utils;

public class Event
{
    private boolean cancelled;
    
    public Event() {
        this.cancelled = false;
    }
    
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    public void setCancelled(final boolean cancelled) {
        this.cancelled = cancelled;
    }
}
