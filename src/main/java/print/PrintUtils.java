package print;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import java.io.File;

/**
 * @author xulin
 * @date 2019/1/2 9:15
 */
public class PrintUtils {


  /**
   * 打印Excel文件
   * @param filePath  文件路径
   */
  public static boolean printFileAction(String filePath) {
    System.out.println("开始打印文件："+filePath);
    boolean returnFlg = false;
    try {
      ComThread.InitSTA();
      ActiveXComponent xl = new ActiveXComponent("Excel.Application");
      // 不打开文档
      Dispatch.put(xl, "Visible", new Variant(true));
      Dispatch workbooks = xl.getProperty("Workbooks").toDispatch();
      // win下路径处理(把根目录前的斜杠删掉)
//      filePath = filePath.replace("/E:/", "E:/");

      // 判断文件是否存在
      File file = new File(filePath);
      if (file.exists()) {
        Dispatch excel = Dispatch.call(workbooks, "Open", filePath).toDispatch();
        // 开始打印
        Dispatch.get(excel, "PrintOut");
        returnFlg = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new IllegalArgumentException("打印错误");
    } finally {
      // 始终释放资源
      ComThread.Release();
    }
    return returnFlg;
  }
}
