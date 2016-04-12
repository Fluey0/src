package me.itech.commands;

import net.minecraft.client.Minecraft;

public class SetName extends Command
{
    public SetName() {
        super("setname", "<name-for-item>", new String[] { "sname" });
    }
    
    @Override
    public void run(final String message) {
        final String name = message.split(" ")[1];
        Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem().setStackDisplayName(name);
    }
}
