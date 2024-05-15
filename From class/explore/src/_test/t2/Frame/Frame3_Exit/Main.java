package _test.t2.Frame.Frame3_Exit;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        //窗口
        Frame frame = new Frame("test frame");
        frame.setLayout(null);  //布局
        frame.setBackground(Color.BLUE);
        frame.setBounds(100, 100, 500, 500);
        frame.setVisible(true);
        //面板
        Panel panel = new Panel();
        panel.setBackground(Color.darkGray);
        panel.setBounds(50, 50, 400, 400);
        panel.setVisible(true);
        frame.add(panel);
        //按钮布局
        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        panel.setLayout(new GridLayout(2, 1));
        panel.add(b1);
        panel.add(b2);

        //关闭面板监听
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
