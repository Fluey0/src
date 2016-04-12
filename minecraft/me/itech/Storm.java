package me.itech;


import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import me.itech.events.EventManager;
import me.itech.managers.GuiManager;
import me.itech.module.Module;
import me.itech.module.ModuleManager;
import me.itech.module.modules.Flight;
import net.minecraft.client.Minecraft;

import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;
import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.ImageIOImageData;

public class Storm {
	
	public static String Client_Name = "[Dependent]";
	public static double Client_version = 1.0;
	public Flight SpeedFF;
	public final static Storm theClient = new Storm();
	public static ModuleManager moduleManager;
	private GuiManagerDisplayScreen gui;
	private GuiManager guiManager;
	public static EventManager events;
	
	public static Minecraft mc = Minecraft.getMinecraft();

	public static void StartClient(){
		moduleManager = new ModuleManager();
		Display.setTitle("Dependent");
		events = new EventManager();
		
		
	}
	public GuiManager getGuiManager() {
		if(guiManager == null){
			 guiManager = new GuiManager();
			 guiManager.setTheme(new SimpleTheme());
			 guiManager.setup();
		}
		return guiManager;
	}
	
	public GuiManagerDisplayScreen getGui() {
		if(gui == null){
			gui = new GuiManagerDisplayScreen(getGuiManager());
			
		}
		return gui;
	}

	public static String getClient_Name() {
		return Client_Name;
	}

	public static void setClient_Name(String client_Name) {
		Client_Name = client_Name;
	}

	public static double getClient_version() {
		return Client_version;
	}

	public static void setClient_version(double client_version) {
		Client_version = client_version;
	}
	
	
}
