package _test.t8.date.isLeaf;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        boolean a = Year.of(2002).isLeap();
        System.out.println(a);
    }
}
