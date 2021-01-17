import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
public class CreateOreder{
    /** Excel 文件要存放的位置，假定在F盘下*/
    public  void IOreder(Order order){
         String outputFile = "E:\\MyIdeaCode\\jdWeb\\src\\Order.xlsx";

        try {
            // 创建新的Excel 工作簿
            XSSFWorkbook workbook = new XSSFWorkbook();
            //HSSFWorkbook workbook = new HSSFWorkbook();
            // 在Excel工作簿中建一工作表，其名为缺省值
            // 如要新建一名为"效益指标"的工作表，其语句为：
            XSSFSheet sheet = workbook.createSheet("sheet1");
            // 在索引0的位置创建行（最顶端的行）
            //XSSFRow row = sheet.createRow((short)0);
            //在索引0的位置创建单元格（左上端）
            for(int i=0;i<order.getGoods().length+1;i++){
                XSSFRow row = sheet.createRow((short)i);
                if(i==0){
                    row.createCell(0).setCellValue("订单编号");
                    row.createCell(1).setCellValue("商品名称");
                    row.createCell(2).setCellValue("商品价格");
                    row.createCell(3).setCellValue("购买者");
                    row.createCell(4).setCellValue("电话");
                }else{
                    if(order.getGoods()[i-1]!=null) {
                        row.createCell(0).setCellValue(order.getId());
                        row.createCell(1).setCellValue(order.getGoods()[i-1].getGoodsName());
                        row.createCell(2).setCellValue(order.getGoods()[i-1].getGoodsPrice());
                        row.createCell(3).setCellValue(order.getUser().getUserName());
                        row.createCell(4).setCellValue(order.getUser().getUserPhone());
                    }

                }
            }
            /*for (int i=0;i<3;i++){
                XSSFCell cell = row.createCell((short)i);
                cell.setCellValue(i);
                }
             */


            //XSSFCell cell = row.createCell((short)0);
            // 定义单元格为字符串类型

            // 在单元格中输入一些内容
            //cell.setCellValue("测试");
            //cell.setCellValue("测试二");
            // 新建一输出文件流
            FileOutputStream fOut = new FileOutputStream(outputFile);
            // 把相应的Excel 工作簿存盘
            workbook.write(fOut);
            fOut.flush();
            // 操作结束，关闭文件
            fOut.close();
            System.out.println("订单文件已生成...");
        } catch (Exception e) {
            System.out.println("已运行 xlCreate() : " + e);
        }
    }


}