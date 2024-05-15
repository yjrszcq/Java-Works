package STData;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    Student stu = new Student();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("请选择功能：");
        System.out.println("1.录入 2.输出");
        n = sc.nextInt();
        switch(n){
            case 1: input();break;
            case 2: output();break;
            default: System.out.println("ERROR");
        }
    }
    public static void input(){
        Scanner sc = new Scanner(System.in);
        Student[] stu = new Student[999];
        System.out.println("请输入学生个数：");
        int n = sc.nextInt();
        System.out.println("请输入学生信息：");
        System.out.println("学号  姓名  班号  语文  英语  数学");
        for(int n0 = 0 ;n0 < n ;n0 ++){
            stu[n0] = new Student();
            stu[n0].number = sc.nextInt();
            stu[n0].name = sc.next();
            stu[n0].classNum = sc.nextInt();
            stu[n0].Chinese = sc.nextInt();
            stu[n0].English = sc.nextInt();
            stu[n0].Math = sc.nextInt();
            stu[n0].IN();
        }
    }
    public static void output(){
        try{
            FileReader file=new FileReader("E:\\student.txt");
            BufferedReader br=new BufferedReader(file);
            String str;
            while((str = br.readLine())!= null) {
                String[] parts = str.split(" ");
                String name = parts[1];
                int Chinese = Integer.parseInt(parts[3]);
                int English = Integer.parseInt(parts[4]);
                int Math = Integer.parseInt(parts[5]);
                System.out.println(name + " " + (Chinese+English+Math)/3);


            }
            file.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}