package me.itech.module.modules;

import me.itech.Storm;
import me.itech.events.listeners.UpdateListener;
import me.itech.module.Category;
import me.itech.module.Module;

public class FastLadder extends Module implements UpdateListener {
	
	public FastLadder() {
		super("FastLadder",Category.PLAYER);
	}
	
	@Override
	public void onEnable()
	{
		Storm.events.add(UpdateListener.class, this);
	}
	
	@Override
	public void onUpdate()
	{
		if(mc.thePlayer.isOnLadder() && mc.thePlayer.isCollidedHorizontally)
			mc.thePlayer.motionY = 0.25;

}
	@Override
	public void onDisable()
	{
		Storm.events.remove(UpdateListener.class, this);
	}
}
