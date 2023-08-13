package Calculator;

import java.awt.*;
import javax.swing.*;


public class Main {

    public static void main(String[] args) {
//        double x = Double.parseDouble("80.0")/100.0;
//        System.out.println(x);
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
        });
    }
}
