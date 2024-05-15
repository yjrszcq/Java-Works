package _test.t1.HashMap;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> books = new HashMap<>();
        books.put(1,1);
        books.put(2,2);
        books.put(4,3);
        books.put(6,4);
        String keys = null;
        for (int i : books.keySet()) {
            keys += "" + i;
        }
        System.out.println(Integer.parseInt(keys.substring(keys.length() - 1)));
    }
}
