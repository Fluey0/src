package me.itech.module.modules;

import net.minecraft.network.play.client.C03PacketPlayer;
import me.itech.Storm;
import me.itech.events.listeners.UpdateListener;
import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.Wrapper;

public class AntiFire extends Module{
	
	public AntiFire() {
		super("AntiFire", Category.PLAYER);
	}
	
	@Override
	public void onUpdate()
	{
		if (!this.getState()) {
			return;
	}
		if(!mc.thePlayer.capabilities.isCreativeMode && mc.thePlayer.onGround
			&& mc.thePlayer.isBurning())
			for(int i = 0; i < 100; i++)
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer());
		else
			mc.thePlayer.isBurning();
	}
}


