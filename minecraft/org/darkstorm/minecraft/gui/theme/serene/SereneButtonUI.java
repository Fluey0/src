package org.darkstorm.minecraft.gui.theme.serene;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import me.itech.util.RenderHelper;

import org.darkstorm.minecraft.gui.theme.*;
import org.darkstorm.minecraft.gui.component.*;
import org.darkstorm.minecraft.gui.component.Button;
import org.darkstorm.minecraft.gui.component.Component;
import org.lwjgl.opengl.*;


import org.darkstorm.minecraft.gui.util.*;
import org.lwjgl.input.*;


import java.awt.*;

public class SereneButtonUI extends AbstractComponentUI<Button>
{
    private final SereneTheme theme;
    
    SereneButtonUI(final SereneTheme theme) {
        super(Button.class);
        this.theme = theme;
        this.foreground = Color.WHITE;
        this.background = new Color(32, 125, 255, 192);
    }
    
    @Override
    protected void renderComponent(final Button button) {
        this.translateComponent(button, false);
        final Rectangle area = button.getArea();
        GL11.glEnable(3042);
        GL11.glDisable(2884);
        GL11.glDisable(3553);
        RenderHelper.drawBorderedRect(0.0f, 0.0f, area.width, area.height, 0.125f, 2130706432, button.getBackgroundColor().getRGB());
        final Point mouse = RenderUtil.calculateMouseLocation();
        for (Component parent = button.getParent(); parent != null; parent = parent.getParent()) {
            final Point point = mouse;
            point.x -= parent.getX();
            final Point point2 = mouse;
            point2.y -= parent.getY();
        }
        if (area.contains(mouse)) {
            RenderHelper.drawBorderedRect(0.0f, 0.0f, area.width, area.height, 1.0f, 0, new Color(0.0f, 0.0f, 0.0f, Mouse.isButtonDown(0) ? 0.5f : 0.3f).getRGB());
        }
        GL11.glEnable(3553);
        String text = button.getText();
		theme.getFontRenderer().drawString(
				text,
				area.width / 2 - theme.getFontRenderer().getStringWidth(text)
						/ 2,
				area.height / 2 - theme.getFontRenderer().FONT_HEIGHT / 2,
				RenderUtil.toRGBA(button.getForegroundColor()));

		glEnable(GL_CULL_FACE);
		glDisable(GL_BLEND);
		translateComponent(button, true);
	}
            
    
    @Override
    protected Dimension getDefaultComponentSize(final Button component) {
        return new Dimension(this.theme.getFontRenderer().getStringWidth(component.getText()) + 4, this.theme.getFontRenderer().FONT_HEIGHT + 4);
    }
    
    @Override
    protected Rectangle[] getInteractableComponentRegions(final Button component) {
        return new Rectangle[] { new Rectangle(0, 0, component.getWidth(), component.getHeight()) };
    }
    
    @Override
    protected void handleComponentInteraction(final Button component, final Point location, final int button) {
        if (location.x <= component.getWidth() && location.y <= component.getHeight() && button == 0) {
            component.press();
        }
    }
}
