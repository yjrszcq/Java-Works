package _test.t5.regularExpression;

public class Main {
    public static void main(String[] args) {
        String phoneNum = "18812345678";
        String qq = "012345";
        String password = "abc123456";
        boolean a = phoneNum.matches("1[35789][0-9]{9}");   //1开头，接一个“35789”中的数，接9个0到9的数
        boolean b = qq.matches("[^0][0-9]{4,9}");           //不能以0开头，接4到9个0到9的数
        boolean c = password.matches("[a-zA-Z0-9]*");       //0到多个0到9的数或a到z的字母或A到Z的字母//'*'是0到多个//'+'是1到多个//'?'是0或1个
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
