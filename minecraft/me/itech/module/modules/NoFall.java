package me.itech.module.modules;

import net.minecraft.network.play.client.C03PacketPlayer;
import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.Wrapper;

public class NoFall extends Module{
	
	public NoFall(){
		super("NoFall",Category.MOVEMENT);
	}
	
	public void onUpdate(){
		if(getState()){
			if(Wrapper.mc.thePlayer.fallDistance > 2F){
				Wrapper.mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
			}

}
	}
}
