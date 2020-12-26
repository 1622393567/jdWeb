import java.io.File;
import java.util.Scanner;

public class jdWeb {
    public static void main(String[] args){


        Scanner scanner=new Scanner(System.in);


        //实现登录功能
        System.out.println("请输入账号");
        String id=scanner.nextLine();
        System.out.println("请输入密码");
        String passWord=scanner.nextLine();
        boolean flag=Landing(id,passWord);
        if(flag){
            System.out.println("登录成功");
            System.out.println("欢迎登录媛多多系统");
        }else{
            System.out.println("登录失败");
        }



    }
    //使用方法封装判断用户是否登录成功
    public static  boolean Landing(String userId,String passWord){
        boolean flag=false;
        //使用Excle登录
        File file=new File("E:\\MyIdeaCode\\lanqiaoCode\\src\\user.xlsx");
        ReadExcel readExcel=new ReadExcel();
        User[] users=readExcel.readExcel(file);
        for (int i=0;i<users.length;i++){
            if(users[i].getUserId().equals(userId) &&users[i].getUserPassWord().equals(passWord)){
                flag=true;
                System.out.println("用户名为："+users[i].getUserName());
            }
        }
        return flag;
    }
}
