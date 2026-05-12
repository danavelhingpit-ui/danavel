package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Custom JPanel that displays a background image
 * Supports scaling, tiling, and transparency
 */
public class BackgroundPanel extends JPanel {
    private BufferedImage backgroundImage;
    private ScaleMode scaleMode;

    public enum ScaleMode {
        STRETCH, TILE, CENTER, FIT
    }

    public BackgroundPanel(String imagePath) {
        this(imagePath, ScaleMode.STRETCH);
    }

    public BackgroundPanel(String imagePath, ScaleMode scaleMode) {
        this.scaleMode = scaleMode;
        loadImage(imagePath);
        setLayout(new BorderLayout());
    }

    private void loadImage(String imagePath) {
        try {
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                backgroundImage = ImageIO.read(imageFile);
                repaint();
            } else {
                System.err.println("Background image not found: " + imagePath);
            }
        } catch (IOException e) {
            System.err.println("Error loading background image: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                    RenderingHints.VALUE_INTERPOLATION_HIGH_QUALITY);

            switch (scaleMode) {
                case STRETCH:
                    g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                    break;
                case TILE:
                    drawTiled(g2d);
                    break;
                case CENTER:
                    drawCentered(g2d);
                    break;
                case FIT:
                    drawFit(g2d);
                    break;
            }
        }
    }

    private void drawTiled(Graphics2D g2d) {
        for (int y = 0; y < getHeight(); y += backgroundImage.getHeight()) {
            for (int x = 0; x < getWidth(); x += backgroundImage.getWidth()) {
                g2d.drawImage(backgroundImage, x, y, this);
            }
        }
    }

    private void drawCentered(Graphics2D g2d) {
        int x = (getWidth() - backgroundImage.getWidth()) / 2;
        int y = (getHeight() - backgroundImage.getHeight()) / 2;
        g2d.drawImage(backgroundImage, x, y, this);
    }

    private void drawFit(Graphics2D g2d) {
        double panelAspect = (double) getWidth() / getHeight();
        double imageAspect = (double) backgroundImage.getWidth() / backgroundImage.getHeight();

        int drawWidth, drawHeight, x, y;

        if (panelAspect > imageAspect) {
            drawHeight = getHeight();
            drawWidth = (int) (drawHeight * imageAspect);
        } else {
            drawWidth = getWidth();
            drawHeight = (int) (drawWidth / imageAspect);
        }

        x = (getWidth() - drawWidth) / 2;
        y = (getHeight() - drawHeight) / 2;

        g2d.drawImage(backgroundImage, x, y, drawWidth, drawHeight, this);
    }

    public void setBackgroundImage(String imagePath) {
        loadImage(imagePath);
    }

    public void setScaleMode(ScaleMode mode) {
        this.scaleMode = mode;
        repaint();
    }
}
