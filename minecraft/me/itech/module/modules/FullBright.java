package me.itech.module.modules;

import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;

import org.lwjgl.input.Keyboard;

import me.itech.Chat.Logger;
import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.Wrapper;

public class FullBright extends Module {
	
	public FullBright() {
		super("FullBright", Category.WORLD);
	}

	public void onUpdate() {
		if (this.getState()) {
			Wrapper.mc.gameSettings.gammaSetting = 999.0f;
			mc.thePlayer.addPotionEffect(new PotionEffect(16, 16350, 3));
		} else {
			Wrapper.mc.gameSettings.gammaSetting = 1f;
			mc.thePlayer.removePotionEffect(16);
		}
	}

}
