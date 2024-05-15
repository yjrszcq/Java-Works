package _test.t9.io.binaryFile;

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
            FileOutputStream output = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(output);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(sc.next());
            bw.close();

            FileInputStream input = new FileInputStream(file);
            InputStreamReader osr = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(osr);
            String str;
            while((str = br.readLine()) != null){
                System.out.println(str);
            }
            br.close();

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

}
