package me.itech.module.modules;

import org.darkstorm.minecraft.gui.component.BoundedRangeComponent.ValueDisplay;

import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.Wrapper;
import me.itech.values.Value;

public class Step extends Module {
	
	Value stepHeight = new Value("Step Height", 1, 1, 5, ValueDisplay.INTEGER);

	public Step() {
		super("Step", Category.MOVEMENT);
	}
	
	public void onUpdate(){
		if(this.getState()){
			Wrapper.mc.getMinecraft().thePlayer.stepHeight = (float) stepHeight.getValue();
			mc.thePlayer.stepHeight = 0.5F;
			if(mc.thePlayer.isCollidedHorizontally && mc.thePlayer.onGround)
				mc.thePlayer.jump();
		}else{
			Wrapper.mc.getMinecraft().thePlayer.stepHeight = 0.5f;
		}
	}

}
