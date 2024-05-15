package _test.t6.array.copy;

public class Main {
    public static void main(String[] args) {
        int[] a = {12, 3, 4, 1, 18, 6, 9, 33, 22};
        int[] b = new int[a.length];
        System.arraycopy(a,0, b, 0, a.length);
        for(int i : b){
            System.out.println(i);
        }
    }
}
