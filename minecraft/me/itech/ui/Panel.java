package me.itech.ui;

import java.util.*;

public class Panel
{
    public int index;
    private String name;
    private ArrayList<Item> items;
    
    public Panel(final String name) {
        this.items = new ArrayList<Item>();
        this.name = name;
    }
    
    public ArrayList<Item> getItems() {
        return this.items;
    }
    
    public String getName() {
        return this.name;
    }
}
