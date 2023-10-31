package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;

public class InputView {


  public String readCarName() {
    String input = Console.readLine();
    Validator.CarNames(input);
    return input;
  }

  public int readProgressCount() {
    return Integer.parseInt(Console.readLine());
  }

}
