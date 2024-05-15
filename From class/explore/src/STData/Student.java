package STData;
import java.io.*;
public class Student {
    public int number;
    String name;
    int classNum;
    int Chinese;
    int English;
    int Math;
    public void IN(){
        try {
            File file = new File("E:\\student.txt");
            file.createNewFile();
            FileWriter write = new FileWriter("E:\\student.txt",true);
            BufferedWriter bw = new BufferedWriter(write);
            bw.write(number + " " + name + " " + classNum + " " + Chinese + " " + English + " " + Math + '\n');
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
