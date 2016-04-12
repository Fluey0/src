package me.itech.util;

import net.minecraft.client.*;
import net.minecraft.util.*;

public final class Logger
{
    private static Minecraft mc;
    
    static {
        Logger.mc = Minecraft.getMinecraft();
    }
    
    public static void logChatWithoutAmod(final String message) {
        if (Logger.mc.thePlayer == null) {
            logConsole(message);
        }
        final String name = Logger.mc.session.getUsername();
        Logger.mc.thePlayer.addChatMessage(new ChatComponentText(String.valueOf(name) + message));
    }
    
    public static void logChat(final String message) {
        if (Logger.mc.thePlayer == null) {
            logConsole(message);
        }
        logConsole("");
        Logger.mc.thePlayer.addChatMessage(new ChatComponentText("§6[§lTitan§r§6]§f " + message));
    }
    
    public static void logConsole(final String message) {
        System.out.println("[Titan] " + message);
    }
}
