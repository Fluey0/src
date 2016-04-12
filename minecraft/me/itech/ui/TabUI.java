package me.itech.ui;

import me.itech.Storm;
import me.itech.module.Category;
import me.itech.module.Module;
import me.itech.util.RenderHelper;
import net.minecraft.client.*;

import java.util.*;

import org.lwjgl.opengl.GL11;

public class TabUI
{
    private ArrayList<Panel> panels;
    private Minecraft mc;
    private int panelIndex;
    private int itemIndex;
    private boolean extended;
    
    public TabUI() {
        this.panels = new ArrayList<Panel>();
        this.mc = Minecraft.getMinecraft();
        this.panelIndex = 0;
        this.itemIndex = 0;
        this.extended = false;
        int panelIndex = 0;
        final HashMap<Category, Panel> categoryPanels = new HashMap<Category, Panel>();
        final List<Category> hiddenTypes = Arrays.asList(Category.GUI);
        for (final Module mod : Storm.theClient.moduleManager.getModules()) {
            if (hiddenTypes.contains(mod.getCategory())) {
                continue;
            }
            Panel panel = categoryPanels.get(mod.getCategory());
            if (panel == null) {
                String name = mod.getCategory().name().toLowerCase();
                name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
                panel = new Panel(name);
                panel.index = panelIndex;
                categoryPanels.put(mod.getCategory(), panel);
                this.panels.add(panel);
                ++panelIndex;
            }
            panel.getItems().add(new ModuleItem(mod));
        }
        this.panels.sort(new Comparator<Panel>() {
            @Override
            public int compare(final Panel o1, final Panel o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (final Panel panel2 : this.panels) {
            panel2.getItems().sort(new Comparator<Item>() {
                @Override
                public int compare(final Item o1, final Item o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        }
    }
    
    public void handleInput(final int keyCode) {
        if (keyCode == 200) {
            if (this.extended) {
                --this.itemIndex;
            }
            else {
                --this.panelIndex;
            }
        }
        if (keyCode == 208) {
            if (this.extended) {
                ++this.itemIndex;
            }
            else {
                ++this.panelIndex;
            }
        }
        if (keyCode == 203 && this.extended) {
            this.extended = false;
        }
        if (keyCode == 205 && !this.extended) {
            this.extended = true;
            this.itemIndex = 0;
        }
        if (keyCode == 28 && this.extended) {
            this.panels.get(this.panelIndex).getItems().get(this.itemIndex).interact();
        }
    }
    
    public void renderTabUI(final int x, final int y) {
        if (this.panelIndex > this.panels.size() - 1) {
            this.panelIndex = 0;
        }
        if (this.panelIndex < 0) {
            this.panelIndex = this.panels.size() - 1;
        }
        final List<Item> items = this.panels.get(this.panelIndex).getItems();
        if (this.itemIndex > items.size() - 1) {
            this.itemIndex = 0;
        }
        if (this.itemIndex < 0) {
            this.itemIndex = items.size() - 1;
        }
        GL11.glPushAttrib(16384);
        RenderHelper.drawBorderedRect(x, y, x + this.getPanelWidth() + 1, y + this.getEntireHeight(), 1.0f, -16777216, -1895825408);
        GL11.glPopAttrib();
        int panelOffset = 0;
        for (final Panel panel : this.panels) {
            int col = -6250336;
            if (this.panels.get(this.panelIndex) == panel) {
                col = -96;
            }
            this.mc.fontRendererObj.drawString(panel.getName(), x + 2, y + panelOffset + 2, col);
            panelOffset += this.mc.fontRendererObj.FONT_HEIGHT + 2;
        }
        if (this.extended) {
            final int extendedX = x + this.getPanelWidth() + 1;
            final int extendedY = y + this.panelIndex * (this.mc.fontRendererObj.FONT_HEIGHT + 2);
            GL11.glPushAttrib(1048575);
            RenderHelper.drawBorderedRect(extendedX, extendedY, extendedX + this.getExtendedWidth(), extendedY + this.getExtendedHeight(), 1.0f, -16777216, -1895825408);
            GL11.glPopAttrib();
            int itemOffset = 0;
            for (final Item item : items) {
                int col2 = -6250336;
                if (item instanceof ModuleItem) {
                    final ModuleItem modItem = (ModuleItem)item;
                    if (modItem.getMod().getState()) {
                        col2 = 500990;
                    }
                }
                if (items.get(this.itemIndex) == item) {
                    col2 = -96;
                }
                this.mc.fontRendererObj.drawString(item.getName(), extendedX + 2, extendedY + itemOffset + 2, col2);
                itemOffset += this.mc.fontRendererObj.FONT_HEIGHT + 2;
            }
        }
    }
    
    private int getPanelWidth() {
        int maxWidth = 0;
        for (final Panel panel : this.panels) {
            maxWidth = Math.max(this.mc.fontRendererObj.getStringWidth(panel.getName()) + 2, maxWidth);
        }
        return maxWidth;
    }
    
    private int getEntireHeight() {
        return this.panels.size() * (this.mc.fontRendererObj.FONT_HEIGHT + 2);
    }
    
    private int getExtendedWidth() {
        int maxWidth = 0;
        for (final Item item : this.panels.get(this.panelIndex).getItems()) {
            maxWidth = Math.max(this.mc.fontRendererObj.getStringWidth(item.getName()) + 2, maxWidth);
        }
        return maxWidth;
    }
    
    private int getExtendedHeight() {
        return this.panels.get(this.panelIndex).getItems().size() * (this.mc.fontRendererObj.FONT_HEIGHT + 2);
    }
    
    private class ModuleItem extends Item
    {
        private Module mod;
        
        public ModuleItem(final Module mod) {
            super(mod.getName());
            this.mod = mod;
        }
        
        @Override
        public void interact() {
            this.mod.toggleModule();
        }
        
        public Module getMod() {
            return this.mod;
        }
    }
}
