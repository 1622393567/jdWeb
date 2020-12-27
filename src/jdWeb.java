import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class jdWeb {
    public static void main(String[] args) throws ClassNotFoundException {


        Scanner scanner=new Scanner(System.in);
        String id;//用户输入的用户名
        String passWord;//用户输入的密码
        boolean flag;//判断是否登录成功

        //实现登录功能
        //实现循环判断重新登录功能
        while(true){
            System.out.println("请输入账号");
            id=scanner.nextLine();
            System.out.println("请输入密码");
            passWord=scanner.nextLine();

            flag=Landing(id,passWord);
            if(flag){
                System.out.println("登录成功");
                System.out.println("欢迎登录媛多多系统");
                break;
            }else{
                System.out.println("登录失败,请重新输入");
            }
        }



    }
    //使用方法封装判断用户是否登录成功
    public static  boolean Landing(String userId,String passWord) throws ClassNotFoundException {
        boolean flag=false;
        //使用Excle登录
        InputStream in=Class.forName("jdWeb").getResourceAsStream("/user.xlsx");//代替了path的功能
        ReadExcel readExcel=new ReadExcel();
        User[] users=readExcel.readExcel(in);
        for (int i=0;i<users.length;i++){
            if(users[i].getUserId().equals(userId) &&users[i].getUserPassWord().equals(passWord)){
                flag=true;

                System.out.println("用户名为："+users[i].getUserName());
                System.out.println("电话号码为："+users[i].getUserPhone());

            }
        }
        return flag;
    }
}
