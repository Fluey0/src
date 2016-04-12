package me.itech.module.modules;

import org.darkstorm.minecraft.gui.component.BoundedRangeComponent.ValueDisplay;

import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.Wrapper;
import me.itech.values.Value;

public class AntiKnockback extends Module {
	
	public AntiKnockback(){
		super("AntiKnockback", Category.COMBAT);

}
	
	public void onUpdate(){
		if(getState()){
			if(mc.thePlayer.hurtTime > 0)
			{
				mc.thePlayer.motionX = 0;
				mc.thePlayer.motionY = 0;
				mc.thePlayer.motionZ = 0;
					
			}
			else
				mc.thePlayer.getAir();
		}
	}
}
