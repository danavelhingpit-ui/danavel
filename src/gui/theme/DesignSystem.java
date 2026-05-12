package gui.theme;

import javax.swing.*;
import java.awt.*;

/**
 * Central theme configuration for the Library Management System
 * All colors, fonts, and design tokens are defined here
 */
public class DesignSystem {

    // ==================== COLOR PALETTE ====================
    public static class Colors {
        // Primary Colors (Blue Theme - Professional Library)
        public static final Color PRIMARY_DARK = new Color(0, 51, 102);      // Dark Navy Blue
        public static final Color PRIMARY = new Color(25, 103, 210);         // Bright Blue
        public static final Color PRIMARY_LIGHT = new Color(200, 220, 255);  // Light Blue

        // Accent Colors (Gold - From School Branding)
        public static final Color ACCENT_GOLD = new Color(255, 215, 0);      // Gold
        public static final Color ACCENT_DARK_GOLD = new Color(184, 134, 11); // Dark Gold

        // Neutral Colors
        public static final Color BACKGROUND = new Color(245, 247, 250);     // Very Light Blue-Gray
        public static final Color SURFACE = new Color(255, 255, 255);        // White
        public static final Color SURFACE_VARIANT = new Color(238, 242, 250); // Light Gray-Blue

        // Text Colors
        public static final Color TEXT_PRIMARY = new Color(33, 33, 33);      // Dark Gray (Primary Text)
        public static final Color TEXT_SECONDARY = new Color(102, 102, 102); // Medium Gray (Secondary Text)
        public static final Color TEXT_TERTIARY = new Color(158, 158, 158);  // Light Gray (Tertiary Text)
        public static final Color TEXT_INVERSE = new Color(255, 255, 255);   // White (On dark backgrounds)

        // Status Colors
        public static final Color SUCCESS = new Color(76, 175, 80);          // Green
        public static final Color WARNING = new Color(255, 152, 0);          // Orange
        public static final Color ERROR = new Color(244, 67, 54);            // Red
        public static final Color INFO = new Color(33, 150, 243);            // Info Blue

        // Semantic Colors
        public static final Color AVAILABLE = new Color(76, 175, 80);        // Green - Book Available
        public static final Color BORROWED = new Color(255, 152, 0);         // Orange - Book Borrowed
        public static final Color OVERDUE = new Color(244, 67, 54);          // Red - Overdue
        public static final Color RESERVED = new Color(156, 39, 176);        // Purple - Reserved

        // Overlay & Transparency
        public static final Color OVERLAY_DARK = new Color(0, 0, 0);         // For dark overlays
        public static final Color OVERLAY_LIGHT = new Color(255, 255, 255);  // For light overlays
    }

    // ==================== TYPOGRAPHY ====================
    public static class Typography {
        private static final String FONT_FAMILY_PRIMARY = "Segoe UI";
        private static final String FONT_FAMILY_MONO = "Consolas";

        // Display & Headers
        public static final Font DISPLAY_LARGE = new Font(FONT_FAMILY_PRIMARY, Font.BOLD, 32);
        public static final Font DISPLAY_MEDIUM = new Font(FONT_FAMILY_PRIMARY, Font.BOLD, 28);
        public static final Font DISPLAY_SMALL = new Font(FONT_FAMILY_PRIMARY, Font.BOLD, 24);

        // Headings
        public static final Font HEADING_1 = new Font(FONT_FAMILY_PRIMARY, Font.BOLD, 22);
        public static final Font HEADING_2 = new Font(FONT_FAMILY_PRIMARY, Font.BOLD, 20);
        public static final Font HEADING_3 = new Font(FONT_FAMILY_PRIMARY, Font.BOLD, 18);
        public static final Font HEADING_4 = new Font(FONT_FAMILY_PRIMARY, Font.BOLD, 16);

        // Body Text
        public static final Font BODY_LARGE = new Font(FONT_FAMILY_PRIMARY, Font.PLAIN, 16);
        public static final Font BODY_MEDIUM = new Font(FONT_FAMILY_PRIMARY, Font.PLAIN, 14);
        public static final Font BODY_SMALL = new Font(FONT_FAMILY_PRIMARY, Font.PLAIN, 12);

        // Labels
        public static final Font LABEL_LARGE = new Font(FONT_FAMILY_PRIMARY, Font.BOLD, 14);
        public static final Font LABEL_MEDIUM = new Font(FONT_FAMILY_PRIMARY, Font.BOLD, 12);
        public static final Font LABEL_SMALL = new Font(FONT_FAMILY_PRIMARY, Font.BOLD, 11);

