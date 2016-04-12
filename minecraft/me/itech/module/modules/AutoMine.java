package me.itech.module.modules;

import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.Wrapper;

public class AutoMine extends Module {
	
	public AutoMine(){
		super("Auto Mine",Category.AUTO);
	}
	
	public void onUpdate(){
		if(this.getState()){
			Wrapper.mc.gameSettings.keyBindAttack.pressed = true;
		}
	}
	
	public void onDisable(){
		Wrapper.mc.gameSettings.keyBindAttack.pressed = false;
	}

}
