package me.itech.module.modules;

import net.minecraft.network.play.client.C03PacketPlayer;
import me.itech.module.Category;
import me.itech.module.Module;

public class Speed extends Module {
	
	public Speed() {
		super("Speed", Category.MOVEMENT);

}
	
	public void onUpdate() {
		if (!this.getState()) {
			return;
		}
		// return if sneaking or not walking
				if(mc.thePlayer.isSneaking() || mc.thePlayer.moveForward == 0
					&& mc.thePlayer.moveStrafing == 0)
					return;
				
				// activate sprint if walking forward
				if(mc.thePlayer.moveForward > 0 && !mc.thePlayer.isCollidedHorizontally)
					mc.thePlayer.setSprinting(true);
				
				// activate mini jump if on ground
				if(mc.thePlayer.onGround)
				{
					mc.thePlayer.motionY += 0.1;
					mc.thePlayer.motionX *= 1.8;
					mc.thePlayer.motionZ *= 1.8;
					double currentSpeed =
						Math.sqrt(Math.pow(mc.thePlayer.motionX, 2)
							+ Math.pow(mc.thePlayer.motionZ, 2));
					
					// limit speed to highest value that works on NoCheat+ version
					// 3.13.0-BETA-sMD5NET-b878
					// UPDATE: Patched in NoCheat+ version 3.13.2-SNAPSHOT-sMD5NET-b888
					double maxSpeed = 0.66F;
					if(currentSpeed > maxSpeed)
					{
						mc.thePlayer.motionX =
							mc.thePlayer.motionX / currentSpeed * maxSpeed;
						mc.thePlayer.motionZ =
							mc.thePlayer.motionZ / currentSpeed * maxSpeed;
					}
				}
		else
			mc.thePlayer.getAir();
}
}
