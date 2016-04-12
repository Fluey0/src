package darkmagician6;

public abstract class EventCancellable implements Event, Cancellable
{
    protected boolean cancelled;
    
    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    @Override
    public void setCancelled(final boolean state) {
        this.cancelled = state;
    }
}
