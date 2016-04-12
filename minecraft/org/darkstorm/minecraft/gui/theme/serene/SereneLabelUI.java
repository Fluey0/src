package org.darkstorm.minecraft.gui.theme.serene;

import org.darkstorm.minecraft.gui.theme.*;
import org.darkstorm.minecraft.gui.component.*;
import org.darkstorm.minecraft.gui.component.Label;
import org.lwjgl.opengl.*;
import org.darkstorm.minecraft.gui.util.*;

import java.awt.*;

public class SereneLabelUI extends AbstractComponentUI<Label>
{
    private final SereneTheme theme;
    
    SereneLabelUI(final SereneTheme theme) {
        super(Label.class);
        this.theme = theme;
        this.foreground = Color.WHITE;
        this.background = new Color(128, 128, 128, 128);
    }
    
    @Override
    protected void renderComponent(final Label label) {
        this.translateComponent(label, false);
        int x = 0;
        int y = 0;
        switch (label.getHorizontalAlignment()) {
            case CENTER: {
                x += label.getWidth() / 2 - this.theme.getFontRenderer().getStringWidth(label.getText()) / 2;
                break;
            }
            case RIGHT: {
                x += label.getWidth() - this.theme.getFontRenderer().getStringWidth(label.getText()) - 2;
                break;
            }
            default: {
                x += 2;
                break;
            }
        }
        switch (label.getVerticalAlignment()) {
            case TOP: {
                y += 2;
                break;
            }
            case BOTTOM: {
                y += label.getHeight() - this.theme.getFontRenderer().FONT_HEIGHT - 2;
                break;
            }
            default: {
                y += label.getHeight() / 2 - this.theme.getFontRenderer().FONT_HEIGHT / 2;
                break;
            }
        }
        GL11.glEnable(3042);
        GL11.glEnable(3553);
        GL11.glDisable(2884);
        this.theme.getFontRenderer().drawString(label.getText(), x, y, RenderUtil.toRGBA(label.getForegroundColor()));
        GL11.glEnable(2884);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        this.translateComponent(label, true);
    }
    
    @Override
    protected Dimension getDefaultComponentSize(final Label component) {
        return new Dimension(this.theme.getFontRenderer().getStringWidth(component.getText()) + 4, this.theme.getFontRenderer().FONT_HEIGHT + 4);
    }
}
