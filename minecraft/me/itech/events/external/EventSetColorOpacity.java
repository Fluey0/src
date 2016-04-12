package me.itech.events.external;

import me.itech.events.Event;

public class EventSetColorOpacity
{
  private int opacity;

  public EventSetColorOpacity(int opacity)
  {
    this.opacity = opacity;
  }

  public int getOpacity() {
    return this.opacity;
  }

  public void setOpacity(int opacity) {
    this.opacity = opacity;
  }
}
