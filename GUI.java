package Calculator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class GUI implements ActionListener {

    static int displayX = 10;
    static int displayY = 10;

    private JFrame frame; // Use a JFrame object to encapsulate JFrame methods.
    private JPanel panel;

    private CalcPanel calc;

    public JButton button0;
    public JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonDot;

    private JButton buttonClear;
    private JButton buttonNegate;
    private JButton buttonPercentage;

    private JButton buttonAdd;
    private JButton buttonSubtract;
    private JButton buttonMultiply;
    private JButton buttonDivide;
    private JButton buttonEqual;

    private String someString = "0";
    private JLabel nums;

    private int newInt = 0;
    private int lastInt = 0;

    private double newDouble = 0;
    private double lastDouble = 0;

    private double sum = 0;
    private double quotient = 0;
    private double difference = 0;
    private double product = 0;

    boolean replace = false;

    boolean add = false;
    boolean subtract = false;
    boolean divide = false;
    boolean multiply = false;

    private String dot = "";

    public GUI() {
        initialize();
    }

    private void initialize() { // Private method such that it cannot accessed outside of the class.

        // Create and set up the main window
        frame = new JFrame("Calc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);

        panel = new JPanel();

        calc = new CalcPanel();
        calc.setBounds(0, 0, 250, 500);

        nums = new JLabel(someString);

        nums.setForeground(Color.BLACK);
        nums.setBounds(8, 10, 230, 50); // Set the position and dimensions
        nums.setHorizontalAlignment(JLabel.RIGHT);
        nums.setFont(new Font("Comic Sans", Font.BOLD, 10));
        panel.add(nums);

        setNumberButtons();
        setArithmeticOperators();
        panel.add(calc);

        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(250, 500));

        // Set the content pane of the frame
        frame.setContentPane(panel);

        frame.pack();

        // Display the window
        frame.setVisible(true);
    }


//    private void setDisplay(Graphics g) {
//        g.setColor(Color.lightGray);
//        g.fillRect(displayX, displayY, 780, 50);
//
//    }

    private void setNumberButtons() {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 4; j++) {
//                JButton b = new JButton();
//                b.setBounds(displayX+i*60, 70+j*60,50,50);
//                b.setForeground(Color.black);
//                b.setFocusable(false);
//                if (i == 0 && j == 0)
//                if (i == 2 && j == 3) {
//                    b.setBackground(Color.CYAN);
//                    b.setText("=");
//                } else {
//                    b.setBackground(Color.lightGray);
//                }
//
//                panel.add(b);


//            }
//        }

        buttonClear = new JButton("C");
        buttonClear.setBounds(10, 70, 50, 50);
        buttonClear.setBackground(Color.gray);
        buttonClear.setFont(new Font("Comic Sans", Font.BOLD, 22));
        buttonClear.setFocusable(false);
        panel.add(buttonClear);

        buttonNegate = new JButton("+/-");
        buttonNegate.setBounds(10 + 60, 70, 50, 50);
        buttonNegate.setBackground(Color.gray);
        buttonNegate.setFont(new Font("Comic Sans", Font.BOLD, 13));
        buttonNegate.setFocusable(false);
        panel.add(buttonNegate);

        buttonPercentage = new JButton("%");
        buttonPercentage.setBounds(10 + 60 + 60, 70, 50, 50);
        buttonPercentage.setBackground(Color.gray);
        buttonPercentage.setFont(new Font("Comic Sans", Font.BOLD, 17));
        buttonPercentage.setFocusable(false);
        panel.add(buttonPercentage);


        button0 = new JButton("0");
        button0.setBounds(10, 70 + 60 + 60 + 60 + 60, 110, 50);
        button0.setBackground(Color.lightGray);
        button0.setFont(new Font("Comic Sans", Font.BOLD, 29));
        button0.setFocusable(false);
        panel.add(button0);

        button1 = new JButton("1");
        button1.setBounds(10, 70 + 60 + 60 + 60, 50, 50);
        button1.setBackground(Color.lightGray);
        button1.setFont(new Font("Comic Sans", Font.BOLD, 29));
        button1.setFocusable(false);
        panel.add(button1);

        button2 = new JButton("2");
        button2.setBounds(10 + 60, 70 + 60 + 60 + 60, 50, 50);
        button2.setBackground(Color.lightGray);
        button2.setFont(new Font("Comic Sans", Font.BOLD, 29));
        button2.setFocusable(false);
        panel.add(button2);

        button3 = new JButton("3");
        button3.setBounds(10 + 60 + 60, 70 + 60 + 60 + 60, 50, 50);
        button3.setBackground(Color.lightGray);
        button3.setFont(new Font("Comic Sans", Font.BOLD, 29));
        button3.setFocusable(false);
        panel.add(button3);

        button4 = new JButton("4");
        button4.setBounds(10, 70 + 60 + 60, 50, 50);
        button4.setBackground(Color.lightGray);
        button4.setFont(new Font("Comic Sans", Font.BOLD, 29));
        button4.setFocusable(false);
        panel.add(button4);

        button5 = new JButton("5");
        button5.setBounds(10 + 60, 70 + 60 + 60, 50, 50);
        button5.setBackground(Color.lightGray);
        button5.setFont(new Font("Comic Sans", Font.BOLD, 29));
        button5.setFocusable(false);
        panel.add(button5);

        button6 = new JButton("6");
        button6.setBounds(10 + 60 + 60, 70 + 60 + 60, 50, 50);
        button6.setBackground(Color.lightGray);
        button6.setFont(new Font("Comic Sans", Font.BOLD, 29));
        button6.setFocusable(false);
        panel.add(button6);

        button7 = new JButton("7");
        button7.setBounds(10, 70 + 60, 50, 50);
        button7.setBackground(Color.lightGray);
        button7.setFont(new Font("Comic Sans", Font.BOLD, 29));
        button7.setFocusable(false);
        panel.add(button7);

        button8 = new JButton("8");
        button8.setBounds(10 + 60, 70 + 60, 50, 50);
        button8.setBackground(Color.lightGray);
        button8.setFont(new Font("Comic Sans", Font.BOLD, 29));
        button8.setFocusable(false);
        panel.add(button8);

        button9 = new JButton("9");
        button9.setBounds(10 + 60 + 60, 70 + 60, 50, 50);
        button9.setBackground(Color.lightGray);
        button9.setFont(new Font("Comic Sans", Font.BOLD, 29));
        button9.setFocusable(false);
        panel.add(button9);

        buttonDot = new JButton(".");
        buttonDot.setBounds(10 + 60 + 60, 70 + 60 + 60 + 60 + 60, 50, 50);
        buttonDot.setBackground(Color.lightGray);
        buttonDot.setFont(new Font("Comic Sans", Font.BOLD, 50));
        buttonDot.setFocusable(false);
        panel.add(buttonDot);

        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonDot.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonPercentage.addActionListener(this);
        buttonNegate.addActionListener(this);


//        g.setFont(new Font("Times New Roman", Font.PLAIN, 50));
//        g.drawString("7",10+10 + 0*60, 110);
//        g.drawString("8",10+10 + 1*60, 110);
//        g.drawString("9",10+10 + 2*60, 110);
//        g.drawString("4",10+10 + 0*60, 110 + 60);
//        g.drawString("5",10+10 + 1*60, 110 + 60);
//        g.drawString("6",10+10 + 2*60, 110 + 60);
//        g.drawString("1",10+10 + 0*60, 110 + 60+60);
//        g.drawString("2",10+10 + 1*60, 110 + 60+60);
//        g.drawString("3",10+10 + 2*60, 110 + 60+60);
//        g.drawString("0",10+10 + 0*60, 110 + 60+60+60);
//        g.drawString(".",10+10 + 1*60, 110 + 60+60+60);
//        g.setFont(new Font("Times New Roman", Font.BOLD, 50));
//        g.drawString("=",10+10 + 2*60, 110 + 60+60+60);
    }

    private void setArithmeticOperators() {
        buttonAdd = new JButton("+");
        buttonAdd.setBounds(10 + 60 + 60 + 60, 70, 50, 50);
        buttonAdd.setBackground(new Color(171, 224, 212));
        buttonAdd.setFont(new Font("Comic Sans", Font.BOLD, 28));
        buttonAdd.setFocusable(false);
        panel.add(buttonAdd);

        buttonSubtract = new JButton("-");
        buttonSubtract.setBounds(10 + 60 + 60 + 60, 70 + 60, 50, 50);
        buttonSubtract.setBackground(new Color(171, 224, 212));
        buttonSubtract.setFont(new Font("Comic Sans", Font.BOLD, 28));
        buttonSubtract.setFocusable(false);
        panel.add(buttonSubtract);

        buttonMultiply = new JButton("×");
        buttonMultiply.setBounds(10 + 60 + 60 + 60, 70 + 60 + 60, 50, 50);
        buttonMultiply.setBackground(new Color(171, 224, 212));
        buttonMultiply.setFont(new Font("Comic Sans", Font.BOLD, 28));
        buttonMultiply.setFocusable(false);
        panel.add(buttonMultiply);

        buttonDivide = new JButton("÷");
        buttonDivide.setBounds(10 + 60 + 60 + 60, 70 + 60 + 60 + 60, 50, 50);
        buttonDivide.setBackground(new Color(171, 224, 212));
        buttonDivide.setFont(new Font("Comic Sans", Font.BOLD, 30));
        buttonDivide.setFocusable(false);
        panel.add(buttonDivide);

        buttonEqual = new JButton("=");
        buttonEqual.setBounds(10 + 60 + 60 + 60, 70 + 60 + 60 + 60 + 60, 50, 50);
        buttonEqual.setBackground(new Color(171, 224, 212));
        buttonEqual.setFont(new Font("Comic Sans", Font.BOLD, 28));
        buttonEqual.setFocusable(false);
        panel.add(buttonEqual);

        buttonEqual.addActionListener(this);
        buttonAdd.addActionListener(this);
        buttonSubtract.addActionListener(this);
        buttonMultiply.addActionListener(this);
        buttonDivide.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (nums.getText().length() == 8) {
            // If statement to prevent user from typing in too many characters.
        } else if (e.getSource() == button0) {
            if (dot.equals(".")) {
                nums.setText(nums.getText() + dot);
                dot = "";
            } else if (replace) {
                nums.setText("0");
                replace = false;
            } else if (nums.getText().equals("0")) {
                nums.setText("0");
            } else {
                nums.setText(nums.getText() + "0");
            }
        } else if (e.getSource() == button1) {
            if (dot.equals(".")) {
                nums.setText(nums.getText() + dot);
                dot = "";
            } else if (replace) {
                nums.setText("1");
                replace = false;
            } else if (nums.getText().equals("0")) {
                nums.setText("1");
            } else {
                nums.setText(nums.getText() + "1");
            }
        } else if (e.getSource() == button2) {
            if (dot.equals(".")) {
                nums.setText(nums.getText() + dot);
                dot = "";
            } else if (replace) {
                nums.setText("2");
                replace = false;
            } else if (nums.getText().equals("0")) {
                nums.setText("2");
            } else {
                nums.setText(nums.getText() + "2");
            }
        } else if (e.getSource() == button3) {
            if (dot.equals(".")) {
                nums.setText(nums.getText() + dot);
                dot = "";
            } else if (replace) {
                nums.setText("3");
                replace = false;
            } else if (nums.getText().equals("0")) {
                nums.setText("3");
            } else {
                nums.setText(nums.getText() + "3");
            }
        } else if (e.getSource() == button4) {
            if (dot.equals(".")) {
                nums.setText(nums.getText() + dot);
                dot = "";
            } else if (replace) {
                nums.setText("4");
                replace = false;
            } else if (nums.getText().equals("0")) {
                nums.setText("4");
            } else {
                nums.setText(nums.getText() + "4");
            }
        } else if (e.getSource() == button5) {
            if (dot.equals(".")) {
                nums.setText(nums.getText() + dot);
                dot = "";
            } else if (replace) {
                nums.setText("5");
                replace = false;
            } else if (nums.getText().equals("0")) {
                nums.setText("5");
            } else {
                nums.setText(nums.getText() + "5");
            }
        } else if (e.getSource() == button6) {
            if (dot.equals(".")) {
                nums.setText(nums.getText() + dot);
                dot = "";
            } else if (replace) {
                nums.setText("6");
                replace = false;
            } else if (nums.getText().equals("0")) {
                nums.setText("6");
            } else {
                nums.setText(nums.getText() + "6");
            }
        } else if (e.getSource() == button7) {
            if (dot.equals(".")) {
                nums.setText(nums.getText() + dot);
                dot = "";
            } else if (replace) {
                nums.setText("7");
                replace = false;
            } else if (nums.getText().equals("0")) {
                nums.setText("7");
            } else {
                nums.setText(nums.getText() + "7");
            }
        } else if (e.getSource() == button8) {
            if (dot.equals(".")) {
                nums.setText(nums.getText() + dot);
                dot = "";
            } else if (replace) {
                nums.setText("8");
                replace = false;
            } else if (nums.getText().equals("0")) {
                nums.setText("8");
            } else {
                nums.setText(nums.getText() + "8");
            }
        } else if (e.getSource() == button9) {
            if (dot.equals(".")) {
                nums.setText(nums.getText() + dot);
                dot = "";
            } else if (replace) {
                nums.setText("9");
                replace = false;
                add = false;
            } else if (nums.getText().equals("0")) {
                nums.setText("9");
            } else {
                nums.setText(nums.getText() + "9");
            }
        } else if (e.getSource() == buttonDot) {
            dot = ".";
        }

        if (e.getSource() == buttonClear) {
            nums.setText("0");
            add = false;
            sum = 0;
            subtract = false;
            difference = 0;
        } else if (e.getSource() == buttonEqual) {
            String tempString;
            if (divide) {
                quotient /= numsToDouble(nums.getText());
                tempString = removeEndDot(removeZeroes(String.valueOf(quotient)));
                nums.setText(tempString);
                divide = false;
                quotient = 0;
                replace = true;
            } else if (multiply) {
                product *= numsToDouble(nums.getText());
                tempString = removeEndDot(removeZeroes(String.valueOf(product)));
                if (add) {
                    tempString = removeEndDot(removeZeroes(String.valueOf(product + sum)));
                } else if (subtract) {
                    tempString = removeEndDot(removeZeroes(String.valueOf(difference - product)));
                }
                nums.setText(tempString);
                multiply = false;
                product = 0;
            } else if (add) {
                sum += numsToDouble(nums.getText());
                tempString = removeEndDot(removeZeroes(String.valueOf(sum)));
                nums.setText(tempString);
                sum = 0;
                add = false;
            } else if (subtract) {
                difference -= numsToDouble(nums.getText());
                tempString = removeEndDot(removeZeroes(String.valueOf(difference)));
                nums.setText(tempString);
                difference = 0;
                subtract = false;
            }
//            newDouble = numsToDouble(nums.getText());
//            String tempString = "";
//            if (add) {
//                lastDouble += newDouble;
//                newDouble = 0;
//            }
//            tempString = String.valueOf(lastDouble);
//            for (int i = tempString.length() - 1; i >= 0; i--) {
//                if (tempString.charAt(i) == '0') {
//                    tempString = removeZeroes(tempString);
//                } else {
//                    break;
//                }
//            }
//            tempString = removeEndDot(tempString);
//            nums.setText(tempString);
//            if (isDouble(nums.getText())) {
//                try {
//                    newDouble = Double.parseDouble(nums.getText());
//                } catch (NumberFormatException exception) {
//                    nums.setText("Error");
//                    System.out.println("Invalid double format");
//                }
//            } else {
//                try {
//                    newInt = Integer.parseInt(nums.getText());
//                } catch (NumberFormatException exception) {
//                    nums.setText("Error");
//                    System.out.println("Invalid integer format");
//                }
//            }
//            if (add) {
////                if (isDouble(nums.getText())) {
////                    nums.setText(String.valueOf(lastDouble + newDouble));
////
////                } else {
////                    nums.setText(String.valueOf(lastInt + newInt));
////                }
////                add = false;
//            }
            //TODO
        } else if (e.getSource() == buttonPercentage) {
            String tempString;
            BigDecimal bd = new BigDecimal(numsToDouble(nums.getText()) / 100.0);
            bd = bd.setScale(16, RoundingMode.HALF_UP);
            tempString = removeEndDot(removeZeroes(String.valueOf(bd)));
            nums.setText(tempString);
        } else if (e.getSource() == buttonAdd) {
            add();
//            if (isDouble(nums.getText())) {
//                lastDouble = numsToDouble(nums.getText());
//            } else {
//                lastInt = numsToInt(nums.getText());
//            }

        } else if (e.getSource() == buttonSubtract) {
            if (add || divide || multiply) {
                equals();
            }
        } else if (e.getSource() == buttonMultiply) {
            if (add) {
                if (!multiply) {
                    product = numsToDouble(nums.getText());
                    multiply = true;
                    replace = true;
                } else if (multiply) {
                    String tempString;
                    product *= numsToDouble(nums.getText());
                    tempString = removeEndDot(removeZeroes(String.valueOf(product)));
                    nums.setText(tempString);
                    replace = true;
                }
            } else {
                nums.setText(removeEndDot(removeZeroes(String.valueOf(product + sum))));
            }
        } else if (e.getSource() == buttonDivide) {
            String tempString;
            if (add) {
            }

        } else if (e.getSource() == buttonNegate) {
            if (numsToDouble(nums.getText()) < 0) {
                nums.setText(nums.getText().substring(1));
            } else if (numsToDouble(nums.getText()) > 0) {
                nums.setText("-" + nums.getText());
            }
        }
    }

    private String removeEndDot(String s) {
        if (s.charAt(s.length() - 1) == '.') {
            return s.substring(0, s.length() - 1);
        } else {
            return s;
        }
    }

    private String removeZeroes(String s) {
        if (s.equals("0")) {
            return s;
        } else if (s.length() > 0 && s.charAt(s.length() - 1) == '0') {
            s = s.substring(0, s.length() - 1);
            return removeZeroes(s);
        } else {
            return s;
        }
        // s.substring(0, index) goes from first index to 1 before the end index. s.substring(index + 1)
        // goes from index + 1 to the last index.
    }

    private BigDecimal convertToBig(int x) {
        //TODO: Create a method that converts large number inputs to BigDecimal such that they can be displayed on calculator.
        return new BigDecimal(-1);
    }

    private boolean isDouble(String s) {
        boolean isDouble = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                isDouble = true;
                break;
            }
        }
        return isDouble;
    }

    private double numsToDouble(String s) {
        double d = 0;
        try {
            d = Double.parseDouble(s);
        } catch (NumberFormatException exception) {
            nums.setText("Error");
            System.out.println("Invalid double format");
        }
        return d;
    }

    private int numsToInt(String s) {
        int i = 0;
        try {
            i = Integer.parseInt(s);
        } catch (NumberFormatException exception) {
            nums.setText("Error");
            System.out.println("Invalid integer format");
        }
        return i;
    }

    private void add() {
        sum += numsToDouble(nums.getText());
        String tempString = String.valueOf(sum);
        if (add) {
            tempString = removeEndDot(removeZeroes(tempString));
            nums.setText(tempString);
        }
        add = true;
        replace = true;
    }

    private double subtract(double x) {
        return difference - x;
//        String tempString;
//        if (!subtract) {
//            difference += numsToDouble(nums.getText());
//            replace = true;
//            subtract = true;
//        } else if (subtract) {
//            difference -= numsToDouble(nums.getText());
//            tempString = removeEndDot(removeZeroes(String.valueOf(difference)));
//            nums.setText(tempString);
//            replace = true;
//        }
    }

    private double multiply(double x) {
        return x * product;
//        String tempString;
//        if (!multiply) {
//            product = numsToDouble(nums.getText());
//            multiply = true;
//            replace = true;
//        } else if (multiply) {
//            product *= numsToDouble(nums.getText());
//            tempString = removeEndDot(removeZeroes(String.valueOf(product)));
//            nums.setText(tempString);
//            replace = true;
//        }
    }

    private double divide(double x) {
        return quotient / x;
//        String tempString;
//        if (!divide) {
//            quotient = numsToDouble(nums.getText());
//            replace = true;
//            divide = true;
//        } else if (divide) {
//            quotient /= numsToDouble(nums.getText());
//            tempString = removeEndDot(removeZeroes(String.valueOf(quotient)));
//            nums.setText(tempString);
//            replace = true;
//        }
    }

    private void equals() {
        String tempString;
        if (add) {
            sum += numsToDouble(nums.getText());
            tempString = removeEndDot(removeZeroes(String.valueOf(sum)));
            nums.setText(tempString);
            sum = 0;
            add = false;
        } else if (subtract) {
            difference -= numsToDouble(nums.getText());
            tempString = removeEndDot(removeZeroes(String.valueOf(difference)));
            nums.setText(tempString);
            difference = 0;
            subtract = false;
        } else if (divide) {
            quotient /= numsToDouble(nums.getText());
            tempString = removeEndDot(removeZeroes(String.valueOf(quotient)));
            nums.setText(tempString);
            divide = false;
            quotient = 0;
            replace = true;
        } else if (multiply) {
            product *= numsToDouble(nums.getText());
            tempString = removeEndDot(removeZeroes(String.valueOf(product)));
            nums.setText(tempString);
            multiply = false;
            product = 0;
        }
    }
}
