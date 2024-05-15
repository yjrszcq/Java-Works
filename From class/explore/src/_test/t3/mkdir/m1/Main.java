package _test.t3.mkdir.m1;
import java.io.*;
import java.util.Scanner;

public class Main {
    static public void main(String[] args){
        System.out.println("1.创建 2.删除");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()){
            case 1 -> {
                File dir0 = new File("D:\\。");
                if(!dir0.exists()){
                    dir0.mkdir();
                }
                for (int i = 0; i < 10; i++) {
                    File dir = new File("D:\\。\\" + (i + 1));
                    dir.mkdir();
                }
            }
            case 2 -> {
                File dir0 = new File("D:\\。");
                if(dir0.exists()){
                    dir0.delete();
                }
            }
        }
    }
}
