package _test.t10.multithreading.m2;

public class Main {
    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread thread = new Thread(myRun);
        thread.start();
    }
}
class MyRun implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 9; i++) {
            System.out.println(i);
        }
    }
}
