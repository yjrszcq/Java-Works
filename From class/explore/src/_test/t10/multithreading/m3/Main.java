package _test.t10.multithreading.m3;

public class Main {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
    }
}
class MyThread extends Thread{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}