# Background Image Integration Guide

## 📋 Quick Setup (3 Steps)

### Step 1: Save Your Background Image
Create a `resources` folder in your project root and save your image as `library_bg.jpg`:
```
project-root/
├── resources/
│   └── library_bg.jpg
├── src/
└── ...
```

### Step 2: Add the Java Classes
Copy these three files to your `src/gui/` folder:
- `BackgroundPanel.java` - Core background rendering
- `BackgroundImageUtil.java` - Utility methods
- `EnhancedDashboard.java` - Example implementation

### Step 3: Update Your Existing GUI Classes
Choose your integration method based on your current architecture.

---

## 🎯 Integration Examples

### Example 1: Simple Frame Background
```java
import gui.BackgroundImageUtil;

public class LoginForm extends JFrame {
    public LoginForm() {
        setTitle("Library Login");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Apply background image
        BackgroundImageUtil.applyBackground(this, "resources/library_bg.jpg");
        
        // Your components will appear on top
        setVisible(true);
    }
}
```

### Example 2: Background with Overlay (Better Readability)
```java
public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Dashboard");
        setSize(1200, 700);
        
        // Apply background with semi-transparent dark overlay
        BackgroundImageUtil.applyBackgroundWithOverlay(
            this,
            "resources/library_bg.jpg",
            new Color(0, 0, 0),  // Black overlay
            0.3f                 // 30% opacity
        );
        
        setVisible(true);
    }
}
```

### Example 3: Panel with Different Scale Modes
```java
import gui.BackgroundPanel;

public class CustomPanel extends JPanel {
    private BackgroundPanel bgPanel;
    
    public CustomPanel() {
        setLayout(new BorderLayout());
        
        // Create background with FIT mode (maintains aspect ratio)
        bgPanel = new BackgroundPanel("resources/library_bg.jpg", 
                BackgroundPanel.ScaleMode.FIT);
        
        add(bgPanel, BorderLayout.CENTER);
    }
    
    // Change scale mode dynamically if needed
    public void changeScaleMode(BackgroundPanel.ScaleMode mode) {
        bgPanel.setScaleMode(mode);
    }
}
```

### Example 4: Multiple Panels with Different Backgrounds
```java
public class TabbedInterface extends JFrame {
    public TabbedInterface() {
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // Tab 1: With background image
        JPanel tab1 = new JPanel();
        BackgroundImageUtil.applyBackground(tab1, "resources/library_bg.jpg");
        tabbedPane.addTab("Dashboard", tab1);
        
        // Tab 2: Custom background
        JPanel tab2 = new JPanel();
        BackgroundImageUtil.applyBackground(tab2, "resources/books_bg.jpg",
                BackgroundPanel.ScaleMode.TILE);
        tabbedPane.addTab("Books", tab2);
        
        add(tabbedPane);
    }
}
```

---

## 🎨 Scale Modes Explained

| Mode | Description | Best For |
|------|-------------|----------|
| **STRETCH** | Fills entire area, may distort | Fullscreen backgrounds |
| **TILE** | Repeats image | Pattern backgrounds |
| **CENTER** | Centers without scaling | Small images/logos |
| **FIT** | Maintains aspect ratio | Any image, professional look |

---

## 🌈 Color Scheme Integration

### Professional Library Theme
```java
// Gold accents (like in your image)
Color GOLD = new Color(255, 215, 0);

// Professional blue (library theme)
Color DARK_BLUE = new Color(0, 51, 102);
Color LIGHT_BLUE = new Color(200, 220, 255);

// Create themed labels
JLabel titleLabel = new JLabel("Loboc National High School");
titleLabel.setForeground(GOLD);
titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
```

### Overlay Recommendations
```java
// Dark overlay for light backgrounds (30-40% opacity)
BackgroundImageUtil.applyBackgroundWithOverlay(frame, imagePath,
    new Color(0, 0, 0), 0.35f);

// Light overlay for dark backgrounds (20-30% opacity)
BackgroundImageUtil.applyBackgroundWithOverlay(frame, imagePath,
    new Color(255, 255, 255), 0.25f);

// Semi-transparent colored overlay
BackgroundImageUtil.applyBackgroundWithOverlay(frame, imagePath,
    new Color(0, 51, 102), 0.2f);  // Dark blue tint
```

