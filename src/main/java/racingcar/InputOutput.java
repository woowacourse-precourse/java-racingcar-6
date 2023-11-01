package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputOutput {
  CheckInput check = new CheckInput();

  public String getCarName() {
    System.out.println(GameConstant.Output.INPUTCARNAME.print());
    String carNameInput = Console.readLine();
    String[] carNames = carNameInput.split(",");
    check.carNamelength(carNames);
    return carNameInput;
  }

}
