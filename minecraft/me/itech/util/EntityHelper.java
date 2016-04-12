package me.itech.util;

import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.entity.ai.attributes.*;

import com.google.common.collect.*;

import java.util.*;
import java.util.Map.Entry;

public final class EntityHelper
{
    private static Minecraft mc;
    
    static {
        EntityHelper.mc = Minecraft.getMinecraft();
    }
    
    public static int getBestWeapon(final Entity target) {
        final int originalSlot = EntityHelper.mc.thePlayer.inventory.currentItem;
        byte weaponSlot = -1;
        float weaponDamage = 1.0f;
        for (byte slot = 0; slot < 9; ++slot) {
            EntityHelper.mc.thePlayer.inventory.currentItem = slot;
            final ItemStack itemStack = EntityHelper.mc.thePlayer.getHeldItem();
            if (itemStack != null) {
                float damage = getItemDamage(itemStack);
                damage += EnchantmentHelper.func_152377_a(itemStack, EnumCreatureAttribute.UNDEFINED);
                if (damage > weaponDamage) {
                    weaponDamage = damage;
                    weaponSlot = slot;
                }
            }
        }
        if (weaponSlot != -1) {
            return weaponSlot;
        }
        return originalSlot;
    }
    
    public static float[] getEntityRotations(final EntityPlayer player, final Entity target) {
        final double var4 = target.posX - player.posX;
        final double var5 = target.posZ - player.posZ;
        final double var6 = target.posY + target.getEyeHeight() / 1.3 - (player.posY + player.getEyeHeight());
        final double var7 = MathHelper.sqrt_double(var4 * var4 + var5 * var5);
        final float yaw = (float)(Math.atan2(var5, var4) * 180.0 / 3.141592653589793) - 90.0f;
        final float pitch = (float)(-(Math.atan2(var6, var7) * 180.0 / 3.141592653589793));
        return new float[] { yaw, pitch };
    }
    
    private float[] getBlockRotations(final int x, final int y, final int z) {
        final double var4 = x - EntityHelper.mc.thePlayer.posX + 0.5;
        final double var5 = z - EntityHelper.mc.thePlayer.posZ + 0.5;
        final double var6 = y - (EntityHelper.mc.thePlayer.posY + EntityHelper.mc.thePlayer.getEyeHeight() - 1.0);
        final double var7 = MathHelper.sqrt_double(var4 * var4 + var5 * var5);
        final float var8 = (float)(Math.atan2(var5, var4) * 180.0 / 3.141592653589793) - 90.0f;
        return new float[] { var8, (float)(-(Math.atan2(var6, var7) * 180.0 / 3.141592653589793)) };
    }
    
    private static float getItemDamage(final ItemStack itemStack) {
        final Multimap multimap = itemStack.getAttributeModifiers();
        if (!multimap.isEmpty()) {
            final Iterator iterator = multimap.entries().iterator();
            if (iterator.hasNext()) {
                final Map.Entry entry = (Entry) iterator.next();
                final AttributeModifier attributeModifier = (AttributeModifier) entry.getValue();
                double damage;
                if (attributeModifier.getOperation() != 1 && attributeModifier.getOperation() != 2) {
                    damage = attributeModifier.getAmount();
                }
                else {
                    damage = attributeModifier.getAmount() * 100.0;
                }
                if (attributeModifier.getAmount() > 1.0) {
                    return 1.0f + (float)damage;
                }
                return 1.0f;
            }
        }
        return 1.0f;
    }
    
    public static float[] getAngles(final Entity entity) {
        final float xDiff = (float)(entity.posX - EntityHelper.mc.thePlayer.posX);
        final float yDiff = (float)(entity.boundingBox.minY + entity.getEyeHeight() - EntityHelper.mc.thePlayer.boundingBox.maxY);
        final float zDiff = (float)(entity.posZ - EntityHelper.mc.thePlayer.posZ);
        final float yaw = (float)(Math.atan2(zDiff, xDiff) * 180.0 / 3.141592653589793 - 90.0);
        final float pitch = (float)(-Math.toDegrees(Math.atan(yDiff / Math.sqrt(zDiff * zDiff + xDiff * xDiff))));
        return new float[] { yaw, pitch };
    }
}
