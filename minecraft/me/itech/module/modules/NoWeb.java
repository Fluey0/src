package me.itech.module.modules;

import me.itech.module.Category;
import me.itech.module.Module;

public class NoWeb extends Module
{
  public NoWeb()
  {
    super("NoWeb", Category.MOVEMENT);
  }

  public void onUpdate() {
	  if (!this.getState()) {
			return;
	  }
    {
      mc.thePlayer.isInWeb = false;
    }
    super.onUpdate();
  }
}

