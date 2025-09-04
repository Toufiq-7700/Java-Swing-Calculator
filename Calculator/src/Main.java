import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        new Calculator();
    }
}

class Calculator implements ActionListener{
    JFrame frame = new JFrame("Calculator");
    JTextField textfield = new JTextField();
    JButton n1 = new JButton("1");
    JButton n2 = new JButton("2");
    JButton n3 = new JButton("3");
    JButton n4 = new JButton("4");
    JButton n5 = new JButton("5");
    JButton n6 = new JButton("6");
    JButton n7 = new JButton("7");
    JButton n8 = new JButton("8");
    JButton n9 = new JButton("9");
    JButton n0 = new JButton("0");


    JButton add = new JButton("+");
    JButton sub = new JButton("-");
    JButton mul = new JButton("*");
    JButton div = new JButton("/");
    JButton equals = new JButton("=");
    JButton clear = new JButton("C");

    double num1, num2, result;
    char operator;

    Calculator() {

        textfield.setBounds(50, 25, 300, 50);
        textfield.setEditable(false);
        frame.add(textfield);


        n1.setBounds(50, 100, 60, 60);
        n1.addActionListener(this);
        frame.add(n1);

        n2.setBounds(110, 100, 60, 60);
        n2.addActionListener(this);
        frame.add(n2);

        n3.setBounds(170, 100, 60, 60);
        n3.addActionListener(this);
        frame.add(n3);

        n4.setBounds(50, 160, 60, 60);
        n4.addActionListener(this);
        frame.add(n4);

        n5.setBounds(110, 160, 60, 60);
        n5.addActionListener(this);
        frame.add(n5);

        n6.setBounds(170, 160, 60, 60);
        n6.addActionListener(this);
        frame.add(n6);

        n7.setBounds(50, 220, 60, 60);
        n7.addActionListener(this);
        frame.add(n7);

        n8.setBounds(110, 220, 60, 60);
        n8.addActionListener(this);
        frame.add(n8);

        n9.setBounds(170, 220, 60, 60);
        n9.addActionListener(this);
        frame.add(n9);

        n0.setBounds(50, 280, 60, 60);
        n0.addActionListener(this);
        frame.add(n0);

        add.setBounds(250, 100, 60, 60);
        sub.setBounds(250, 160, 60, 60);
        mul.setBounds(250, 220, 60, 60);
        div.setBounds(250, 280, 60, 60);
        equals.setBounds(110, 280, 60, 60);
        clear.setBounds(170, 280, 60, 60);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        equals.addActionListener(this);
        clear.addActionListener(this);

        add.setBackground(Color.LIGHT_GRAY);
        sub.setBackground(Color.LIGHT_GRAY);
        mul.setBackground(Color.LIGHT_GRAY);
        div.setBackground(Color.LIGHT_GRAY);
        equals.setBackground(Color.CYAN);
        clear.setBackground(Color.RED);

        frame.add(add);
        frame.add(sub);
        frame.add(mul);
        frame.add(div);
        frame.add(equals);
        frame.add(clear);

        frame.setSize(400, 450);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent input) {
        if (input.getSource() == n0) {
            textfield.setText(textfield.getText().concat("0"));
        } else if (input.getSource() == n1) {
            textfield.setText(textfield.getText().concat("1"));
        } else if (input.getSource() == n2) {
            textfield.setText(textfield.getText().concat("2"));
        } else if (input.getSource() == n3) {
            textfield.setText(textfield.getText().concat("3"));
        } else if (input.getSource() == n4) {
            textfield.setText(textfield.getText().concat("4"));
        } else if (input.getSource() == n5) {
            textfield.setText(textfield.getText().concat("5"));
        } else if (input.getSource() == n6) {
            textfield.setText(textfield.getText().concat("6"));
        } else if (input.getSource() == n7) {
            textfield.setText(textfield.getText().concat("7"));
        } else if (input.getSource() == n8) {
            textfield.setText(textfield.getText().concat("8"));
        } else if (input.getSource() == n9) {
            textfield.setText(textfield.getText().concat("9"));
        }

        if (input.getSource() == add || input.getSource() == sub ||
                input.getSource() == mul || input.getSource() == div) {
            num1 = Double.parseDouble(textfield.getText());
            operator = input.getActionCommand().charAt(0);
            textfield.setText("");
        }

        if (input.getSource() == equals) {
            calculateResult();
        }

        if (input.getSource() == clear) {
            clear();
        }
    }

    void calculateResult() {
        try {
            num2 = Double.parseDouble(textfield.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textfield.setText("can not divide by 0");
                        return;
                    }
                    break;
            }
            textfield.setText(String.format("%.2f", result));
        } catch (NumberFormatException checker) {
            textfield.setText("invalid input");
        }
    }

    void clear() {
        textfield.setText("");
        num1 = num2 = result = 0;
        operator = '0';
    }
}