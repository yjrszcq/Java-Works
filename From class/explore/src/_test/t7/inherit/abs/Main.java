package _test.t7.inherit.abs;

public class Main {
    public static void main(String[] args) {
        Text t = new Text();
        t.s();
    }
}
class Text extends T{
    int b = a;
    @Override
    public void s() {
        System.out.println(b);
        p();
    }
}
abstract class T{
    int a = 0;
    public void p(){
        System.out.println("ddd");
    }
    public abstract void s();
}
