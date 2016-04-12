package me.itech.module.modules;

import darkmagician6.EventManager;
import darkmagician6.EventTarget;
import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;

public class Bhop extends Module {
	public int mode = 0;

	public boolean shouldJump = true;
	public boolean isFalling = false;
	public int number = 0;

	public Bhop() {
		super("Bhop", Category.MOVEMENT);
	}

	public void onEnable() {
		EventManager.register(this);
	}

	public void onDisable() {
		EventManager.unregister(this);
		net.minecraft.util.Timer.timerSpeed = 1.0F;
	}

	public void onUpdate() {
		if (!this.getState()) {
			return;
		}
		{
			if ((!Wrapper.mc().gameSettings.keyBindForward.pressed)
					&& (!Wrapper.mc().gameSettings.keyBindBack.pressed))
				this.shouldJump = true;
			if ((Wrapper.getPlayer().onGround)
					&& ((Wrapper.getPlayer().moveForward != 0.0F) || (Wrapper
							.getPlayer().moveStrafing != 0.0F))) {
				this.isFalling = false;
				this.shouldJump = (!this.shouldJump);
				if ((this.shouldJump) && (Wrapper.getPlayer().onGround)) {
					this.number += 1;
				}
				if (this.number >= 2) {
					net.minecraft.util.Timer.timerSpeed = 1.3F;
					this.number = 0;
				} else {
					net.minecraft.util.Timer.timerSpeed = 1.0F;
				}
				Wrapper.getPlayer().motionY = (this.shouldJump ? 0.4078F
						: 0.123F);
				Wrapper.getPlayer().motionX *= (this.shouldJump ? 3.0F : 0.05F);
				Wrapper.getPlayer().motionZ *= (this.shouldJump ? 3.0F : 0.05F);
			}
			if (Wrapper.getPlayer().getFoodStats().getFoodLevel() < 7) {
				return;
			}
			if ((Wrapper.getPlayer().fallDistance > 2.0F) && (!this.isFalling)) {
				Wrapper.getPlayer().jumpMovementFactor = (this.shouldJump ? 0.0771191F
						: 0.0F);
			} else {
				this.isFalling = true;
				Wrapper.getPlayer().jumpMovementFactor = 0.0284F;
			}
			return;
		}
	}
}
