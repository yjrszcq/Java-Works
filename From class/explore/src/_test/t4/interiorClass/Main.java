package _test.t4.interiorClass;
//内部类
public class Main {
    public static void main(String[] args) {
        T1 t = new T1();
        T1.t1();
        t.s();
        T1.T2.t22();
        T1.T2 text = new T1.T2();
        text.t2();
    }
}
class T1{
    public static void t1(){
        System.out.println("t1");
    }
    static class T2{
        public static void t22(){
            System.out.println("t22");
        }

        public void t2(){
            System.out.println("t2");
        }
    }
    public void s(){
        T2 text2 = new T2();
        text2.t2();
        class T3{
           public void t3(){
               System.out.println("t3");
           }
        }
        T3 text3 = new T3();
        text3.t3();
    }
}