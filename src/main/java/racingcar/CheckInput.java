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
      if (name.length() > GameConstant.MAXLENGTH) {
        throw new IllegalArgumentException(GameConstant.Output.CHECKMAXLENGTH.print());
      }
      if (name.length() == GameConstant.ZERO) {
        throw new IllegalArgumentException(GameConstant.Output.CHECKZEROLENGTH.print());
      }
    }
  }

  public void carNameEmptyInput(String carNameInput) {
    if (carNameInput.startsWith(",") || carNameInput.endsWith(",")) {
      throw new IllegalArgumentException(GameConstant.Output.CHECKZEROLENGTH.print());
    }
  }
}
