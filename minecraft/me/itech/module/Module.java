package me.itech.module;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;


public class Module {

	private String name;
	private int bind, color;
	private Category category;
	private boolean isEnabled;
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public Module(String name, int bind, int color ,Category category) {
		this.name = name;
		this.bind = bind;
		this.category = category;
		this.color = 0xFFFFFF;}
		
		public Module(String name, int bind, Category category) {
			this.name = name;
			this.bind = bind;
			this.color = 0xFFFFFF;
			this.category = category; }
			
			public Module(String name ,Category category) {
				this.name = name;
				this.bind = 0;
				this.color = 0xFFFFFF;
				this.category = category;
	}

	public String getName() {
		return name;
	}

	public int getBind() {
		return bind;
	}

	public Category getCategory() {
		return category;
	}
	
	public int getColor(){
		return color;
	}
	
		public boolean getState() {
			return isEnabled;
	}               
	
	
	public void setState(boolean state) {
		this.onToggle();
	if (state) {
		this.onEnable();
		this.isEnabled = true;
	} else {
		this.onDisable();
		this.isEnabled = false; }

}
	
	public void toggleModule() {
		this.setState(!this.getState());
	
}
	public void onToggle() {
	}

	public void onEnable() {
	}

	public void onDisable() {
	}

	public void onUpdate() {
	}

	public void onRender() {
	}

	public boolean isCategory(Category is) {
		if(is == category)
		return true;
		return false;
	}
	
		  

}


