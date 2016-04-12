package me.itech.utils;

import java.awt.*;
import java.util.*;

public class ModData
{
    private String name;
    private Color color;
    private boolean state;
    private ArrayList<Value> values;
    
    public ModData(final String name, final int bind, final Color color) {
        this.state = false;
        this.values = new ArrayList<Value>();
        this.name = name;
        this.color = color;
    }
    
    public ArrayList<Value> getValues() {
        return this.values;
    }
    
    public Value getValue(final String key) {
        for (final Value value : this.values) {
            if (value.getName().equalsIgnoreCase(key)) {
                return value;
            }
        }
        return null;
    }
    
    public void setValue(final String key, final Object object) {
        for (final Value value : this.values) {
            if (value.getName().equalsIgnoreCase(key)) {
                value.setValue(object);
            }
        }
    }
    
    public void setValues(final ArrayList<Value> values) {
        for (final Value value : values) {
            for (final Value value2 : this.values) {
                if (value.getName().equalsIgnoreCase(value2.getName())) {
                    value2.setValue(value.getValue());
                }
            }
        }
    }
    
    
    public Color getColor() {
        return this.color;
    }
    
    public void setColor(final Color color) {
        this.color = color;
    }
    
    public boolean getState() {
        return this.state;
    }
    
    public void setState(final boolean state) {
        this.state = state;
    }
    
    public String getName() {
        return this.name;
    }
}
