package me.itech.events.external;

import net.minecraft.block.Block;

public class EventRenderBlockSides 
{
  private boolean renderAllSides = false;
  private Block block;

  public EventRenderBlockSides(Block block)
  {
    this.block = block;
  }

  public Block getBlock() {
    return this.block;
  }

  public boolean getRenderAllSides() {
    return this.renderAllSides;
  }

  public void setRenderAllSides(boolean renderAllSides) {
    this.renderAllSides = renderAllSides;
  }
}
