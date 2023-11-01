package racingcar;

public class CheckInput {

  public void trial(String trial) {
    try {
      Integer.parseInt(trial);
    } catch (Exception e) {
      throw new IllegalArgumentException(GameConstant.Output.CHECKTRIAL.print());
    }
  }

  public void carNamelength(String[] carNames) {
    for (String name : carNames) {
      if(name.length() > 5) {
        throw new IllegalArgumentException(GameConstant.Output.CHECKLENGTH.print());
      }
    }
  }
}
