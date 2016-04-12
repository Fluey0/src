package me.itech.utils;

import java.awt.Color;

public class Orion {
	
private static Color color = Color.WHITE;
public static float hue = 0.0F;
public static boolean rainbow = true;
public static BooleanValue rainbowValue = new BooleanValue("color_rainbow", Boolean.valueOf(true));
public static RestrictedValue rValue = new RestrictedValue("color_red", Double.valueOf(92.0D), Double.valueOf(0.0D), Double.valueOf(255.0D));
public static RestrictedValue gValue = new RestrictedValue("color_green", Double.valueOf(137.0D), Double.valueOf(0.0D), Double.valueOf(255.0D));
public static RestrictedValue bValue = new RestrictedValue("color_blue", Double.valueOf(214.0D), Double.valueOf(0.0D), Double.valueOf(255.0D));
{

rainbow = ((Boolean)rainbowValue.getValue()).booleanValue();
int r = ((Double)rValue.getValue()).intValue();
int g = ((Double)gValue.getValue()).intValue();
int b = ((Double)bValue.getValue()).intValue();

Color color = new Color(r, g, b);

if (!rainbow) 
	setColor(color); 
}
public static Color getColor() {
    return color;
  }

  public static void setColor(Color color) {
    color = color;
  }
  
  @EventListener
  public void onTick(EventTick event) {
    rainbow = ((Boolean)rainbowValue.getValue()).booleanValue();

    int r = ((Double)rValue.getValue()).intValue();
    int g = ((Double)gValue.getValue()).intValue();
    int b = ((Double)bValue.getValue()).intValue();

    Color color = new Color(r, g, b);

    if (!rainbow) {
    	setColor(color);
    }

    hue += 2.0F;
    float v = 70.0F;
    if (hue > 270.0F) {
      hue = 0.0F;
    }

    if (rainbow) setColor(Color.getHSBColor(hue / 270.0F, 0.7F, v / 100.0F));
  }
}
