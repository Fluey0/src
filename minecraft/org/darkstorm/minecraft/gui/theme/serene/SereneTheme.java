package org.darkstorm.minecraft.gui.theme.serene;

import net.minecraft.client.gui.*;
import java.awt.*;
import org.darkstorm.minecraft.gui.font.*;
import org.darkstorm.minecraft.gui.theme.*;

public class SereneTheme extends AbstractTheme
{
    private final FontRenderer fontRenderer;
    
    public SereneTheme() {
        this.fontRenderer = new UnicodeFontRenderer(new Font("Source Sans Pro", 0, 15));
        this.installUI(new SereneFrameUI(this));
        this.installUI(new SerenePanelUI(this));
        this.installUI(new SereneLabelUI(this));
        this.installUI(new SereneButtonUI(this));
        this.installUI(new SereneCheckButtonUI(this));
        this.installUI(new SereneComboBoxUI(this));
        this.installUI(new SereneSliderUI(this));
        this.installUI(new SereneProgressBarUI(this));
    }
    
    public FontRenderer getFontRenderer() {
        return this.fontRenderer;
    }
}
