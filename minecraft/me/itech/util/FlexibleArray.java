package me.itech.util;

import java.util.*;

public class FlexibleArray implements Iterable
{
    private Object[] elements;
    
    public FlexibleArray(final Object[] array) {
        this.elements = array;
    }
    
    public FlexibleArray() {
        this.elements = new Object[0];
    }
    
    public void add(final Object t) {
        if (t != null) {
            final Object[] array = new Object[this.size() + 1];
            for (int i = 0; i < array.length; ++i) {
                if (i < this.size()) {
                    array[i] = this.get(i);
                }
                else {
                    array[i] = t;
                }
            }
            this.set(array);
        }
    }
    
    public void remove(final Object t) {
        if (this.contains(t)) {
            final Object[] array = new Object[this.size() - 1];
            boolean b = true;
            for (int i = 0; i < this.size(); ++i) {
                if (b && this.get(i).equals(t)) {
                    b = false;
                }
                else {
                    array[b ? i : (i - 1)] = this.get(i);
                }
            }
            this.set(array);
        }
    }
    
    public boolean contains(final Object t) {
        Object[] var5;
        for (int var4 = (var5 = this.array()).length, var6 = 0; var6 < var4; ++var6) {
            final Object entry = var5[var6];
            if (entry.equals(t)) {
                return true;
            }
        }
        return false;
    }
    
    private void set(final Object[] array) {
        this.elements = array;
    }
    
    public void clear() {
        this.elements = new Object[0];
    }
    
    public Object get(final int index) {
        return this.array()[index];
    }
    
    public int size() {
        return this.array().length;
    }
    
    public Object[] array() {
        return this.elements;
    }
    
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int index = 0;
            
            @Override
            public boolean hasNext() {
                return this.index < FlexibleArray.this.size() && FlexibleArray.this.get(this.index) != null;
            }
            
            @Override
            public Object next() {
                return FlexibleArray.this.get(this.index++);
            }
            
            @Override
            public void remove() {
                FlexibleArray.this.remove(FlexibleArray.this.get(this.index));
            }
        };
    }
}
