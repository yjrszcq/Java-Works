package _test.t6.array.fill;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[10];
        Arrays.fill(a, 9);
        for(int i : a){
            System.out.println(i);
        }
    }

}
