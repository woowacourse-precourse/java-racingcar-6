package racingcar;

public class CheckInput {


  public void trial(String trial) {

  }

  public void carNamelength(String[] carNames) {
    for (String name : carNames) {
      if(name.length() > 5) {
        throw new IllegalArgumentException(GameConstant.Output.CHECKLENGTH.print());
      }
    }
  }
}
