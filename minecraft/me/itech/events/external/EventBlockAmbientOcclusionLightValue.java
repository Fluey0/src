package me.itech.events.external;

import net.minecraft.block.Block;

public class EventBlockAmbientOcclusionLightValue 
{
  private Block block;
  private float lightValue;

  public EventBlockAmbientOcclusionLightValue(Block block, float lightValue)
  {
    this.block = block;
    this.lightValue = lightValue;
  }

  public Block getBlock() {
    return this.block;
  }

  public float getLightValue() {
    return this.lightValue;
  }

  public void setLightValue(float lightValue) {
    this.lightValue = lightValue;
  }
}