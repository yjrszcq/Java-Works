package _test.t2.Frame.Frame4_Layout;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//p0,p1第一层
//p2,p3第二层
public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame("test panel");
        frame.setLayout(new GridLayout(2, 1));
        frame.setBackground(Color.white);
        frame.setBounds(100, 100, 768, 512);
        frame.setVisible(true);
        Panel[] panels = new Panel[4];
        Button[] buttons = new Button[10];
        for(int n0 = 0; n0 < 10; n0 ++){
            buttons[n0] = new Button(n0 + "");
            if(n0 < 4){
                panels[n0] = new Panel();
                panels[n0].setBackground(Color.black);
                panels[n0].setVisible(true);
            }
        }
        panels[2].setLayout(new GridLayout(2, 1));
        panels[2].add(buttons[0]);
        panels[2].add(buttons[1]);
        panels[0].setLayout(new BorderLayout());
        panels[0].add(buttons[2], BorderLayout.WEST);
        panels[0].add(panels[2], BorderLayout.CENTER);
        panels[0].add(buttons[3], BorderLayout.EAST);
//        panels[0].setLayout(new GridLayout(1, 3));
//        panels[0].add(buttons[2]);
//        panels[0].add(panels[2]);
//        panels[0].add(buttons[3]);
        panels[3].setLayout(new GridLayout(2, 2));
        for (int i = 4; i < 8; i++) {
            panels[3].add(buttons[i]);
        }
        panels[1].setLayout(new BorderLayout());
          panels[1].add(buttons[8], BorderLayout.WEST);
          panels[1].add(panels[3], BorderLayout.CENTER);
          panels[1].add(buttons[9], BorderLayout.EAST);
//        panels[1].setLayout(new GridLayout(1, 3));
//        panels[1].add(buttons[8]);
//        panels[1].add(panels[3]);
//        panels[1].add(buttons[9]);
        frame.add(panels[0]);
        frame.add(panels[1]);
//        frame.pack();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