---

## 📊 Update Existing Classes

### Before (Old Dashboard):
```java
public class Dashboard extends JFrame {
    public Dashboard() {
        setContentPane(new JPanel());
        // ... rest of code
    }
}
```

### After (With Background):
```java
public class Dashboard extends JFrame {
    public Dashboard() {
        // Apply background first
        BackgroundImageUtil.applyBackgroundWithOverlay(this, 
            "resources/library_bg.jpg",
            new Color(0, 0, 0), 0.3f);
        
        // Add your components as overlay
        JPanel overlay = (JPanel) getContentPane();
        overlay.add(createHeader(), BorderLayout.NORTH);
        overlay.add(createContent(), BorderLayout.CENTER);
    }
}
```

---

## ⚡ Performance Tips

1. **Image Size**: Keep background image ≤ 2MB
   - Recommended: 1920x1080 or 1280x720
   - Format: JPG (better compression than PNG)

2. **Caching**: Load image once, reuse across frames
```java
public class ImageCache {
    private static BackgroundPanel cached;
    
    public static BackgroundPanel getBackground(String path) {
        if (cached == null) {
            cached = new BackgroundPanel(path);
        }
        return cached;
    }
}
```

3. **Lazy Loading**: Load on demand
```java
BackgroundImageUtil.applyBackground(frame, imagePath);
// Image loads only when needed
```

---

## 🐛 Troubleshooting

### Image not showing?
```java
// Check if file exists
if (BackgroundImageUtil.backgroundImageExists("resources/library_bg.jpg")) {
    System.out.println("Image found!");
} else {
    System.out.println("Image not found - check path and file name");
}
```

### Check image dimensions
```java
Dimension dims = BackgroundImageUtil.getImageDimensions("resources/library_bg.jpg");
if (dims != null) {
    System.out.println("Image size: " + dims.width + "x" + dims.height);
}
```

### Content not visible on background?
- Use overlay with opacity: `BackgroundImageUtil.applyBackgroundWithOverlay(...)`
- Increase overlay opacity (0.3f → 0.5f)
- Use LIGHT_BLUE text color on dark backgrounds

### Image pixelated or blurry?
- Use `ScaleMode.FIT` instead of `STRETCH`
- Ensure image resolution is ≥ 1280x720
- Graphics2D uses high-quality rendering by default

---

## 📝 Complete Working Example

See `EnhancedDashboard.java` for a fully working implementation with:
- Professional header with gold text
- Statistics cards with custom styling
- Semi-transparent overlay
- Responsive layout
- Color-coded information cards

Run it directly to preview the background integration!

---

## 🔧 File Structure

```
src/
├── gui/
│   ├── BackgroundPanel.java          ← Core background class
│   ├── BackgroundImageUtil.java      ← Utility methods
│   ├── EnhancedDashboard.java        ← Example/template
│   ├── Dashboard.java                ← Update existing classes
│   ├── LoginForm.java                ← Update existing classes
│   └── MainMenu.java                 ← Update existing classes
resources/
└── library_bg.jpg                    ← Your background image
```

---

## ✅ Checklist for Integration

- [ ] Image saved to `resources/library_bg.jpg`
- [ ] Three Java files copied to `src/gui/`
- [ ] Existing GUI classes updated with background code
- [ ] Image path verified in integration code
- [ ] Tested on main frames (LoginForm, Dashboard, MainMenu)
- [ ] Overlay opacity adjusted for readability
- [ ] Color scheme matches Loboc NHS branding

---

## 📚 Additional Resources

For more customization:
- Modify opacity in `createOverlayPanel()` for readability
- Change colors in color constants
- Adjust border/padding values
- Create multiple background themes

Happy coding! 🎓📚
