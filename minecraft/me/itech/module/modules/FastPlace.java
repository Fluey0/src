package me.itech.module.modules;

import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.Wrapper;

import org.lwjgl.input.Keyboard;

public class FastPlace extends Module{

	public FastPlace() {
		super("Fastplace", Keyboard.KEY_J, Category.PLAYER);
	}

	public void onUpdate() {
		if (this.getState()) {
			Wrapper.mc.rightClickDelayTimer = 0;
		}
	}

	public void onDisable() {
		Wrapper.mc.rightClickDelayTimer = 6;
	}
}
