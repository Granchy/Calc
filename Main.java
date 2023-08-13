package Calculator;

import java.awt.*;
import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
        });
    }
}