package racingcar;

import org.assertj.core.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class InputOutput {
  CheckInput check = new CheckInput();

  public String[] getCarNames() {
    System.out.println(GameConstant.Output.INPUTCARNAME.print());
    String carNameInput = Console.readLine();
    String[] carNames = carNameInput.split(",");
    check.carNamelength(carNames);
    return carNames;
  }



}
