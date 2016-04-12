package me.itech.module.modules;

import me.itech.Storm;
import me.itech.events.listeners.UpdateListener;
import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.Wrapper;

public class Climb extends Module {

	public Climb(){
		super("Climb",Category.MOVEMENT);
	}
	
	public void onUpdate() {
		if (!this.getState()) {
			return;
		}
		if(mc.thePlayer.isCollidedHorizontally)
			mc.thePlayer.motionY = 0.2;
		 else 
			if(mc.thePlayer.isCollidedHorizontally)
				mc.thePlayer.motionY = 0;
		}
	}





