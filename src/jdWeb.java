import java.util.Scanner;

public class jdWeb {
    public static void main(String[] args){
       //创建一个新用户
        User user=new User();
        user.setUserName("pangda");
        user.setUserId("123456");//用户账号
        user.setUserPassWord("123456");//用户密码
        Scanner scanner=new Scanner(System.in);


        //实现登录功能
        System.out.println("请输入账号");
        String id=scanner.nextLine();
        System.out.println("请输入密码");
        String passWord=scanner.nextLine();
        if(id.equals(user.getUserId()) || passWord.equals(user.getUserPassWord())){
            System.out.println("登录成功");
            System.out.println("尊敬的"+user.getUserName()+"用户"+"，欢迎登录媛多多系统");
        }else{
            System.out.println("登录失败");
        }

    }
}
