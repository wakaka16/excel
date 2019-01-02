import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author wxl
 * @Date 2019/1/2
 **/
public class Test {

  public static void main(String[] args) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    System.out.println(sdf.format(new Date()));
  }

}
