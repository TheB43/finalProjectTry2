 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Label here.
 * 
 * @author SCL 
 *
 */
public class Label extends Actor
{
    public static final int LEFT = 0;
    public static final int CENTER = 1;
    public static final int RIGHT = 2;
    public static final Font LARGE_FONT = new Font("SansSerif", Font.BOLD, 30);
    
    // colours and other user definable attributes with default values
    private Color textColor = Color.BLACK;
    private Color backgroundColor = null;
    private Color borderColor = null;
    private int alignment = CENTER;
    
    //slacing, with default values
    private int inset = 8;  //space between text and edge
    
    private String text;
    private int baseline;  //the y-coordinate of the text baseline
    private int textX;     //the x-coordinates of the left edge of the text
    private int width = -1;
    private int height = -1;
    
    
    
    
    public Label()
    {
        this("Label");
    }
    
    public Label(String text)
    {
        this.text = text;
        createImage();
    }
    
    
    
    public void setText(String text)
    {
        this.text = text;
        createImage();
    }
    
    
    
    public String getText()
    {
        return text;
    }
    
    
    
    public void setFont(Font font)
    {
        getImage().setFont(font);
        
        createImage();
        
    }
    
    
    
    public Font getFont()
    {
        return getImage().getFont();
    }
    
    
    
    public void setBackground(Color backgroundColor)
    {
        this.backgroundColor = backgroundColor;
        createImage();
    }
    
    
    
    public void setForeground(Color foregroundColor)
    {
        this.textColor = foregroundColor;
        createImage();
    }
    
    
    
    public void setBorder(Color borderColor)
    {
        this.borderColor = borderColor;
        createImage();
    }
    
    
    
    
    public void setAlignment(int alignment)
    {
        this.alignment = alignment;
        createImage();
    }
    
    
    
    public void setWidth(int width)
    {
        this.width = width;
        createImage();
    }
    
    
    
    public void setHeight(int height)
    {
        this.height = height;
        createImage();
    }
    
    
    
    
    public void setLocation(int x, int y)
    {
        super.setLocation (x + getImage().getWidth()/2, y + getImage().getHeight()/2);
    }
    
    // --------------------------- private methods --------------------------------
    
    
    
    private void repaint()
    {
        paintBackground();
        paintBorder();
        paintText();
    }
    
    
    
    private void paintBackground()
    {
        if (backgroundColor != null) {
            GreenfootImage img = getImage();
            img.setColor(backgroundColor);
            img.fill();
        }
    }
    
    
    
    private void paintText()
    {
        GreenfootImage img = getImage();
        img.setColor(textColor);
        img.drawString(text, textX, baseline);
    }
    
    
    
    private void paintBorder()
    {
        if (borderColor != null) {
            GreenfootImage img = getImage();
            img.setColor(borderColor);
            img.drawRect(0, 0, img.getWidth()-1, img.getHeight()-1);
        }
    }
    
    
    
    
    
    private void createImage()
    {
        int imgWidth = width;
        int imgHeight = height;
        
        GreenfootImage img = new GreenfootImage(100,50);
        Graphics gc = img.getAwtImage().getGraphics();
        img.setFont(getFont());
        FontMetrics fm = gc.getFontMetrics();
        
        
        int textWidth = fm.stringWidth(text);
        if (imgWidth <=0) {
            imgWidth= textWidth * 2 + 2 * inset;
        }
        if (imgHeight <= 0) {
            imgHeight = fm.getHeight() + 2 * inset;
        }
        
        baseline = (imgHeight/2) + (fm.getAscent()/2);
        if (alignment == LEFT) {
            textX = inset;
        }
        else if (alignment == RIGHT) {
            textX = imgWidth - inset - textWidth * 3;
        }
        else { // center
            textX = (imgWidth/2) - (textWidth * 3) /2;
        }
        img.scale(imgWidth, imgHeight);
        setImage(img);
        repaint();
    }
}
    
    
    
    
