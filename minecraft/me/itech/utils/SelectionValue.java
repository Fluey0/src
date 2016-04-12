package me.itech.utils;

import java.util.*;

public class SelectionValue extends Value<String>
{
    private List<String> selections;
    
    public SelectionValue(final String name, final String defaultValue, final List<String> selections) {
        super(name, defaultValue);
        this.selections = selections;
    }
    
    public List<String> getSelections() {
        return this.selections;
    }
    
    public void addSelection(final String selection) {
        this.selections.add(selection);
    }
}
