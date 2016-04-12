package me.itech.utils;

import java.awt.Font;

import me.itech.ttf.FontUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.network.Packet;
public class Wrapper {

	
	public static Minecraft mc = Minecraft.getMinecraft();
	public static FontRenderer fr = mc.fontRendererObj;
	public static FontUtils fu_default = new FontUtils("Verdana", Font.PLAIN, 18);

	public static void drawBorderRect(int left, int top, int right, int bottom, int bcolor, int icolor, int bwidth)
	  {
	    Gui.drawRect(left + bwidth, top + bwidth, right - bwidth, bottom - bwidth, icolor);
	    Gui.drawRect(left, top, left + bwidth, bottom, bcolor);
	    Gui.drawRect(left + bwidth, top, right, top + bwidth, bcolor);
	    Gui.drawRect(left + bwidth, bottom - bwidth, right, bottom, bcolor);
	    Gui.drawRect(right - bwidth, top + bwidth, right, bottom - bwidth, bcolor);
	  }
	
	public static FontRenderer getFontRenderer() {
        return mc.fontRendererObj;
    }
	 public static EntityPlayerSP getPlayer() {
	        return mc().thePlayer;
	    }
	 public static Minecraft mc() {
	        return Minecraft.getMinecraft();
	    }
	  public static void sendPacketQueue(Packet packet) {
		    mc().thePlayer.sendQueue.addToSendQueue(packet);
		  }

		  public static void sendPacket(Packet packet) {
		    getPlayer().sendQueue.addToSendQueue(packet);
		  }
}