package _test.t2.Frame.Frame2_OpenMoreFrames;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        MyFrame[] myFrame = new MyFrame[2];
        myFrame[0] = new MyFrame(100, 100, 500, 500, new Color(0xB4FFFF));
        myFrame[1] = new MyFrame(600, 100, 500, 500, new Color(0x4C4CFF));
        Panel panel = new Panel();
        panel.setVisible(true);
        panel.setBackground(Color.darkGray);
        panel.setBounds(100,100, 200, 200);
        myFrame[0].add(panel);
    }
}
class MyFrame extends Frame{
    static int id;
    public MyFrame(int x, int y, int w, int h, Color color){
        super("id = " + (++id));
        setLayout(null);
        setBackground(color);
        setBounds(x, y, w, h);
        setVisible(true);
    }
}
