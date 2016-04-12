package me.itech.utils;

import java.util.List;

public abstract class ListManager
{
    protected List contents;
    
    public final List getContents() {
        return this.contents;
    }
    
    public abstract void setup();
}
