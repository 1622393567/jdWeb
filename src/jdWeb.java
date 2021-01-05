import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class jdWeb {
   static Goods[] goodses=new Goods[5];//购物车数组
    static int count=0;
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scanner=new Scanner(System.in);
        String id;//用户输入的用户名
        String passWord;//用户输入的密码
        boolean flag;//判断是否登录成功
        InputStream ingoods=Class.forName("jdWeb").getResourceAsStream("/goods.xlsx");//代替了path的功能
        ReadExcel readExcelgoods=new ReadExcel();//读取表格数据
        //这两行代码为解决输入流输出流的办法


        //实现登录功能
        //实现循环判断重新登录功能
        //实现商品列表显示功能
        //实现商品加入购物车功能
        //实现多次加入购物车的功能，并显示购物车商品
        while(true){
            System.out.println("请输入账号");
            id=scanner.nextLine();
            System.out.println("请输入密码");
            passWord=scanner.nextLine();

            flag=Landing(id,passWord);
            if(flag){
                System.out.println("登录成功");
                System.out.println("欢迎登录媛多多系统");
                //显示商品
                System.out.println("以下是商品列表，请选择你所需要的商品并输入商品id，即可购买");
                goodlist();//显示商品清单
                System.out.println("请选择你所需要的商品并输入商品id，即可购买");
                System.out.println("请输入商品编号");
                String goodsId=scanner.next();
               sercherById(goodsId);//调用加入商品方法
                //第一次购买结束
                //开始重复购买
                int keep=0;
                while(true){
                    System.out.println("请问是否继续购买，继续购买请输入0，否则输入任意数字结束购买并且显示购物车商品");
                     keep=scanner.nextInt();
                    if (keep==0){
                        System.out.println("请输入商品编号");
                        goodsId=scanner.next();
                        sercherById(goodsId);
                    }else{
                        System.out.println("结束购买,显示购物车已经购买商品");
                        break;
                    }
                }
                //显示购物车商品
                GoodsesToString();

                break;
            }else{
                System.out.println("登录失败,请重新输入");
            }
        }



    }
    //创建方法 ，返回购物车中的商品


    public static void GoodsesToString() {
        System.out.println("您已经购买的商品如下");
            for (int i=0;i<goodses.length;i++){
                if(goodses[i]!=null){
                    int flag=i+1;
                    System.out.println("第"+flag+"件:"+goodses[i].getGoodsName());
                }else{
                    break;
                }
            }

    }

    //创建方法，返回一个商品
    public static void sercherById (String id)throws ClassNotFoundException {
        InputStream ingoods=Class.forName("jdWeb").getResourceAsStream("/goods.xlsx");//代替了path的功能
        ReadExcel readExcelgoods=new ReadExcel();//读取表格数据
        //这两行代码为解决输入流输出流的办法
        Goods goods=readExcelgoods.reserchById(id,ingoods);
        if(goods!=null) {
            goodses[count] = goods;
            System.out.println("商品加入购物车成功，加入商品为" + goodses[count].getGoodsName());
            count++;
        }else {
            System.out.println("您选择的商品不存在，请重新选择");
        }
    }
    //创建方法 显示商品列表
    public static void goodlist() throws ClassNotFoundException {
        InputStream in=Class.forName("jdWeb").getResourceAsStream("/goods.xlsx");//代替了path的功能
        ReadExcel readExcel=new ReadExcel();
        Goods[] goods=readExcel.readExcelGOODS(in);
        System.out.println("商品ID\t商品名称\t商品单价\t商品数量");
        for (int i=0;i<goods.length;i++){
            System.out.println(goods[i].getGoodsID()+
                    "\t"+goods[i].getGoodsName()+
                    "\t"+goods[i].getGoodsPrice()+
                    "\t"+ goods[i].getGoodsNum()
            );
        }
        }
    //使用方法封装判断用户是否登录成功
    public static  boolean Landing(String userId,String passWord) throws ClassNotFoundException {
        boolean flag=false;
        //使用Excle登录
        InputStream in=Class.forName("jdWeb").getResourceAsStream("/user.xlsx");//代替了path的功能
        ReadExcel readExcel=new ReadExcel();
        User[] users=readExcel.readExcelUser(in);
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
