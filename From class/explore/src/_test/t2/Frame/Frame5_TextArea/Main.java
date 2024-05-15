package _test.t2.Frame.Frame5_TextArea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.loadFrame();
        wListener(calculator);
    }
    public static void wListener (Calculator calculator){
        calculator.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
class Calculator extends Frame{
    TextField[] textFields = new TextField[3];
    public void loadFrame(){
        setName("Simple Calculator");
        setLayout(new BorderLayout());
        setBackground(Color.white);
        setBounds(100, 100, 500, 200);
        setVisible(true);
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        panel1.setLayout(new GridLayout(1, 5));
        panel2.setLayout(new GridLayout(4, 1));
        Button[] buttons = new Button[4];
        buttons[0] = new Button("+");
        buttons[1] = new Button("-");
        buttons[2] = new Button("*");
        buttons[3] = new Button("/");

        for (int i = 0; i < 3; i++) {
            textFields[i] = new TextField();
        }
        panel1.add(textFields[0]);
        panel1.add(panel2);
        panel1.add(textFields[1]);
        panel1.add(new Label("="));
        panel1.add(textFields[2]);
        for (int i = 0; i < 4; i++) {
            panel2.add(buttons[i]);
        }

        MyListener myListener = new MyListener(this);
        for (int i = 0; i < 4; i++) {
            buttons[i].addActionListener(myListener);
        }
        add(panel1, BorderLayout.CENTER);
    }
}
class MyListener implements ActionListener{
    Calculator calculator = null;
    public MyListener(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double t = 0;
        double numFormer = Double.parseDouble(calculator.textFields[0].getText());
        double numLater = Double.parseDouble(calculator.textFields[1].getText());

        switch (e.getActionCommand()) {
            case "+" -> {
                t = numFormer + numLater;
                print(t, calculator);
            }
            case "-" -> {
                t = numFormer - numLater;
                print(t, calculator);
            }
            case "*" -> {
                t = numFormer * numLater;
                print(t, calculator);
            }
            case "/" -> {
                if (numLater != 0) {
                    t = numFormer / numLater;
                    print(t, calculator);
                }else{
                    calculator.textFields[0].setText("");
                    calculator.textFields[1].setText("");
                    calculator.textFields[2].setText("ERROR");
                }
            }
        }
    }
    public void print(double t, Calculator calculator){
        calculator.textFields[0].setText("");
        calculator.textFields[1].setText("");
        calculator.textFields[2].setText(String.format("%.6f", t) + "");
    }
}