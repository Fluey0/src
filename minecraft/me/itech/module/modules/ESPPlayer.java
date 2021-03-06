package me.itech.module.modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.RenderUtils;

public class ESPPlayer extends Module{
	
	public ESPPlayer() {
		super("ESP Player", Category.ESP);
	}
	
	@Override
	public void onRender() {
		
		if(!this.getState())
			return;
		
		for(Object theObject : mc.theWorld.loadedEntityList) {
			if(!(theObject instanceof EntityLivingBase))
				continue;
			
			EntityLivingBase entity = (EntityLivingBase) theObject;
			
			if(entity instanceof EntityPlayer) {
				if(entity != mc.thePlayer)
					player(entity);
				continue;
			}
			
		}
		
		super.onRender();
	}
	
	public void player(EntityLivingBase entity) {
		float red = 0.5F;
		float green = 0.5F;
		float blue = 1F;
		
		double xPos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosX;
		double yPos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosY;
		double zPos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosZ;
		
		render(red, green, blue, xPos, yPos, zPos, entity.width, entity.height);
	}
	
	
	public void render(float red, float green, float blue, double x, double y, double z, float width, float height) {
		RenderUtils.drawEntityESP(x, y, z, width, height, red, green, blue, 0.45F, 0F, 0F, 0F, 1F, 1F);
	}

}
