import java.awt.Color;

import javax.swing.JButton;

public class RedButton extends JButton {
    public RedButton(String text, Color color) {
        super(text);
        this.setBackground(color.RED);
    }
}
