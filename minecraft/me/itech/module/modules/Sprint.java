package me.itech.module.modules;

import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.Wrapper;
import net.minecraft.potion.PotionEffect;

import org.lwjgl.input.Keyboard;

public class Sprint extends Module {
	
	public Sprint() {
		super("Sprint", Category.MOVEMENT);
		
	}

	public void onUpdate() {
		if (!this.getState()) {
			return;
		}
		if (!(Wrapper.mc.thePlayer.isCollidedHorizontally) && Wrapper.mc.thePlayer.moveForward > 0.0f) {
			Wrapper.mc.thePlayer.setSprinting(true);
		} else {
			Wrapper.mc.thePlayer.setSprinting(false);
		}
	}

}
