package org.darkstorm.minecraft.gui.theme.serene;

import me.itech.util.RenderHelper;

import org.darkstorm.minecraft.gui.theme.*;
import org.darkstorm.minecraft.gui.component.*;
import org.darkstorm.minecraft.gui.component.Component;
import org.darkstorm.minecraft.gui.component.Frame;
import org.lwjgl.opengl.*;


import org.darkstorm.minecraft.gui.util.*;

import java.awt.*;

import org.darkstorm.minecraft.gui.layout.*;

public class SereneFrameUI extends AbstractComponentUI<Frame>
{
    private final SereneTheme theme;
    
    SereneFrameUI(final SereneTheme theme) {
        super(Frame.class);
        this.theme = theme;
        this.foreground = Color.WHITE;
        this.background = new Color(32, 32, 32, 128);
    }
    
    @Override
    protected void renderComponent(final Frame component) {
        final Rectangle area = new Rectangle(component.getArea());
        final int fontHeight = this.theme.getFontRenderer().FONT_HEIGHT;
        this.translateComponent(component, false);
        GL11.glEnable(3042);
        GL11.glDisable(2884);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        if (component.isMinimized()) {
            area.height = fontHeight + 4;
        }
        RenderHelper.drawBorderedRect(0.0f, 0.0f, area.width, area.height, 1.0f, 0, component.getBackgroundColor().getRGB());
        int offset = component.getWidth() - 2;
        final Point mouse = RenderUtil.calculateMouseLocation();
        for (Component parent = component; parent != null; parent = parent.getParent()) {
            final Point point = mouse;
            point.x -= parent.getX();
            final Point point2 = mouse;
            point2.y -= parent.getY();
        }
        final boolean[] checks = { component.isClosable(), component.isPinnable(), component.isMinimizable() };
        final boolean[] overlays = { false, component.isPinned(), component.isMinimized() };
        for (int i = 0; i < checks.length; ++i) {
            if (checks[i]) {
                RenderHelper.drawBorderedRect(offset - fontHeight, 2.0f, offset, fontHeight + 2, 0.25f, -16777216, 2130706432);
                if (overlays[i]) {
                    RenderHelper.drawBorderedRect(offset - fontHeight, 2.0f, offset, fontHeight + 2, 0.25f, 0, 1077952576);
                }
                if (mouse.x >= offset - fontHeight && mouse.x <= offset && mouse.y >= 2 && mouse.y <= fontHeight + 2) {
                    RenderHelper.drawBorderedRect(offset - fontHeight, 2.0f, offset, fontHeight + 2, 0.25f, 0, 1426063360);
                }
                offset -= fontHeight + 2;
            }
        }
        GL11.glColor4f(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glLineWidth(1.0f);
        GL11.glEnable(3553);
        this.theme.getFontRenderer().drawString(component.getTitle(), 2, 2, RenderUtil.toRGBA(component.getForegroundColor()));
        GL11.glEnable(2884);
        GL11.glDisable(3042);
        this.translateComponent(component, true);
    }
    
    @Override
    protected Rectangle getContainerChildRenderArea(final Frame container) {
        final Rectangle area = new Rectangle(container.getArea());
        area.x = 2;
        area.y = this.theme.getFontRenderer().FONT_HEIGHT + 6;
        final Rectangle rectangle = area;
        rectangle.width -= 4;
        final Rectangle rectangle2 = area;
        rectangle2.height -= this.theme.getFontRenderer().FONT_HEIGHT + 8;
        return area;
    }
    
    @Override
    protected Dimension getDefaultComponentSize(final Frame component) {
        final Component[] children = component.getChildren();
        final Rectangle[] areas = new Rectangle[children.length];
        final Constraint[][] constraints = new Constraint[children.length][];
        for (int i = 0; i < children.length; ++i) {
            final Component child = children[i];
            final Dimension size = child.getTheme().getUIForComponent(child).getDefaultSize(child);
            areas[i] = new Rectangle(0, 0, size.width, size.height);
            constraints[i] = component.getConstraints(child);
        }
        final Dimension optimalPositionedSize;
        final Dimension size2 = optimalPositionedSize = component.getLayoutManager().getOptimalPositionedSize(areas, constraints);
        optimalPositionedSize.width += 4;
        final Dimension dimension = size2;
        dimension.height += this.theme.getFontRenderer().FONT_HEIGHT + 8;
        return size2;
    }
    
    @Override
    protected Rectangle[] getInteractableComponentRegions(final Frame component) {
        return new Rectangle[] { new Rectangle(0, 0, component.getWidth(), this.theme.getFontRenderer().FONT_HEIGHT + 4) };
    }
    
    @Override
    protected void handleComponentInteraction(final Frame component, final Point location, final int button) {
        if (button != 0) {
            return;
        }
        int offset = component.getWidth() - 2;
        final int textHeight = this.theme.getFontRenderer().FONT_HEIGHT;
        if (component.isClosable()) {
            if (location.x >= offset - textHeight && location.x <= offset && location.y >= 2 && location.y <= textHeight + 2) {
                component.close();
                return;
            }
            offset -= textHeight + 2;
        }
        if (component.isPinnable()) {
            if (location.x >= offset - textHeight && location.x <= offset && location.y >= 2 && location.y <= textHeight + 2) {
                component.setPinned(!component.isPinned());
                return;
            }
            offset -= textHeight + 2;
        }
        if (component.isMinimizable()) {
            if (location.x >= offset - textHeight && location.x <= offset && location.y >= 2 && location.y <= textHeight + 2) {
                component.setMinimized(!component.isMinimized());
                return;
            }
            offset -= textHeight + 2;
        }
        if (location.x >= 0 && location.x <= offset && location.y >= 0 && location.y <= textHeight + 4) {
            component.setDragging(true);
        }
    }
}
