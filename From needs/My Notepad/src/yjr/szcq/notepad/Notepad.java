package yjr.szcq.notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Notepad extends JFrame{
    JTextArea jTextArea = new JTextArea(20,50);
    JTextField jTextField = new JTextField("D:\\New Text.txt");
    JTextField fontSize = new JTextField(16 + "");

    public Notepad(){
        super("My Notepad");

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        jTextArea.setFont(new java.awt.Font("Microsoft YaHei", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(jTextArea);

        MyListener myListener = new MyListener(this);

        JLabel[] jLabel = new JLabel[4];
        jLabel[0] = new JLabel(" NOTICE: If the \"Path\" points to a definite 'txt' filename, even if the file does not exist, you don't need to \"Create\", otherwise you need to \"Create\" ");
        jLabel[1] = new JLabel(" Path ");
        jLabel[2] = new JLabel(" Font Size ");
        jLabel[3] = new JLabel(" Auto Wrap ");

        JPanel[] jPanel = new JPanel[6];
        jPanel[0] = new JPanel();
        jPanel[1] = new JPanel();
        jPanel[2] = new JPanel();
        jPanel[3] = new JPanel();
        jPanel[4] = new JPanel();
        jPanel[5] = new JPanel();
        jPanel[0].setLayout(new BorderLayout());
        jPanel[1].setLayout(new BorderLayout());
        jPanel[2].setLayout(new GridLayout(1, 3));
        jPanel[3].setLayout(new GridLayout(1, 3));
        jPanel[4].setLayout(new BorderLayout());
        jPanel[5].setLayout(new GridLayout(1, 3));

        JButton[] jButton = new JButton[6];
        jButton[0] = new JButton("Create");
        jButton[1] = new JButton("Read");
        jButton[2] = new JButton("Save");
        jButton[3] = new JButton("OK");
        jButton[4] = new JButton("ON");
        jButton[5] = new JButton("OFF");
        jButton[0].addActionListener(myListener);
        jButton[1].addActionListener(myListener);
        jButton[2].addActionListener(myListener);
        jButton[3].addActionListener(myListener);
        jButton[4].addActionListener(myListener);
        jButton[5].addActionListener(myListener);
        //上方
        jPanel[0].add(jLabel[0], BorderLayout.NORTH);
        jPanel[0].add(jPanel[1], BorderLayout.SOUTH);
        //上方  文件路径及字体
        jPanel[1].add(jLabel[1], BorderLayout.WEST);
        jPanel[1].add(jTextField, BorderLayout.CENTER);
        jPanel[1].add(jPanel[3], BorderLayout.EAST);
        //下方  按钮
        jPanel[2].add(jButton[0]);
        jPanel[2].add(jButton[1]);
        jPanel[2].add(jButton[2]);
        //上方  字体大小
        jPanel[3].add(jLabel[2]);
        jPanel[3].add(fontSize);
        jPanel[3].add(jButton[3]);
        //下方
        jPanel[4].add(jPanel[2], BorderLayout.CENTER);
        jPanel[4].add(jPanel[5], BorderLayout.EAST);
        //下方  自动换行
        jPanel[5].add(jLabel[3]);
        jPanel[5].add(jButton[4]);
        jPanel[5].add(jButton[5]);

        container.add(jPanel[0], BorderLayout.NORTH);
        container.add(scrollPane, BorderLayout.CENTER);
        container.add(jPanel[4], BorderLayout.SOUTH);

        this.setVisible(true);
        this.setBounds(100,100,900,650);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        new Notepad();
    }
}
class MyListener implements ActionListener{
    Notepad notepad;
    public MyListener(Notepad notepad){
        this.notepad = notepad;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case "Create": {
                create(notepad, 0);
                break;
            }
            case "Read": {
                create(notepad, 1);
                read(notepad);
                break;
            }
            case "Save": {
                create(notepad, 2);
                save(notepad);
                break;
            }
            case "OK": {
                int size = Integer.parseInt(notepad.fontSize.getText());
                notepad.jTextArea.setFont(new java.awt.Font("Microsoft YaHei", Font.PLAIN, size));
                break;
            }
            case "ON": {
                notepad.jTextArea.setLineWrap(true);
                notepad.jTextArea.setWrapStyleWord(true);
                break;
            }
            case "OFF": {
                notepad.jTextArea.setLineWrap(false);
                notepad.jTextArea.setWrapStyleWord(false);
                break;
            }
            default: System.out.println("ERROR: Undefined button");
        }
    }
    static int i = 0;
    public static void create(Notepad notepad, int jud){
        int j = 1;
        try {
            if(jud == 0){
                notepad.jTextArea.setText("");
            }
            String path = notepad.jTextField.getText();
            File file = new File(path);
            if(!file.exists()){
                if(path.contains(".txt")){
                    file.createNewFile();
                }else {
                    notepad.jTextField.setText(path + ".txt");
                    j = 0;
                }

            }else{
                if(jud == 0){
                    StringBuilder tempPath = new StringBuilder(file.getPath());
                    int index=tempPath.indexOf(".txt");
                    int n = -1;
                    for(int temp = i; temp > 0; n ++){
                        temp /= 10;
                    }
                    if(tempPath.indexOf(".txt") != -1){
                        if(tempPath.substring(index - 2 - (n + 1)).equals("(" + i + ").txt")){
                            tempPath.replace(index - 2 - (n + 1), index , "(" + (++ i) + ")");
                        }else{
                            i = 0;
                            tempPath.insert(index, "(" + (++i) + ")");
                        }
                    }else {
                        j = 0;
                    }
                    String tPath = tempPath.toString();
                    notepad.jTextField.setText(tPath);
                }
            }
        } catch (IOException ex) {
            j = 0;
            throw new RuntimeException(ex);
        } finally {
            if(jud == 0 && j == 0){
                System.out.println("Create failed");
                notepad.jTextArea.setText("ERROR: Create failed");
            }else if(jud == 1 && j == 0){
                System.out.println("Read failed");
                notepad.jTextArea.setText("ERROR: Read failed");
            }else if(jud == 2 && j == 0){
                System.out.println("Save failed");
                notepad.jTextArea.setText("ERROR: Save failed");
            }
        }
    }
    public static void save(Notepad notepad){
        int j = 1;
        try {
            FileWriter write = new FileWriter(notepad.jTextField.getText());
            BufferedWriter bw = new BufferedWriter(write);
            bw.write(notepad.jTextArea.getText());
            bw.close();
        }catch(IOException e){
            j = 0;
            e.printStackTrace();
        }finally {
            if(j == 0){
                System.out.println("Save failed");
                notepad.jTextArea.setText("ERROR: Save failed");
            }
        }
    }
    public static void read(Notepad notepad){
        int j = 1;
        try{
            FileReader file=new FileReader(notepad.jTextField.getText());
            BufferedReader br=new BufferedReader(file);
            String str;
            String content = null;
            while((str = br.readLine())!= null) {
                content += str + "\n";
            }
            if(content != null){
                StringBuilder temp = new StringBuilder(content);
                temp.replace(0, 4, "");
                String t = temp.toString();
                notepad.jTextArea.setText(t);
            }else {
                notepad.jTextArea.setText(null);
            }
            file.close();
        } catch (FileNotFoundException e) {
            j = 0;
            throw new RuntimeException(e);
        } catch (IOException e) {
            j = 0;
            throw new RuntimeException(e);
        } finally {
            if(j == 0){
                System.out.println("Read failed");
                notepad.jTextArea.setText("ERROR: Read failed");
            }
        }
    }
}