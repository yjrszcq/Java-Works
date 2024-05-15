package RandomNumberMiniGame;
import java.util.*;
public class Game {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("请输入数组长度：");
            int j = sc.nextInt();
            System.out.print('\n' + "请输入随机数的最大值（生成的随机数不超过这个值）：");
            int max = sc.nextInt();
            System.out.println();
            int[] a = new int[j];
            Random r = new Random();
            OUT:
            while(true){
                for(int n=0 ;n < a.length; n++){
                    a[n] = r.nextInt(max) + 1;
                }
                System.out.print("请输入一个1~" + max + "的数字: ");
                int i = sc.nextInt();
                for(int n = 0; n < a.length; n++){
                    if(i == a[n]){
                        System.out.println("你猜对了，它是数组中的第 " + (n+1) + " 个数字");
                        System.out.print("本次游戏，数组中全部数字为: ");
                        for(int n0 = 0; n0 < a.length; n0++){
                            System.out.print(a[n0]+" ");
                        }
                        break OUT;
                    }
                }
                System.out.print("你猜错了！" + '\n' + "本次游戏，数组中全部数字为: ");
                for(int n0 = 0; n0 < a.length; n0++){
                    System.out.print(a[n0]+" ");
                }
                System.out.println('\n' + "请重试！" + '\n');
            }
        }
    }
}
