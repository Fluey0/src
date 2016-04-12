package me.itech.module.modules;

import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.utils.RenderUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class Nuker extends Module{
	 
    private int xPos;
    private int yPos;
    private int zPos;
    private static int radius = 5;
   
    public Nuker() {
            super("Nuker", Category.WORLD);
    }
   
    public void onUpdate(){
    	if (!this.getState()) {
			return;
		}
                   
            for(int x = -radius; x < radius; x++)
            {
                    for(int y = radius; y > -radius; y--)
                    {
                            for(int z = -radius; z < radius; z++)
                            {
                                    this.xPos = (int)Minecraft.getMinecraft().thePlayer.posX + x;
                                    this.yPos = (int)Minecraft.getMinecraft().thePlayer.posY + y;
                                    this.zPos = (int)Minecraft.getMinecraft().thePlayer.posZ + z;
                                   
                                    BlockPos blockPos = new BlockPos(this.xPos, this.yPos, this.zPos);
                                    Block block = Minecraft.getMinecraft().theWorld.getBlockState(blockPos).getBlock();
                                   
                                    if(block.getMaterial() == Material.air) continue;
                                   
                                    Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(Action.START_DESTROY_BLOCK
                                                    , blockPos, EnumFacing.NORTH));
                                   
                                    Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(Action.STOP_DESTROY_BLOCK
                                                    , blockPos, EnumFacing.NORTH));
                            }
                    }
            }
           
            super.onUpdate();
            
           
    }
   
    @Override
    public void onRender()
    {
    	if (!this.getState()) {
			return;
		}
           
            for(int x = -radius; x < radius; x++)
            {
                    for(int y = radius; y > -radius; y--)
                    {
                            for(int z = -radius; z < radius; z++)
                            {
                                    this.xPos = (int)Minecraft.getMinecraft().thePlayer.posX + x;
                                    this.yPos = (int)Minecraft.getMinecraft().thePlayer.posY + y;
                                    this.zPos = (int)Minecraft.getMinecraft().thePlayer.posZ + z;
                                   
                                    BlockPos blockPos = new BlockPos(this.xPos, this.yPos, this.zPos);
                                    Block block = Minecraft.getMinecraft().theWorld.getBlockState(blockPos).getBlock();
                                   
                                    if(block.getMaterial() == Material.air) continue;
                                   
                                    double renderX = this.xPos - Minecraft.getMinecraft().getRenderManager().renderPosX;
                                    double renderY = this.yPos - Minecraft.getMinecraft().getRenderManager().renderPosY;
                                    double renderZ = this.zPos - Minecraft.getMinecraft().getRenderManager().renderPosZ;
                                   
                                    RenderUtils.drawOutlinedBlockESP(renderX, renderY, renderZ, 1.0F, 0.5F, 1.5F, 1F, 1.5F);
                                   
                            }
                    }
            }
           
            super.onRender();
    }

}
