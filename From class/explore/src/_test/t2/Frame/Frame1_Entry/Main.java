package _test.t2.Frame.Frame1_Entry;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame("Frame 1");
        Panel panel = new Panel();
        frame.setLayout(null);
        frame.setBackground(Color.blue);
        frame.setBounds(100, 100, 500, 500);
        frame.setVisible(true);
        panel.setBackground(Color.darkGray);
        panel.setBounds(50, 50, 400, 400);
        panel.setVisible(true);
        frame.add(panel);
    }
}
