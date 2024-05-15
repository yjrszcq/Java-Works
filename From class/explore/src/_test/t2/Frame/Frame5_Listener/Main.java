package _test.t2.Frame.Frame5_Listener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame("test Monitor");
        Panel panel = new Panel();

        MyMonitor myMonitor = new MyMonitor();

        frame.setLayout(new GridLayout(1, 1));
        frame.setBackground(Color.white);
        frame.setBounds(100, 100, 500, 500);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(new GridLayout(2, 1));
        panel.setVisible(true);

        Button button1 = new Button("start");
        Button button2 = new Button("stop");
        //按键动作监听
        button1.addActionListener(myMonitor);
        button2.addActionListener(myMonitor);

        panel.add(button1);
        panel.add(button2);

        myListener(frame);
    }
    public static void myListener(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
class MyMonitor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "start": System.out.println("button start"); break;
            case "stop": System.out.println("button stop"); break;
            default: System.out.println("ERROR");
        }
    }
}