package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;


public class InputView {

  public String readCarName() {
    String input = Console.readLine();
    return Validator.parseToNames(input);
  }

  public int readProgressCount() {
    String input = Console.readLine();
    return Validator.parseToInt(input);
  }

}
