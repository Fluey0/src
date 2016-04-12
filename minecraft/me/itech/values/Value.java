package me.itech.values;

import java.util.ArrayList;

import org.darkstorm.minecraft.gui.component.BoundedRangeComponent.ValueDisplay;

public class Value {
	private double value, min, max;
	private String name;
	private ValueDisplay valueDisplay;
	private static ArrayList<Value> vals = new ArrayList<Value>();

	public static ArrayList<Value> getVals() {
		return vals;
	}

	public Value(String name, double value, double min, double max, ValueDisplay valueDisplay) {
		this.setName(name);
		this.setValue(value);
		this.setMin(min);
		this.setMax(max);
		this.setValueDisplay(valueDisplay);
		this.getVals().add(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ValueDisplay getValueDisplay() {
		return valueDisplay;
	}

	public void setValueDisplay(ValueDisplay valueDisplay) {
		this.valueDisplay = valueDisplay;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}
}
