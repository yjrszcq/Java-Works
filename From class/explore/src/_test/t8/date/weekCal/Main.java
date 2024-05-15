package _test.t8.date.weekCal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入: 年 月 日");
        LocalDate date = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        DayOfWeek week = date.getDayOfWeek();
        System.out.println(week);
    }

}
