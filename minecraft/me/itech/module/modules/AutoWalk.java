package me.itech.module.modules;

import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.Wrapper;

public class AutoWalk extends Module {

	public AutoWalk(){
		super("Auto Walk", Category.AUTO);
	}
	
	public void onUpdate(){
		if(getState()){
			Wrapper.mc.gameSettings.keyBindForward.pressed = true;
		}
	}
	
	public void onDisable(){
		Wrapper.mc.gameSettings.keyBindForward.pressed = false;
	}
}
