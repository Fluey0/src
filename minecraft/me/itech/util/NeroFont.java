package me.itech.util;

import java.awt.image.*;

import net.minecraft.util.*;

import java.util.regex.*;
import java.io.*;

import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;

import org.lwjgl.opengl.*;

import java.awt.geom.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import net.minecraft.client.renderer.*;

public class NeroFont
{
    private Font theFont;
    private Graphics2D theGraphics;
    private FontMetrics theMetrics;
    private float fontSize;
    private int startChar;
    private int endChar;
    private float[] xPos;
    private float[] yPos;
    private BufferedImage bufferedImage;
    private float extraSpacing;
    private DynamicTexture dynamicTexture;
    private ResourceLocation resourceLocation;
    private final Pattern patternControlCode;
    private final Pattern patternUnsupported;
    
    public NeroFont(final Object font, final float size) {
        this(font, size, 0.0f);
    }
    
    public NeroFont(final Object font, final float size, final float spacing) {
        this.extraSpacing = 0.0f;
        this.patternControlCode = Pattern.compile("(?i)\\u00A7[0-9A-FK-OG]");
        this.patternUnsupported = Pattern.compile("(?i)\\u00A7[K-O]");
        this.fontSize = size;
        this.startChar = 32;
        this.endChar = 255;
        this.extraSpacing = spacing;
        this.xPos = new float[this.endChar - this.startChar];
        this.yPos = new float[this.endChar - this.startChar];
        this.setupGraphics2D();
        this.createFont(font, size);
    }
    
    private void setupGraphics2D() {
        this.bufferedImage = new BufferedImage(256, 256, 2);
        (this.theGraphics = (Graphics2D)this.bufferedImage.getGraphics()).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }
    
    public void createFont(final Object font, final float size) {
        try {
            if (font instanceof Font) {
                this.theFont = (Font)font;
            }
            else if (font instanceof File) {
                this.theFont = Font.createFont(0, (File)font).deriveFont(size);
            }
            else if (font instanceof InputStream) {
                this.theFont = Font.createFont(0, (InputStream)font).deriveFont(size);
            }
            else if (font instanceof String) {
                this.theFont = new Font((String)font, 0, Math.round(size));
            }
            else {
                this.theFont = new Font("Verdana", 0, Math.round(size));
            }
            this.theGraphics.setFont(this.theFont);
        }
        catch (Exception var6) {
            var6.printStackTrace();
            this.theFont = new Font("Verdana", 0, Math.round(size));
            this.theGraphics.setFont(this.theFont);
        }
        this.theGraphics.setColor(new Color(255, 255, 255, 0));
        this.theGraphics.fillRect(0, 0, 256, 256);
        this.theGraphics.setColor(Color.white);
        this.theMetrics = this.theGraphics.getFontMetrics();
        float x = 5.0f;
        float y = 5.0f;
        for (int i = this.startChar; i < this.endChar; ++i) {
            this.theGraphics.drawString(Character.toString((char)i), x, y + this.theMetrics.getAscent());
            this.xPos[i - this.startChar] = x;
            this.yPos[i - this.startChar] = y - this.theMetrics.getMaxDescent();
            x += this.theMetrics.stringWidth(Character.toString((char)i)) + 2.0f;
            if (x >= 250 - this.theMetrics.getMaxAdvance()) {
                x = 5.0f;
                y += this.theMetrics.getMaxAscent() + this.theMetrics.getMaxDescent() + this.fontSize / 2.0f;
            }
        }
        final TextureManager textureManager = Minecraft.getMinecraft().getTextureManager();
        final String string = "font" + font.toString() + size;
        final DynamicTexture dynamicTexture = new DynamicTexture(this.bufferedImage);
        this.dynamicTexture = dynamicTexture;
        this.resourceLocation = textureManager.getDynamicTextureLocation(string, dynamicTexture);
    }
    
