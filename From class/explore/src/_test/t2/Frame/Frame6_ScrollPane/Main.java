package _test.t2.Frame.Frame6_ScrollPane;

import javax.swing.*;
import java.awt.*;
public class Main extends JFrame{
    public Main(){
        Container container = this.getContentPane();

        JTextArea textArea = new JTextArea(20,50);
        textArea.setText("欢迎学习狂神说Java");

        JScrollPane scrollPane = new JScrollPane(textArea);
        container.add(scrollPane);

        this.setVisible(true);
        this.setBounds(100,100,300,350);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        new Main();
    }
}
