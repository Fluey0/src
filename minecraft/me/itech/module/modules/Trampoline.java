package me.itech.module.modules;

import me.itech.module.Category;
import me.itech.module.Module;

public class Trampoline extends Module
{
    public Trampoline() {
        super("Trampoline", Category.PLAYER);
    }
    
    public void onUpdate() {
    	if (!this.getState()) {
			return;
		}
        if (Trampoline.mc.thePlayer.onGround) {
            Trampoline.mc.thePlayer.motionY = 8.0 * Math.random();
        }
    }
   
}
