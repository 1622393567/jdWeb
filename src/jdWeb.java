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
        User userFlag=new User();//判断是否登录成功
        boolean flag=true;//程序结束标志
        InputStream ingoods=Class.forName("jdWeb").getResourceAsStream("/goods.xlsx");//代替了path的功能
        ReadExcel readExcelgoods=new ReadExcel();//读取表格数据
        //这两行代码为解决输入流输出流的办法

        CreateOreder createOreder=new CreateOreder();//创建清单

        //实现登录功能
        //实现循环判断重新登录功能
        //实现商品列表显示功能
        //实现商品加入购物车功能
        //实现多次加入购物车的功能，并显示购物车商品
        //实现下订单功能,并且创建一个订单清单Xlsx文件
        //使用SWICH选择语句来改善代码

         while(true){
            System.out.println("请输入账号");
            id=scanner.nextLine();
            System.out.println("请输入密码");
            passWord=scanner.nextLine();

            userFlag=Landing(id,passWord);
            if (userFlag!=null){
                System.out.println("登录成功");
                System.out.println("用户名为："+userFlag.getUserName());
                System.out.println("电话号码为："+userFlag.getUserPhone());
                System.out.println("欢迎登录媛多多系统");
                System.out.println("请按照功能键选择您所需要的功能");
                while (flag){
                    System.out.println("按 1 键 ：显示商品列表");
                    System.out.println("按 2 键 ：选择商品加入购物车");
                    System.out.println("按 3 键 ：显示已经加入购物车的商品");
                    System.out.println("按 4 键 ：结束购买，并且显示已经购买的商品，创建购物清单");
                    System.out.println("请输入");
                    int keys=scanner.nextInt();
                    switch (keys){
                        case 1 ://显示商品列表
                            System.out.println("以下是商品列表");
                            goodlist();//显示商品清单
                            break;
                        case 2 ://购买商品
                            System.out.println("请选择你所需要的商品并输入商品id，即可购买");
                            System.out.println("请输入商品编号");
                            String goodsId=scanner.next();
                            sercherById(goodsId);//调用加入商品方法
                            break;

                        case 3 : //显示购物车商品
                            GoodsesToString();
                            break;
                        case 4 ://结束购买，并且创建清单
                            GoodsesToString();
                            CreatOreders(userFlag,"1");
                            flag=false;
                            break;

                    }

                }


                break;

            }else{
                System.out.println("登录失败,请重新输入");
            }


        }



    }

    //方法，实现创建订单
    public static void CreatOreders(User user,String i){
        Order order=new Order();
        order.setGoods(goodses);
        order.setId(i);
        order.setUser(user);
        CreateOreder createOreder=new CreateOreder();//创建清单
        createOreder.IOreder(order);


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
    public static  User Landing(String userId,String passWord) throws ClassNotFoundException {
        User flag=new User();
        //使用Excle登录
        InputStream in=Class.forName("jdWeb").getResourceAsStream("/user.xlsx");//代替了path的功能
        ReadExcel readExcel=new ReadExcel();
        User[] users=readExcel.readExcelUser(in);
        for (int i=0;i<users.length;i++){
            if(users[i].getUserId().equals(userId) &&users[i].getUserPassWord().equals(passWord)){

                return flag=users[i];
            }
        }
        return null;
    }
}
