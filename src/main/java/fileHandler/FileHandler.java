package fileHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wxl
 * @Date 2018/12/25
 **/
public class FileHandler {

  /**
   * 给定一个目录，获取目录下所有txt文件(一级)
   */
  public static List<File> getAllTxtFiles(String dirPath) {
    File dir = new File(dirPath);
    if (!dir.exists()) {
      System.out.println("指定目录不存在");
      return null;
    }
    if (!dir.isDirectory()) {
      System.out.println("它不是目录");
      return null;
    }
    File[] files = dir.listFiles();
    List<File> fileList = new ArrayList<File>();
    for (File file : files) {
      //文件名规则
      String name = file.getName();
      if (name.startsWith("Ch_") && name.endsWith(".txt")) {
        fileList.add(file);
      }
    }
    return fileList;
  }
}
