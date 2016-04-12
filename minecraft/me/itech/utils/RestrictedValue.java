package me.itech.utils;

public class RestrictedValue extends Value<Double>
{
    private Double min;
    private Double max;
    private boolean isInt;
    
    public RestrictedValue(final String name, final Double defaultValue, final Double min, final Double max, final boolean isInt) {
        super(name, defaultValue);
        this.isInt = false;
        this.min = min;
        this.max = max;
        this.isInt = isInt;
    }
    
    public RestrictedValue(final String name, final Double defaultValue, final Double min, final Double max) {
        super(name, defaultValue);
        this.isInt = false;
        this.min = min;
        this.max = max;
        this.isInt = false;
    }
    
    public boolean isInt() {
        return this.isInt;
    }
    
    public Double getMin() {
        return this.min;
    }
    
    public Double getMax() {
        return this.max;
    }
}
