import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class ReadExcel {
    public User[] readExcelUser(InputStream in) {
        User users[] = null;
        try {
            XSSFWorkbook xw = new XSSFWorkbook(in);
            XSSFSheet xs = xw.getSheetAt(0);
            users = new User[xs.getLastRowNum()];
            for (int j = 1; j <= xs.getLastRowNum(); j++) {
                XSSFRow row = xs.getRow(j);
                User user = new User();//每循环一次就把电子表格的一行的数据给对象赋值
                for (int k = 0; k <= row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);
                    if (cell == null)
                        continue;
                    if (k == 0) {
                        user.setUserName(this.getValue(cell));//给username属性赋值
                    } else if (k == 1) {
                        user.setUserId(this.getValue(cell));//给userid属性赋值
                    } else if (k == 2) {
                        user.setUserPassWord(this.getValue(cell));//给password属性赋值
                    } else if (k == 3) {
                        user.setUserPhone(this.getValue(cell));//给phone属性赋值
                    }
                }
                users[j-1] = user;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
    public Goods[] readExcelGOODS(InputStream in) {
        Goods goods[] = null;
        try {
            XSSFWorkbook xw = new XSSFWorkbook(in);
            XSSFSheet xs = xw.getSheetAt(0);
            goods = new Goods[xs.getLastRowNum()];
            for (int j = 1; j <= xs.getLastRowNum(); j++) {
                XSSFRow row = xs.getRow(j);
                Goods goods1 = new Goods();//每循环一次就把电子表格的一行的数据给对象赋值
                for (int k = 0; k <= row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);
                    if (cell == null)
                        continue;
                    if (k == 0) {
                        goods1.setGoodsID(this.getValue(cell));//给goodid属性赋值
                    } else if (k == 1) {
                        goods1.setGoodsName(this.getValue(cell));//给goodname属性赋值
                    } else if (k == 2) {
                        goods1.setGoodsPrice(this.getValue(cell));//给goodprice属性赋值
                    } else if (k == 3) {
                        goods1.setGoodsNum(this.getValue(cell));//给goodnum属性赋值
                    }
                }
                goods[j-1] = goods1;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return goods;
    }
    //返回找到的商品
    public Goods reserchById(String id,InputStream in) {
        try {
            XSSFWorkbook xw = new XSSFWorkbook(in);
            XSSFSheet xs = xw.getSheetAt(0);
            for (int j = 1; j <= xs.getLastRowNum(); j++) {
                XSSFRow row = xs.getRow(j);
                Goods goods1 = new Goods();//每循环一次就把电子表格的一行的数据给对象赋值
                for (int k = 0; k <= row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);
                    if (cell == null)
                        continue;
                    if (k == 0) {
                        goods1.setGoodsID(this.getValue(cell));//给goodid属性赋值
                    } else if (k == 1) {
                        goods1.setGoodsName(this.getValue(cell));//给goodname属性赋值
                    } else if (k == 2) {
                        goods1.setGoodsPrice(this.getValue(cell));//给goodprice属性赋值
                    } else if (k == 3) {
                        goods1.setGoodsNum(this.getValue(cell));//给goodnum属性赋值
                    }

                }
                if(goods1.getGoodsID().equals(id)){
                    return goods1;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private String getValue(XSSFCell cell) {
        String value;
        CellType type = cell.getCellTypeEnum();

        switch (type) {
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BLANK:
                value = "";
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue() + "";
                break;
            case NUMERIC:
                DecimalFormat df=new DecimalFormat("0");
                value=df.format(cell.getNumericCellValue());
                break;
            case FORMULA:
                value = cell.getCellFormula();
                break;
            case ERROR:
                value = "非法字符";
                break;
            default:
                value = "";
                break;
        }
        return value;
    }
}