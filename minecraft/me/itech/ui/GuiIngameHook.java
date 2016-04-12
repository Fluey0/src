package me.itech.ui;

import io.github.supercheese200.serenity.events.game.EventKeyPress;

import java.awt.Color;
import java.util.Random;

import me.itech.Storm;
import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.ChatColor;
import me.itech.utils.ModuleHUDElements;
import me.itech.utils.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;

public class GuiIngameHook extends GuiIngame{

	private TabUI tabUI;
	
	
	public GuiIngameHook(Minecraft mcIn) {
		super(mcIn);
		
	}
	
	public void func_175180_a(float p_175180_1_) {
		super.func_175180_a(p_175180_1_);
		Storm.theClient.getGuiManager().renderPinned();
		Storm.theClient.getGuiManager().update();
		renderArrayList();
		this.tabUI = new TabUI();
		this.tabUI.renderTabUI(0, 0);
		 int bottomYCount_2 = 10;

}

	
	public  void renderArrayList(){
            
		int yCount = 15;
		for(Module m : Storm.theClient.moduleManager.activeModules){
			m.onRender();
			
			if(m.getState() && !m.isCategory(Category.GUI)){
				Wrapper.fu_default.drawString(m.getName(),  0, yCount, m.getColor());
				yCount +=10;
			}
			
		}

			}
	
	public void onKeyPress(EventKeyPress event) {
	    ModuleHUDElements hudElements = (ModuleHUDElements)Storm.theClient.moduleManager.getModule(ModuleHUDElements.class);
	    if ((hudElements.getState()) && (hudElements.tab_UI.getValue()))
	      this.tabUI.handleInput(event.getKey()); 
	  }
	
			
			
}



