package me.itech.utils;

import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.module.ModuleValue;

public class ModuleHUDElements extends Module
{

  @ModuleValue
  public BoolValue watermark = new BoolValue(true);

  @ModuleValue
  public BoolValue coordinates = new BoolValue(true);

  @ModuleValue
  public BoolValue modules = new BoolValue(true);

  @ModuleValue
  public BoolValue server_Info = new BoolValue(true);

  @ModuleValue
  public BoolValue time = new BoolValue(true);

  @ModuleValue
  public BoolValue framerate = new BoolValue(true);

  @ModuleValue
  public BoolValue potion_Effects = new BoolValue(true);

  @ModuleValue
  public BoolValue armour_Status = new BoolValue(true);

  @ModuleValue
  public BoolValue tab_UI = new BoolValue(true);

  public ModuleHUDElements() {
    super("HUD Elements", Category.GUI);
  }

  public boolean getDefaultState() {
    return true;
  }

  public String getHelp()
  {
    return "Displays the HUD elements on screen.";
  }
}