        // Special
        public static final Font BUTTON_TEXT = new Font(FONT_FAMILY_PRIMARY, Font.BOLD, 13);
        public static final Font CAPTION = new Font(FONT_FAMILY_PRIMARY, Font.PLAIN, 10);
        public static final Font MONOSPACE = new Font(FONT_FAMILY_MONO, Font.PLAIN, 12);
    }

    // ==================== SPACING ====================
    public static class Spacing {
        public static final int SPACING_2 = 2;
        public static final int SPACING_4 = 4;
        public static final int SPACING_8 = 8;
        public static final int SPACING_12 = 12;
        public static final int SPACING_16 = 16;
        public static final int SPACING_20 = 20;
        public static final int SPACING_24 = 24;
        public static final int SPACING_32 = 32;
        public static final int SPACING_48 = 48;

        // Common padding
        public static final int PADDING_SMALL = 8;
        public static final int PADDING_MEDIUM = 16;
        public static final int PADDING_LARGE = 24;

        // Common margins
        public static final int MARGIN_SMALL = 8;
        public static final int MARGIN_MEDIUM = 16;
        public static final int MARGIN_LARGE = 24;
    }

    // ==================== DIMENSIONS ====================
    public static class Dimensions {
        // Button Sizes
        public static final int BUTTON_HEIGHT_SMALL = 32;
        public static final int BUTTON_HEIGHT_MEDIUM = 40;
        public static final int BUTTON_HEIGHT_LARGE = 48;
        public static final int BUTTON_MIN_WIDTH = 100;

        // Card Sizes
        public static final int CARD_CORNER_RADIUS = 8;
        public static final int CARD_ELEVATION = 2;

        // Border Radius
        public static final int RADIUS_SMALL = 4;
        public static final int RADIUS_MEDIUM = 8;
        public static final int RADIUS_LARGE = 12;

        // Icon Sizes
        public static final int ICON_SMALL = 18;
        public static final int ICON_MEDIUM = 24;
        public static final int ICON_LARGE = 32;

        // Component Heights
        public static final int INPUT_HEIGHT = 40;
        public static final int ROW_HEIGHT = 48;
        public static final int HEADER_HEIGHT = 64;
        public static final int FOOTER_HEIGHT = 56;

        // Component Widths
        public static final int SIDEBAR_WIDTH = 280;
        public static final int SIDEBAR_WIDTH_COLLAPSED = 80;
    }

    // ==================== SHADOWS ====================
    public static class Shadows {
        public static final int ELEVATION_NONE = 0;
        public static final int ELEVATION_1 = 1;
        public static final int ELEVATION_2 = 2;
        public static final int ELEVATION_3 = 4;
        public static final int ELEVATION_4 = 8;
        public static final int ELEVATION_5 = 16;

        // Shadow configurations
        public static final float SHADOW_OPACITY = 0.15f;
    }

    // ==================== TRANSITIONS ====================
    public static class Transitions {
        public static final int DURATION_FAST = 150;      // ms - Quick interactions
        public static final int DURATION_MEDIUM = 300;    // ms - Standard animations
        public static final int DURATION_SLOW = 500;      // ms - Prominent animations
    }

    // ==================== OPACITY ====================
    public static class Opacity {
        public static final float FULL = 1.0f;
        public static final float HIGH = 0.87f;
        public static final float MEDIUM = 0.60f;
        public static final float LOW = 0.38f;
        public static final float DISABLED = 0.38f;
    }

    // ==================== UTILITY METHODS ====================

    /**
     * Apply alpha (transparency) to a color
     */
    public static Color withAlpha(Color color, float alpha) {
        return new Color(
            color.getRed() / 255f,
            color.getGreen() / 255f,
            color.getBlue() / 255f,
            Math.max(0, Math.min(1, alpha))
        );
    }

    /**
     * Blend two colors
     */
    public static Color blend(Color color1, Color color2, float ratio) {
        int r = (int) (color1.getRed() * ratio + color2.getRed() * (1 - ratio));
        int g = (int) (color1.getGreen() * ratio + color2.getGreen() * (1 - ratio));
        int b = (int) (color1.getBlue() * ratio + color2.getBlue() * (1 - ratio));
        return new Color(r, g, b);
    }

    /**
     * Lighten a color
     */
    public static Color lighten(Color color, float factor) {
        return new Color(
            Math.min(255, (int) (color.getRed() + (255 - color.getRed()) * factor)),
            Math.min(255, (int) (color.getGreen() + (255 - color.getGreen()) * factor)),
            Math.min(255, (int) (color.getBlue() + (255 - color.getBlue()) * factor))
        );
    }

    /**
     * Darken a color
     */
    public static Color darken(Color color, float factor) {
        return new Color(
            (int) (color.getRed() * (1 - factor)),
            (int) (color.getGreen() * (1 - factor)),
            (int) (color.getBlue() * (1 - factor))
        );
    }
}
