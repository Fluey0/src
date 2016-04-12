package me.itech.module.modules;

import net.minecraft.entity.projectile.EntityFishHook;
import me.itech.module.Category;
import me.itech.module.Module;

public class AutoFish extends Module {
	private boolean catching = false;
	
	public AutoFish() {
		super("AutoFish",Category.AUTO);
	}
	
		
		private boolean isHooked(EntityFishHook hook)
		{
			return hook.motionX == 0.0D && hook.motionZ == 0.0D
				&& hook.motionY != 0.0D;
	}
		
		public void onUpdate() {
			if (!this.getState()) {
				return;
			}
			if(mc.thePlayer.fishEntity != null && isHooked(mc.thePlayer.fishEntity)
					&& !catching)
				{
					catching = true;
					mc.rightClickMouse();
					new Thread("AutoFish")
					{
						@Override
						public void run()
						{
							try
							{
								Thread.sleep(1000);
							}catch(InterruptedException e)
							{
								e.printStackTrace();
							}
							mc.rightClickMouse();
							catching = false;
						}
					}.start();}
			 else 
				 if(mc.thePlayer.fishEntity != null && isHooked(mc.thePlayer.fishEntity)
					&& !catching)
				{
					catching = false;
					{

						}
				}
			}
		}
	

