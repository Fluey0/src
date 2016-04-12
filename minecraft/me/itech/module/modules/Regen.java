package me.itech.module.modules;

import net.minecraft.network.play.client.C03PacketPlayer;
import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.Wrapper;

public class Regen extends Module {

	public Regen () {
		super("Regen", Category.PLAYER);
		
	}

	public void onUpdate() {
		if (!this.getState()) {
			return;
		}
		if(!mc.thePlayer.capabilities.isCreativeMode
				&& mc.thePlayer.getFoodStats().getFoodLevel() > 17
				&& mc.thePlayer.getHealth() < 20 && mc.thePlayer.getHealth() != 0
				&& mc.thePlayer.onGround)
				for(int i = 0; i < 1000; i++)
					mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer());
		else
			mc.thePlayer.getAir();
			
		}
	}

