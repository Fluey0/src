package me.itech.events.external;

import net.minecraft.block.Block;

public class EventRenderBlockPass 
{
  private boolean alpha;
  private Block block;

  public EventRenderBlockPass(boolean alpha, Block block)
  {
    this.alpha = alpha;
    this.block = block;
  }

  public Block getBlock() {
    return this.block;
  }

  public boolean getAlpha() {
    return this.alpha;
  }

  public void setAlpha(boolean alpha) {
    this.alpha = alpha;
  }
}
