package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private double sum = 0;
    private double quotient = 0;
    private double difference = 0;
    private double product = 0;
    private double result = 0;

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
        frame.setSize(250, 370);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);

        panel = new JPanel();

        calc = new CalcPanel();
        calc.setBounds(0, 0, 250, 370);

        nums = new JLabel(someString);

        nums.setForeground(Color.BLACK);
        nums.setBounds(8, 10, 230, 50); // Set the position and dimensions
        nums.setHorizontalAlignment(JLabel.RIGHT);
        nums.setFont(new Font("Comic Sans", Font.BOLD, 50));
        panel.add(nums);

        setNumberButtons();
        setArithmeticOperators();
        panel.add(calc);

        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(250, 370));

        // Set the content pane of the frame
        frame.setContentPane(panel);

        frame.pack();

        // Display the window
        frame.setVisible(true);
    }

    private void setNumberButtons() {

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
                nums.setText(nums.getText() + dot + "1");
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
                nums.setText(nums.getText() + dot + "2");
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
                nums.setText(nums.getText() + dot + "3");
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
                nums.setText(nums.getText() + dot + "4");
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
                nums.setText(nums.getText() + dot + "5");
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
                nums.setText(nums.getText() + dot + "6");
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
                nums.setText(nums.getText() + dot + "7");
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
                nums.setText(nums.getText() + dot + "8");
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
                nums.setText(nums.getText() + dot + "9");
                dot = "";
            } else if (replace) {
                nums.setText("9");
                replace = false;
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
            multiply = false;
            product = 0;
            divide = false;
            quotient = 0;
            result = 0;
        } else if (e.getSource() == buttonEqual) {
            replace = true;
            if (divide) {
                quotient /= numsToDouble(nums.getText());
                result += quotient;
                nums.setText(removeEndDot(removeZeroes(removeNums(String.valueOf(result)))));
            } else if (multiply) {
                product *= numsToDouble(nums.getText());
                result += product;
                nums.setText(removeEndDot(removeZeroes(removeNums(String.valueOf(result)))));
            } else if (add) {
                result += numsToDouble(nums.getText());
                nums.setText(removeEndDot(removeZeroes(removeNums(String.valueOf(result)))));
            } else if (subtract) {
                result -= numsToDouble(nums.getText());
                nums.setText(removeEndDot(removeZeroes(removeNums(String.valueOf(result)))));
            }
            add = false;
            sum = 0;
            subtract = false;
            difference = 0;
            multiply = false;
            product = 0;
            divide = false;
            quotient = 0;
            result = 0;
        } else if (e.getSource() == buttonPercentage) {
            String tempString;
            BigDecimal bd = new BigDecimal(numsToDouble(nums.getText()) / 100.0);
            bd = bd.setScale(16, RoundingMode.HALF_UP);
            tempString = removeEndDot(removeZeroes(removeNums(String.valueOf(bd))));
            nums.setText(tempString);
        } else if (e.getSource() == buttonAdd) {
            if (divide) {
                quotient /= numsToDouble(nums.getText());
                result = quotient;
                divide = false;
                if (!add) {
                    nums.setText(removeEndDot(removeZeroes(removeNums(String.valueOf(result)))));
                    sum += quotient;
                } else if (add) {
                    sum += numsToDouble(nums.getText());
                    result += sum;
                    nums.setText(removeEndDot(removeZeroes(removeNums(String.valueOf(result)))));
                }
            } else if (multiply) {
                product *= numsToDouble(nums.getText());
                result += product;
                multiply = false;
                nums.setText(removeEndDot(removeZeroes(removeNums(String.valueOf(result)))));
            } else if (subtract) {
                subtract = false;
                difference -= numsToDouble(nums.getText());
                result += difference;
                nums.setText(removeEndDot(removeZeroes(removeNums(String.valueOf(result)))));
            } else {
                if (!add) {
                    result += numsToDouble(nums.getText());
                } else if (add) {
                    result = numsToDouble(nums.getText());
                    nums.setText(removeEndDot(removeZeroes(removeNums(String.valueOf(result)))));
                }
            }
            add = true;
            replace = true;
        } else if (e.getSource() == buttonSubtract) {
            if (divide) {
                quotient /= numsToDouble(nums.getText());
                divide = false;
                result = quotient;
                nums.setText(removeEndDot(removeZeroes(removeNums(String.valueOf(result)))));
            } else if (multiply) {
                product *= numsToDouble(nums.getText());
                multiply = false;
                result += product;
                nums.setText(removeEndDot(removeZeroes(removeNums(String.valueOf(result)))));
            } else if (add) {
                add = false;
                result += numsToDouble(nums.getText());
                nums.setText(removeEndDot(removeZeroes(removeNums(String.valueOf(result)))));
            } else {
                if (!subtract) {
                    result += numsToDouble(nums.getText());
                } else {
                    result -= numsToDouble(nums.getText());
                    nums.setText(removeEndDot(removeZeroes(removeNums(String.valueOf(result)))));
                }
            }
            subtract = true;
            replace = true;
        } else if (e.getSource() == buttonMultiply) {
            if (add) {
                add = false;
                product = numsToDouble(nums.getText());
            } else if (subtract) {
                subtract = false;
                product = -numsToDouble(nums.getText());
            } else if (divide) {
                divide = false;
                quotient /= numsToDouble(nums.getText());
                product = quotient;
                nums.setText(removeEndDot(removeZeroes(removeNums(String.valueOf(quotient)))));
            } else {
                if (!multiply) {
                    product = numsToDouble(nums.getText());
                } else if (multiply) {
                    String tempString;
                    product *= numsToDouble(nums.getText());
                    tempString = removeEndDot(removeZeroes(removeNums(String.valueOf(product))));
                    nums.setText(tempString);
                }
            }
            multiply = true;
            replace = true;
        } else if (e.getSource() == buttonDivide) {
            if (add) {
                add = false;
                if (!divide) {
                    quotient = numsToDouble(nums.getText());
                } else if (divide) {
                    quotient /= numsToDouble(nums.getText());
                    nums.setText(removeEndDot(removeZeroes(removeNums(String.valueOf(quotient)))));
                }
            } else if (subtract) {
                subtract = false;
                quotient = -numsToDouble(nums.getText());
            } else if (multiply) {
                multiply = false;
                product *= numsToDouble(nums.getText());
                quotient = product;
                nums.setText(removeEndDot(removeZeroes(removeNums(String.valueOf(quotient)))));
            } else {
                if (!divide) {
                    quotient = numsToDouble(nums.getText());
                } else if (divide) {
                    quotient /= numsToDouble(nums.getText());
                    result = quotient;
                    nums.setText(removeEndDot(removeZeroes(removeNums(String.valueOf(result)))));
                }
            }
            divide = true;
            replace = true;
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

    private String removeNums(String s) {
        if (s.length() <= 8) {
            return s;
        } else if (s.length() > 8) {
            s = s.substring(0, s.length() - 1);
            return removeNums(s);
        } else {
            return s;
        }
        // s.substring(0, index) goes from first index to 1 before the end index. s.substring(index + 1)
        // goes from index + 1 to the last index.
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
}
