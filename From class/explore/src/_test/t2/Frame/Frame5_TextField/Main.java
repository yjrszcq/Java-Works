package _test.t2.Frame.Frame5_TextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Notepad notepad = new Notepad();
        notepad.loadFrame();
        closeWindow(notepad);
    }
    public static void closeWindow(Notepad notepad){
        notepad.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
class Notepad extends JFrame{
    static int id;
    public Notepad(){
        super("Notepad -> " + (++id));
    }
    JTextArea jTextArea = new JTextArea();
    TextField textField = new TextField("D:\\New Text.txt");
//    Label notice = new Label("若路径指向确定文件，则不需要\"Create\"，否则需要\"Create\"");
    Label notice = new Label("Notice: If the \"Path\" points to a definite 'txt' filename, even if the file does not exist, you don't need to \"Create\", otherwise you need to \"Create\"");
    public void loadFrame(){
        setLayout(new BorderLayout());
        setBackground(Color.white);
        setBounds(300 + 50 * id, 100 + 50 * id, 768, 512);
        setVisible(true);
        Panel panel = new Panel();
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        JPanel panel3 = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        panel3.setLayout(new BorderLayout());
        panel3.setPreferredSize(new Dimension(400, 400));
        Button[] buttons = new Button[3];
        buttons[0] = new Button("Read");
        buttons[1] = new Button("Save");
        buttons[2] = new Button("Create");
        JScrollPane jScrollPane1 = new JScrollPane(jTextArea);
        JScrollPane jScrollPane2 = new JScrollPane(jTextArea);
        panel.add(buttons[2]);
        panel.add(buttons[0]);
        panel.add(buttons[1]);
        panel1.add(notice, BorderLayout.NORTH);
        panel1.add(panel2,BorderLayout.SOUTH);
        panel2.add(new Label("Path:"), BorderLayout.WEST);
        panel2.add(textField, BorderLayout.CENTER);
        panel3.add(jTextArea, BorderLayout.CENTER);
        panel3.add(jScrollPane1, BorderLayout.EAST);
        panel3.add(jScrollPane2, BorderLayout.SOUTH);
        jTextArea.setFont(new java.awt.Font("Microsoft YaHei", Font.PLAIN, 16));
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jScrollPane1.setBounds(13, 15, 300, 300);
        jScrollPane2.setBounds(13, 15, 300, 300);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(panel1, BorderLayout.NORTH);
        add(panel3, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        MyListener myListener = new MyListener(this);
        buttons[0].addActionListener(myListener);
        buttons[1].addActionListener(myListener);
        buttons[2].addActionListener(myListener);
    }
}

class MyListener implements ActionListener{
    boolean jud;
    Notepad notepad;
    public MyListener(Notepad notepad){
        this.notepad = notepad;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case "Create": {
                create(notepad, 0);
            }
            case "Read": {
                jud = true;
                create(notepad, 1);
                read(notepad);
                break;
            }
            case "Save": {
                jud = false;
                create(notepad, 2);
                save(notepad);
                break;
            }
            default: System.out.println("ERROR");
        }
    }
    public static void create(Notepad notepad, int jud){
        try {
            String path = notepad.textField.getText();
            File file = new File(path);
            if(!file.exists()){
                file.createNewFile();
            }else{
                if(jud == 0){
                    while (file.exists()) {
                        notepad.textField.setText(path + "New Text" + ".txt");
                        break;
                    }
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static void save(Notepad notepad){
        try {
            FileWriter write = new FileWriter(notepad.textField.getText());
            BufferedWriter bw = new BufferedWriter(write);
            bw.write(notepad.jTextArea.getText());
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void read(Notepad notepad){
        try{
            FileReader file=new FileReader(notepad.textField.getText());
            BufferedReader br=new BufferedReader(file);
            String str;
            String content = null;
            while((str = br.readLine())!= null) {
                content += str + "\n";
            }
            notepad.jTextArea.setText(content);
            file.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
