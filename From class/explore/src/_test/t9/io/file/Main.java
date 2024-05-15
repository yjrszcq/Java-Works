package _test.t9.io.file;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            File file = new File("");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write((sc.next()));
            bw.close();

            FileReader reader = new FileReader((file));
            BufferedReader br = new BufferedReader(reader);
            String str;
            while((str = br.readLine()) != null ){
                System.out.print(str + "\n");
            }
            br.close();
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
