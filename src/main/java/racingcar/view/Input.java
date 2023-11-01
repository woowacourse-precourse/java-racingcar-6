package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.ValidationUtils;

public class Input {

  public List<String> inputCarNames() {
    String inputNames = readInput("자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    ValidationUtils.validateCarNames(inputNames);
    return Arrays.asList(inputNames.split(","));
  }

  public int inputTryCount() {
    String inputNumber = readInput("시도할 회수를 입력하세요.");
    ValidationUtils.validateUserInput(inputNumber);
    return Integer.parseInt(inputNumber);
  }

  private String readInput(String message) {
    System.out.println(message);
    return Console.readLine();
  }
}
