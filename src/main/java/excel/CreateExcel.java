package excel;

/**
 * @Author wxl
 * @Date 2018/12/25
 **/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import txt.GoodsInfo;

/**
 *生成excel
 */
public class CreateExcel {

  /**
   * 创建xlsx文件和表头
   */
  public static void createExcel(List<GoodsInfo> goodsInfoList,String path){
    System.out.println("开始生成excel"+path);
    File excelFile = new File(path);
    FileOutputStream outStream = null;
    try{
      // 声明一个工作薄
      XSSFWorkbook workBook = new XSSFWorkbook();
      // 生成一个表格
      XSSFSheet sheet = workBook.createSheet();
      workBook.setSheetName(0, "连接螺栓定力记录表");

      XSSFRow titleRow = sheet.createRow(5);
      titleRow.createCell(0).setCellValue("日期");
      titleRow.createCell(1).setCellValue("时间");
      titleRow.createCell(2).setCellValue("序号");
      titleRow.createCell(3).setCellValue("阶段");
      titleRow.createCell(4).setCellValue("定力方式");
      titleRow.createCell(5).setCellValue("定力顺序");
      titleRow.createCell(6).setCellValue("初始力矩");
      titleRow.createCell(7).setCellValue("最小初始力矩");
      titleRow.createCell(8).setCellValue("最大初始力矩");
      titleRow.createCell(9).setCellValue("最终力矩");
      titleRow.createCell(10).setCellValue("最小最终力矩");
      titleRow.createCell(11).setCellValue("最大最终力矩");
      titleRow.createCell(12).setCellValue("最终角度");
      titleRow.createCell(13).setCellValue("最小角度");
      titleRow.createCell(14).setCellValue("最大角度");
      titleRow.createCell(15).setCellValue("状态");
      XSSFRow titleRow2 = sheet.createRow(6);
      titleRow2.createCell(0).setCellValue("Date");
      titleRow2.createCell(1).setCellValue("Time");
      titleRow2.createCell(2).setCellValue("Serial Number");
      titleRow2.createCell(3).setCellValue("Stage");
      titleRow2.createCell(4).setCellValue("Program");
      titleRow2.createCell(5).setCellValue("Sequences");
      titleRow2.createCell(6).setCellValue("Snug Torque");
      titleRow2.createCell(7).setCellValue("STQ-Min");
      titleRow2.createCell(8).setCellValue("STQ-Max");
      titleRow2.createCell(9).setCellValue("Final Torque");
      titleRow2.createCell(10).setCellValue("FTQ-Min");
      titleRow2.createCell(11).setCellValue("FTQ-Max");
      titleRow2.createCell(12).setCellValue("Angle");
      titleRow2.createCell(13).setCellValue("AN-Min");
      titleRow2.createCell(14).setCellValue("AN-Max");
      titleRow2.createCell(15).setCellValue("State");
      for (int i = 0; i < goodsInfoList.size(); i++) {
        XSSFRow row = sheet.createRow(i + 7);
        row.createCell(0).setCellValue(goodsInfoList.get(i).getDate());
        row.createCell(1).setCellValue(goodsInfoList.get(i).getTime());
        row.createCell(2).setCellValue(goodsInfoList.get(i).getSerialNumber());
        row.createCell(3).setCellValue(goodsInfoList.get(i).getStage());
        row.createCell(4).setCellValue(goodsInfoList.get(i).getProgram());
        row.createCell(5).setCellValue(goodsInfoList.get(i).getSequences());
        row.createCell(6).setCellValue(goodsInfoList.get(i).getSnugTorque());
        row.createCell(7).setCellValue(goodsInfoList.get(i).getStqMin());
        row.createCell(8).setCellValue(goodsInfoList.get(i).getStqMax());
        row.createCell(9).setCellValue(goodsInfoList.get(i).getFinalTorque());
        row.createCell(10).setCellValue(goodsInfoList.get(i).getFtqMin());
        row.createCell(11).setCellValue(goodsInfoList.get(i).getFtqMax());
        row.createCell(12).setCellValue(goodsInfoList.get(i).getAngle());
        row.createCell(13).setCellValue(goodsInfoList.get(i).getAnMin());
        row.createCell(14).setCellValue(goodsInfoList.get(i).getAnMax());
        row.createCell(15).setCellValue(goodsInfoList.get(i).getStage());
      }

      //文件输出流
      outStream = new FileOutputStream(excelFile);
      workBook.write(outStream);
      outStream.flush();
      outStream.close();
    }catch (Exception e){
      e.printStackTrace();
      throw new IllegalArgumentException("excel生成错误");
    }finally {
      if(outStream!=null){
        try {
          outStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }


}
