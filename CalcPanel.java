package Calculator;

import javax.swing.*;
import java.awt.*;

public class CalcPanel extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.lightGray);
        g.fillRect(GUI.displayX, GUI.displayY, 230, 50);
        this.setBackground(Color.black);
    }
}
