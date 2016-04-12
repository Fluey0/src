package me.itech.module.modules;

import org.darkstorm.minecraft.gui.component.BoundedRangeComponent.ValueDisplay;

import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.values.Value;

public class Timer extends Module {

	Value TimerSpeed = new Value("Timer Speed", 1, 1, 5, ValueDisplay.INTEGER);

	public Timer() {
		super("Timer",  Category.WORLD);
	}

	public void onUpdate() {
		if (this.getState()) {
			net.minecraft.util.Timer.timerSpeed = (float) TimerSpeed.getValue();
		}
	}
	
	public void onDisable(){
		net.minecraft.util.Timer.timerSpeed = 1.0f;
	}

}
