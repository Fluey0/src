package me.itech.util;

import net.minecraft.client.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.block.*;

public final class BlockHelper
{
    private static Minecraft mc;
    static Block block;
    
    static {
        BlockHelper.mc = Minecraft.getMinecraft();
    }
    
    public static int getBestTool(final int x, final int y, final int z) {
        final Block block = BlockHelper.mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock();
        int slot = 0;
        float dmg = 0.1f;
        for (int index = 36; index < 45; ++index) {
            final ItemStack itemStack = BlockHelper.mc.thePlayer.inventoryContainer.getSlot(index).getStack();
            if (itemStack != null && block != null && itemStack.getItem().getStrVsBlock(itemStack, block) > dmg) {
                slot = index - 36;
                dmg = itemStack.getItem().getStrVsBlock(itemStack, block);
            }
        }
        if (dmg > 0.1f) {
            return slot;
        }
        return BlockHelper.mc.thePlayer.inventory.currentItem;
    }
    
    public static Block getBlockAtPos(final BlockPos inBlockPos) {
        final IBlockState s = BlockHelper.mc.theWorld.getBlockState(inBlockPos);
        return s.getBlock();
    }
    
    public static float[] getBlockRotations(final Entity entity, final int x, final int y, final int z) {
        final double var4 = x - entity.posX + 0.5;
        final double var5 = z - entity.posZ + 0.5;
        final double var6 = y - (entity.posY + entity.getEyeHeight() - 1.0);
        final double var7 = MathHelper.sqrt_double(var4 * var4 + var5 * var5);
        final float var8 = (float)(Math.atan2(var5, var4) * 180.0 / 3.141592653589793) - 90.0f;
        return new float[] { var8, (float)(-(Math.atan2(var6, var7) * 180.0 / 3.141592653589793)) };
    }
    
    public static boolean isInLiquid() {
        boolean inLiquid = false;
        final int y = (int)BlockHelper.mc.thePlayer.boundingBox.minY;
        for (int x = MathHelper.floor_double(BlockHelper.mc.thePlayer.boundingBox.minX); x < MathHelper.floor_double(BlockHelper.mc.thePlayer.boundingBox.maxX) + 1; ++x) {
            for (int z = MathHelper.floor_double(BlockHelper.mc.thePlayer.boundingBox.minZ); z < MathHelper.floor_double(BlockHelper.mc.thePlayer.boundingBox.maxZ) + 1; ++z) {
                final Block block = BlockHelper.mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock();
                if (block != null && !(block instanceof BlockAir)) {
                    if (!(block instanceof BlockLiquid)) {
                        return false;
                    }
                    inLiquid = true;
                }
            }
        }
        return inLiquid;
    }
    
    public static boolean isOnIce() {
        boolean onIce = false;
        final int y = (int)(BlockHelper.mc.thePlayer.boundingBox.minY - 1.0);
        for (int x = MathHelper.floor_double(BlockHelper.mc.thePlayer.boundingBox.minX); x < MathHelper.floor_double(BlockHelper.mc.thePlayer.boundingBox.maxX) + 1; ++x) {
            for (int z = MathHelper.floor_double(BlockHelper.mc.thePlayer.boundingBox.minZ); z < MathHelper.floor_double(BlockHelper.mc.thePlayer.boundingBox.maxZ) + 1; ++z) {
                final Block block = BlockHelper.mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock();
                if (block != null && !(block instanceof BlockAir) && (block instanceof BlockPackedIce || block instanceof BlockIce)) {
                    onIce = true;
                }
            }
        }
        return onIce;
    }
    
    public static boolean isOnLadder() {
        boolean onLadder = false;
        final int y = (int)(BlockHelper.mc.thePlayer.boundingBox.minY - 1.0);
        for (int x = MathHelper.floor_double(BlockHelper.mc.thePlayer.boundingBox.minX); x < MathHelper.floor_double(BlockHelper.mc.thePlayer.boundingBox.maxX) + 1; ++x) {
            for (int z = MathHelper.floor_double(BlockHelper.mc.thePlayer.boundingBox.minZ); z < MathHelper.floor_double(BlockHelper.mc.thePlayer.boundingBox.maxZ) + 1; ++z) {
                final Block block = BlockHelper.mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock();
                if (block != null && !(block instanceof BlockAir)) {
                    if (!(block instanceof BlockLadder) || !(block instanceof BlockVine)) {
                        return false;
                    }
                    onLadder = true;
                }
            }
        }
        return onLadder || BlockHelper.mc.thePlayer.isOnLadder() || BlockHelper.block instanceof BlockVine;
    }
    
    public static boolean isOnLiquid() {
        boolean onLiquid = false;
        final int y = (int)(BlockHelper.mc.thePlayer.boundingBox.minY - 0.01);
        for (int x = MathHelper.floor_double(BlockHelper.mc.thePlayer.boundingBox.minX); x < MathHelper.floor_double(BlockHelper.mc.thePlayer.boundingBox.maxX) + 1; ++x) {
            for (int z = MathHelper.floor_double(BlockHelper.mc.thePlayer.boundingBox.minZ); z < MathHelper.floor_double(BlockHelper.mc.thePlayer.boundingBox.maxZ) + 1; ++z) {
                final Block block = BlockHelper.mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock();
                if (block != null && !(block instanceof BlockAir)) {
                    if (!(block instanceof BlockLiquid)) {
                        return false;
                    }
                    onLiquid = true;
                }
            }
        }
        return onLiquid;
    }
    
    public static Block getBlock(final double posX, final double posY, final double posZ) {
        final BlockPos pos = new BlockPos(posX, posY, posZ);
        return BlockHelper.mc.theWorld.getBlockState(pos).getBlock();
    }
}
