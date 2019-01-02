package txt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wxl
 * @Date 2018/12/25
 **/
public class GenerateGoodsInfo {

  /**
   * 将一个txt文本数据转换为list
   * @param txtFile
   * @return
   * @throws IOException
   */
  public static List<String> readTxt(File txtFile) {
    System.out.println("开始读取txt文件："+txtFile);
    List<String> stringList = new ArrayList<String>();
    BufferedReader br = null;
    try{
      if(!txtFile.exists()){
        System.out.println("文件不存在");
        return null;
      }
      if(!txtFile.isFile()){
        System.out.println("它不是一个文件");
        return null;
      }
      //文件读取
      InputStreamReader isr = new InputStreamReader(new FileInputStream(txtFile), "GBK");
      br = new BufferedReader(isr);
      //
      String lineTxt = null;
      while((lineTxt=br.readLine())!=null){
        stringList.add(lineTxt);
      }
    }catch (Exception e){
      e.printStackTrace();
      throw new IllegalArgumentException("读取txt文件错误");
    }finally {
      if(null!=br) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return stringList;
  }

  /**
   * 将一个list转化为GoodsInfo对象
   * @param txt
   * @return
   */
  public static GoodsInfo createGoodsInfo(List<String> txt){
    System.out.println("开始将txt文件数据转化");
    if(txt.isEmpty()){
      System.out.println("未读取到txt数据");
    }
    GoodsInfo goodsInfo = new GoodsInfo();
    //
    try{
      String s2 = txt.get(2);
      String date = s2.substring(s2.indexOf("D")+1,s2.lastIndexOf("H"));
      goodsInfo.setDate(date);
      String time = s2.substring(s2.lastIndexOf("H")+1);
      goodsInfo.setTime(time);
      //
      String s3 = txt.get(3);
      String serialNumber = s3.substring(s3.indexOf("L")+1,s3.lastIndexOf("P"));
      goodsInfo.setSerialNumber(serialNumber);
      System.out.println(serialNumber);
      String stage = s3.substring(s3.lastIndexOf("P")+1, s3.length()-4);//TODO -4有误
      goodsInfo.setStage(stage);
      //
      String s4 = txt.get(4);
      //
      String s5 = txt.get(5);
      String snugTorque = s5.substring(s5.indexOf("M")+2, secondIndex("M",s5));
      goodsInfo.setSnugTorque(snugTorque);
      String stqMin =s5.substring(secondIndex("M",s5)+1, s5.lastIndexOf("M")) ;
      goodsInfo.setStqMin(stqMin);
      String stqMax =s5.substring(s5.lastIndexOf("M")+2) ;
      goodsInfo.setStqMax(stqMax);
      //
      String s6 = txt.get(6);
      String finalTorque = s6.substring(s6.indexOf("W")+2, secondIndex("W",s6));
      goodsInfo.setFinalTorque(finalTorque);
      String ftqMin = s6.substring(secondIndex("W",s6)+1, thirdIndex("W", s6));
      goodsInfo.setFtqMin(ftqMin);
      String ftqMax =s6.substring(thirdIndex("W", s6)+2,s6.lastIndexOf("MWS"));
      goodsInfo.setFtqMax(ftqMax);
      String angle =s6.substring(s6.lastIndexOf("MWS")+3);
      goodsInfo.setAngle(angle);
      //
      String s7 = txt.get(7);
      String anMin = s7.substring(s7.indexOf("T")+1, secondIndex("T",s7));
      goodsInfo.setAnMin(anMin);
      String anMax = s7.substring(s7.lastIndexOf("T")+2);
      goodsInfo.setAnMax(anMax);
      //
      String s8 = txt.get(8);
      String program = s8.substring(s8.indexOf("S")+1, s8.indexOf("QC"));
      goodsInfo.setProgram(program);
      String sequences = s8.substring(s8.indexOf("QC")+2, s8.indexOf("RC"));
      goodsInfo.setSequences(sequences);
    }catch(Exception e){
      e.printStackTrace();
      throw new IllegalArgumentException("数据转化错误，可能是数据结构变化引起");
    }
    return goodsInfo;
  }

  /**
   * 获取字符串A在字符B中的第二个位置
   * @param indexStr
   * @param str
   * @return 有>0 无-1
   */
  private static int secondIndex(String indexStr,String str){
    int first = str.indexOf(indexStr);
    if(first==-1){
      return -1;
    }
    int second = str.indexOf(indexStr, first+1);
    return second;
  }

  /**
   * 获取字符串A在字符B中的第三个位置
   * @param indexStr
   * @param str
   * @return 有>1 无-1
   */
  private static int thirdIndex(String indexStr,String str){
    int first = str.indexOf(indexStr);
    if(first==-1){
      return -1;
    }
    int second = str.indexOf(indexStr, first+1);
    if(second==-1){
      return -1;
    }
    int third = str.indexOf(indexStr,second+1);
    return third;
  }

}
