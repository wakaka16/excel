package txt;

/**
 * @Author wxl
 * @Date 2018/12/25
 **/

/**
 * Txt对应的物品信息对象
 */
public class GoodsInfo {
  private String date;//D
  private String time;//H
  private String serialNumber;//L
  private String stage;//P
  private String snugTorque;//M-
  private String stqMin;//M
  private String stqMax;//M+
  private String finalTorque;//W-
  private String ftqMin;//W
  private String ftqMax;//W+
  private String angle;//MWS
  private String anMin;//T
  private String anMax;//T+
  private String program;//S
  private String sequences;//QC

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date.trim();
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time.trim();
  }

  public String getStage() {
    return stage;
  }

  public void setStage(String stage) {
    this.stage = stage.trim();
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber.trim();
  }

  public String getSnugTorque() {
    return snugTorque;
  }

  public void setSnugTorque(String snugTorque) {
    this.snugTorque = snugTorque.trim();
  }

  public String getStqMin() {
    return stqMin;
  }

  public void setStqMin(String stqMin) {
    this.stqMin = stqMin.trim();
  }

  public String getStqMax() {
    return stqMax;
  }

  public void setStqMax(String stqMax) {
    this.stqMax = stqMax.trim();
  }

  public String getFinalTorque() {
    return finalTorque;
  }

  public void setFinalTorque(String finalTorque) {
    this.finalTorque = finalTorque.trim();
  }

  public String getFtqMin() {
    return ftqMin;
  }

  public void setFtqMin(String ftqMin) {
    this.ftqMin = ftqMin.trim();
  }

  public String getFtqMax() {
    return ftqMax;
  }

  public void setFtqMax(String ftqMax) {
    this.ftqMax = ftqMax.trim();
  }

  public String getAngle() {
    return angle;
  }

  public void setAngle(String angle) {
    this.angle = angle.trim();
  }

  public String getAnMin() {
    return anMin;
  }

  public void setAnMin(String anMin) {
    this.anMin = anMin.trim();
  }

  public String getAnMax() {
    return anMax;
  }

  public void setAnMax(String anMax) {
    this.anMax = anMax.trim();
  }

  public String getProgram() {
    return program;
  }

  public void setProgram(String program) {
    this.program = program.trim();
  }

  public String getSequences() {
    return sequences;
  }

  public void setSequences(String sequences) {
    this.sequences = sequences.trim();
  }

  @Override
  public String toString() {
    return "GoodsInfo{" +
        "serialNumber='" + serialNumber + '\'' +
        ", snugTorque='" + snugTorque + '\'' +
        ", stqMin='" + stqMin + '\'' +
        ", stqMax='" + stqMax + '\'' +
        ", finalTorque='" + finalTorque + '\'' +
        ", ftqMin='" + ftqMin + '\'' +
        ", ftqMax='" + ftqMax + '\'' +
        ", angle='" + angle + '\'' +
        ", anMin='" + anMin + '\'' +
        ", anMax='" + anMax + '\'' +
        ", program='" + program + '\'' +
        ", sequences='" + sequences + '\'' +
        '}';
  }
}