    public void drawString(String text, final float x, final float y, final FontType fontType, final int color, final int color2) {
        GL11.glPushMatrix();
        text = this.stripUnsupported(text);
        GL11.glEnable(3042);
        GL11.glEnable(3042);
        GL11.glEnable(2848);
        GL11.glDisable(3553);
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(7425);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        final String text2 = this.stripControlCodes(text);
        switch (fontType.ordinal()) {
            case 1: {
                this.drawer(text2, x + 0.5f, y, color2);
                this.drawer(text2, x - 0.5f, y, color2);
                this.drawer(text2, x, y + 0.5f, color2);
                this.drawer(text2, x, y - 0.5f, color2);
                break;
            }
            case 2: {
                this.drawer(text2, x + 0.5f, y + 0.5f, color2);
                break;
            }
            case 3: {
                this.drawer(text2, x + 0.5f, y + 1.0f, color2);
                break;
            }
            case 4: {
                this.drawer(text2, x, y + 0.5f, color2);
                break;
            }
            case 5: {
                this.drawer(text2, x, y - 0.5f, color2);
                break;
            }
        }
        this.drawer(text, x, y, color);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glShadeModel(7424);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(3553);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glPopMatrix();
    }
    
    private void drawer(final String text, float x, float y, final int color) {
        x *= 2.0f;
        y *= 2.0f;
        GL11.glEnable(3553);
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.resourceLocation);
        final float alpha = (color >> 24 & 0xFF) / 255.0f;
        final float red = (color >> 16 & 0xFF) / 255.0f;
        final float green = (color >> 8 & 0xFF) / 255.0f;
        final float blue = (color & 0xFF) / 255.0f;
        GL11.glColor4f(red, green, blue, alpha);
        final float startX = x;
        for (int i = 0; i < text.length(); ++i) {
            if (text.charAt(i) == '§' && i + 1 < text.length()) {
                final char indexException = Character.toLowerCase(text.charAt(i + 1));
                if (indexException == 'n') {
                    y += this.theMetrics.getAscent() + 2;
                    x = startX;
                }
                final int var16 = "0123456789abcdefklmnorg".indexOf(indexException);
                if (var16 < 16) {
                    try {
                        final int exception = Minecraft.getMinecraft().fontRendererObj.colorCode[var16];
                        GL11.glColor4f((exception >> 16) / 255.0f, (exception >> 8 & 0xFF) / 255.0f, (exception & 0xFF) / 255.0f, alpha);
                    }
                    catch (Exception var17) {
                        var17.printStackTrace();
                    }
                }
                else if (indexException == 'f') {
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, alpha);
                }
                else if (indexException == 'r') {
                    GL11.glColor4f(red, green, blue, alpha);
                }
                else if (indexException == 'g') {
                    GL11.glColor4f(0.47f, 0.67f, 0.27f, alpha);
                }
                ++i;
            }
            else {
                try {
                    final char indexException = text.charAt(i);
                    this.drawChar(indexException, x, y);
                    x += this.getStringWidth(Character.toString(indexException)) * 2.0f;
                }
                catch (ArrayIndexOutOfBoundsException var18) {
                    final char c = text.charAt(i);
                    System.out.println("Can't draw character: " + c + " (" + Character.getNumericValue(c) + ")");
                }
            }
        }
    }
    
    public float getStringWidth(final String text) {
        return (float)(this.getBounds(text).getWidth() + this.extraSpacing) / 2.0f;
    }
    
    public float getStringHeight(final String text) {
        return (float)this.getBounds(text).getHeight() / 2.0f;
    }
    
    private Rectangle2D getBounds(final String text) {
        return this.theMetrics.getStringBounds(text, this.theGraphics);
    }
    
    private void drawChar(final char character, final float x, final float y) throws ArrayIndexOutOfBoundsException {
        final Rectangle2D bounds = this.theMetrics.getStringBounds(Character.toString(character), this.theGraphics);
        this.drawTexturedModalRect(x, y, this.xPos[character - this.startChar], this.yPos[character - this.startChar], (float)bounds.getWidth(), (float)bounds.getHeight() + this.theMetrics.getMaxDescent() + 1.0f);
    }
    
    public List listFormattedStringToWidth(final String s, final int width) {
        return Arrays.asList(this.wrapFormattedStringToWidth(s, width).split("\n"));
    }
    
    String wrapFormattedStringToWidth(final String s, final float width) {
        final int wrapWidth = this.sizeStringToWidth(s, width);
        if (s.length() <= wrapWidth) {
            return s;
        }
        final String split = s.substring(0, wrapWidth);
        final String split2 = String.valueOf(this.getFormatFromString(split)) + s.substring(wrapWidth + ((s.charAt(wrapWidth) == ' ' || s.charAt(wrapWidth) == '\n') ? 1 : 0));
        try {
            return String.valueOf(split) + "\n" + this.wrapFormattedStringToWidth(split2, width);
        }
        catch (Exception var7) {
            System.out.println("Cannot wrap string to width.");
            return "";
        }
    }
    
    private int sizeStringToWidth(final String par1Str, final float par2) {
        final int var3 = par1Str.length();
        float var4 = 0.0f;
        int var5 = 0;
        int var6 = -1;
        boolean var7 = false;
        while (var5 < var3) {
            final char var8 = par1Str.charAt(var5);
            Label_0184: {
                switch (var8) {
                    case '\n': {
                        --var5;
                        break Label_0184;
                    }
                    case ' ':
                    case '-':
                    case ':':
                    case '_': {
                        var6 = var5;
                        break;
                    }
                }
                final String var9 = String.valueOf(var8);
                var4 += this.getStringWidth(var9);
                if (var7) {
                    ++var4;
                }
                if (var5 < var3 - 1) {
                    ++var5;
                    final char text = par1Str.charAt(var5);
                    if (text != 'l' && text != 'L') {
                        if (text == 'r' || text == 'R' || this.isFormatColor(text)) {
                            var7 = false;
                        }
                    }
                    else {
                        var7 = true;
                    }
                }
            }
            if (var8 == '\n') {
                var6 = ++var5;
            }
            else if (var4 > par2) {
                break;
            }
            ++var5;
        }
        return (var5 != var3 && var6 != -1 && var6 < var5) ? var6 : var5;
    }
    
    private String getFormatFromString(final String par0Str) {
        String var1 = "";
        int var2 = -1;
        final int var3 = par0Str.length();
        while ((var2 = par0Str.indexOf(167, var2 + 1)) != -1) {
            if (var2 < var3 - 1) {
                final char var4 = par0Str.charAt(var2 + 1);
                if (this.isFormatColor(var4)) {
                    var1 = "\u00c3\u201a§" + var4;
                }
                else {
                    if (!this.isFormatSpecial(var4)) {
                        continue;
                    }
                    var1 = String.valueOf(var1) + "\u00c3\u201a§" + var4;
                }
            }
        }
        return var1;
    }
    
    private boolean isFormatColor(final char par0) {
        return (par0 >= '0' && par0 <= '9') || (par0 >= 'a' && par0 <= 'f') || (par0 >= 'A' && par0 <= 'F');
    }
    
    private boolean isFormatSpecial(final char par0) {
        return (par0 >= 'k' && par0 <= 'o') || (par0 >= 'K' && par0 <= 'O') || par0 == 'r' || par0 == 'R';
    }
    
    private void drawTexturedModalRect(final float x, final float y, final float u, final float v, final float width, final float height) {
        final float scale = 0.0039063f;
        final Tessellator tessellator = Tessellator.getInstance();
        final WorldRenderer renderer = tessellator.getWorldRenderer();
        renderer.startDrawingQuads();
        renderer.addVertexWithUV(x + 0.0f, y + height, 0.0, (u + 0.0f) * scale, (v + height) * scale);
        renderer.addVertexWithUV(x + width, y + height, 0.0, (u + width) * scale, (v + height) * scale);
        renderer.addVertexWithUV(x + width, y + 0.0f, 0.0, (u + width) * scale, (v + 0.0f) * scale);
        renderer.addVertexWithUV(x + 0.0f, y + 0.0f, 0.0, (u + 0.0f) * scale, (v + 0.0f) * scale);
        tessellator.draw();
    }
    
    public String stripControlCodes(final String s) {
        return this.patternControlCode.matcher(s).replaceAll("");
    }
    
    public String stripUnsupported(final String s) {
        return this.patternUnsupported.matcher(s).replaceAll("");
    }
    
    public Graphics2D getGraphics() {
        return this.theGraphics;
    }
    
    public Font getFont() {
        return this.theFont;
    }
    
    public enum FontType
    {
        NORMAL("NORMAL", 0), 
        SHADOW_THICK("SHADOW_THICK", 1), 
        SHADOW_THIN("SHADOW_THIN", 2), 
        OUTLINE_THIN("OUTLINE_THIN", 3), 
        EMBOSS_TOP("EMBOSS_TOP", 4), 
        EMBOSS_BOTTOM("EMBOSS_BOTTOM", 5);
        
        private FontType(final String s, final int n) {
        }
    }
}
