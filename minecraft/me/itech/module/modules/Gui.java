package me.itech.module.modules;

import org.lwjgl.input.Keyboard;

import me.itech.Storm;
import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.Wrapper;

public class Gui extends Module{
	
	public Gui() {
		super("Gui", Keyboard.KEY_RSHIFT, Category.GUI);
	}
	
	public void onToggle(){
		Wrapper.mc.displayGuiScreen(Storm.theClient.getGui());
	}

}
