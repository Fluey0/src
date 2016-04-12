package me.itech.utils;

public class Value<T>
{
    private String name;
    private T defaultValue;
    private T value;
    
    public Value(final String name, final T defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.value = defaultValue;
    }
    
    public T getValue() {
        return this.value;
    }
    
    public void setValue(final T value) {
        this.value = value;
    }
    
    public String getName() {
        return this.name;
    }
    
    public T getDefaultValue() {
        return this.defaultValue;
    }
}
