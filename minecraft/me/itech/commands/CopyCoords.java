package me.itech.commands;


import me.itech.Chat.Logger;
import net.minecraft.client.*;
import net.minecraft.util.*;

import java.awt.*;
import java.awt.datatransfer.*;

public final class CopyCoords extends Command
{
    public CopyCoords() {
        super("copycoords", "none", new String[] { "cc" });
    }
    
    @Override
    public void run(final String message) {
        final int x = MathHelper.floor_double(Minecraft.getMinecraft().thePlayer.posX);
        final int y = MathHelper.floor_double(Minecraft.getMinecraft().thePlayer.posY);
        final int z = MathHelper.floor_double(Minecraft.getMinecraft().thePlayer.posZ);
        final StringSelection ss = new StringSelection(String.valueOf(x) + " " + y + " " + z);
        final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(ss, null);
        Logger.logChat("Your current XYZ coords have been copied on your clipboard.");
    }
}

