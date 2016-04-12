package me.itech.module;

import java.util.ArrayList;

import me.itech.module.modules.*;
import me.itech.utils.ModuleHUDElements;

public class ModuleManager {
	
	
	public static ArrayList<Module> activeModules = new ArrayList<Module>();
	
	public ModuleManager() {
		this.activeModules.add(new Sprint());
		this.activeModules.add(new FullBright());
		this.activeModules.add(new Flight());
		this.activeModules.add(new Gui());
		this.activeModules.add(new FastPlace());
		this.activeModules.add(new Aimbot());
		this.activeModules.add(new KillAura());
		this.activeModules.add(new TracerPlayer());
		this.activeModules.add(new TracerMobs());
		this.activeModules.add(new ESPPlayer());
		this.activeModules.add(new ESPMobs());
		this.activeModules.add(new NoFall());
		this.activeModules.add(new AutoWalk());
		this.activeModules.add(new AutoMine());
		this.activeModules.add(new Timer());
		this.activeModules.add(new Step());
		this.activeModules.add(new AutoFish());
		this.activeModules.add(new FastLadder());
		this.activeModules.add(new AntiFire());
		this.activeModules.add(new Climb());
		this.activeModules.add(new Regen());
		this.activeModules.add(new Speed());
		this.activeModules.add(new Glide());
		this.activeModules.add(new AntiKnockback());
		this.activeModules.add(new Nuker());
		this.activeModules.add(new ChestESP());
		this.activeModules.add(new NoWeb());
		this.activeModules.add(new AutoEat());
		this.activeModules.add(new Esp());
		this.activeModules.add(new Trampoline());
		this.activeModules.add(new Bhop());
		this.activeModules.add(new ModuleHUDElements());
		this.activeModules.add(new  ModuleJesus());
	}
	
	public static ArrayList<Module> getModules() {
		return activeModules;
	}
	
	public Module getModule(Class<? extends Module> clazz){
		for(Module mod: getModules()){
			if(mod.getClass() == clazz) {
				return mod;
			}
				
		}
		return null;
	}
}

