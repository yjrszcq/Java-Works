package PassportCreate;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String library1 = "0123456789"; // 数字
        String library2 = "abcdefghijklmnopqrstuvwxyz"; // 小写字母
        String library3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 大写字母
        String library4 = "`~!@#$%^&*()-=[]\\;',./_+{}|:\"<>?"; // 所有符号
        String library5 = "~!@#$%^&*()_+"; // 常用符号
        String library = library1 + library2 + library3;
        System.out.println("请选择符号添加: 0.不添加符号 1.添加所有符号 2.添加常用符号");
        int jud = sc.nextInt();
        if(jud == 1){
            library += library4;
        }else if(jud == 2){
            library += library5;
        }
        Random random = new Random();
        System.out.println("请输入密码长度: ");
        int n = sc.nextInt();
        String password = "";
        for (int i = 0; i < n; i++) {
            int key = random.nextInt(library.length());
            password += library.charAt(key);
        }
        System.out.println(password);
    }
}
