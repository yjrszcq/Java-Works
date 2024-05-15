package _test.t7.inherit.implement;
import java.lang.*;

public class Main{
    public static void main(String[] args) {
        T t = new T();
        t.p();
        T.n();
        t.s();
    }
}
class T implements Text, Text2{
    public static void n(){
        int b = a +1;
        System.out.println(b);
    }

    @Override
    public void p() {
        System.out.println(a);
    }

    @Override
    public void s() {
        System.out.println(a + 2);
    }
}
 interface Text{
    int a = 1;
    void p();
}
interface  Text2{
    void s();
}
