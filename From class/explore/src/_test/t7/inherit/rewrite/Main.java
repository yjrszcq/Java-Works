package _test.t7.inherit.rewrite;

public class Main {
    public static void main(String[] args) {
        Text t1 = new Text();
        t1.s();
        Text t2 = new T();
        t2.s();


    }
}
class T extends Text{
    public void s(){
        System.out.println("later");
    }
}
class Text{
    public void s(){
        System.out.println("former");
    }
}