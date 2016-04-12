package me.itech.module.modules;

import net.minecraft.item.ItemFood;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import me.itech.module.Category;
import me.itech.module.Module;

public class AutoEat extends Module
{
  private double hunger = 8.5D;
  public boolean eating = false;

  public AutoEat() {
    super("AutoEat", Category.AUTO);
  }

  public void onUpdate()
  {
	  if (!this.getState()) {
			return;
		}
      int foodSlot = getFoodSlotInHotbar();
      if ((foodSlot != -1) && (this.mc.thePlayer.getFoodStats().getFoodLevel() < 18))
      {
        this.eating = true;
        this.mc.thePlayer.sendQueue.addToSendQueue(new C09PacketHeldItemChange(foodSlot));
        this.mc.thePlayer.sendQueue.addToSendQueue(new C08PacketPlayerBlockPlacement());
        for (int i = 0; i < 32; i++) {
          this.mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(false));
        }
      }
      this.mc.thePlayer.stopUsingItem();
      this.mc.thePlayer.sendQueue.addToSendQueue(new C09PacketHeldItemChange(this.mc.thePlayer.inventory.currentItem));
      this.eating = false;
    }

  private int getFoodSlotInHotbar()
  {
    for (int i = 0; i < 9; i++) {
      if ((this.mc.thePlayer.inventory.mainInventory[i] != null) && (this.mc.thePlayer.inventory.mainInventory[i].getItem() != null) && ((this.mc.thePlayer.inventory.mainInventory[i].getItem() instanceof ItemFood))) {
        return i;
      }
    }
    return -1;
  }
}
