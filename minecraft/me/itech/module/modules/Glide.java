package me.itech.module.modules;

import net.minecraft.block.material.Material;
import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.Wrapper;

public class Glide extends Module {

	public Glide() {
		super("Glide", Category.MOVEMENT);

	}

	public void onUpdate() {
		if (!this.getState()) {
			return;
		}
		if(mc.thePlayer.motionY < 0 && mc.thePlayer.isAirBorne
				&& !mc.thePlayer.isInWater() && !mc.thePlayer.isOnLadder()
				&& !mc.thePlayer.isInsideOfMaterial(Material.lava))
			{
				mc.thePlayer.motionY = -0.125f;
				mc.thePlayer.jumpMovementFactor *= 1.21337f;
			}
		else 
			mc.thePlayer.isBurning();
		}
	}
