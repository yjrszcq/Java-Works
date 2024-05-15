package _test.t6.array.sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {12, 3, 4, 1, 18, 6, 9, 33, 22};
        Arrays.sort(a);//升序排序
        for(int i : a){
            System.out.println(i);
        }
    }
}
