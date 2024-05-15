package _test.t7.inherit.extend;


public class Main {
    public static void main(String[] args) {
        T t = new T();
        t.s();
    }
}
class T extends Text{
    public void s(){
        int b = a;
        p();
    }
}
class Text{
    int a = 1;
    public static void p(){
        System.out.println("former");
    }
}
