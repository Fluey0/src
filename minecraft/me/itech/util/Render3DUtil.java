package me.itech.util;

import net.minecraft.util.*;
import net.minecraft.client.renderer.*;

public class Render3DUtil
{
    public static void drawOutlinedBoundingBox(final AxisAlignedBB par1AxisAlignedBB) {
        final Tessellator var1 = Tessellator.getInstance();
        final WorldRenderer var2 = var1.getWorldRenderer();
        var2.startDrawing(3);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.minY, par1AxisAlignedBB.minZ);
        var2.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.minY, par1AxisAlignedBB.minZ);
        var2.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.minY, par1AxisAlignedBB.maxZ);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.minY, par1AxisAlignedBB.maxZ);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.minY, par1AxisAlignedBB.minZ);
        var1.draw();
        var2.startDrawing(3);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.minZ);
        var2.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.minZ);
        var2.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.maxZ);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.maxZ);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.minZ);
        var1.draw();
        var2.startDrawing(1);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.minY, par1AxisAlignedBB.minZ);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.minZ);
        var2.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.minY, par1AxisAlignedBB.minZ);
        var2.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.minZ);
        var2.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.minY, par1AxisAlignedBB.maxZ);
        var2.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.maxZ);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.minY, par1AxisAlignedBB.maxZ);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.maxZ);
        var1.draw();
    }
    
    public static void drawBoundingBox(final AxisAlignedBB axisalignedbb) {
        final Tessellator tessellator = Tessellator.getInstance();
        final WorldRenderer worldrender = Tessellator.getInstance().getWorldRenderer();
        worldrender.startDrawingQuads();
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        tessellator.draw();
        worldrender.startDrawingQuads();
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.draw();
        worldrender.startDrawingQuads();
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.draw();
        worldrender.startDrawingQuads();
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.draw();
        worldrender.startDrawingQuads();
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.draw();
        worldrender.startDrawingQuads();
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.draw();
    }
}
