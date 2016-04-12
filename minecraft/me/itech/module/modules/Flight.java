package me.itech.module.modules;

import org.darkstorm.minecraft.gui.component.BoundedRangeComponent.ValueDisplay;

import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.Wrapper;
import me.itech.values.Value;

public class Flight extends Module {
	
	Value flightSpeed = new Value("Flight Speed", 1, 1, 10, ValueDisplay.INTEGER);

	
	
	public Flight() {
		super("Flight",  Category.MOVEMENT);
	}

	public void onUpdate() {
		if (!this.getState()) {
			return;
		}
		Wrapper.mc.thePlayer.capabilities.setFlySpeed((float) flightSpeed.getValue() / 10);
		Wrapper.mc.thePlayer.capabilities.isFlying = true;
	}

	public void onDisable() {
		Wrapper.mc.thePlayer.capabilities.isFlying = false;
	}
	
	 public static float getFlightSpeed() {
		    return (float)Flight.getFlightSpeed();

}
}