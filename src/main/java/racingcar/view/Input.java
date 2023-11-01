package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import racingcar.utils.ValidationUtils;

public class Input {

  public List<String> inputCarNames() {
    System.out.println("자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    String inputNames = Console.readLine();
    ValidationUtils.validateCarNames(inputNames);
    System.out.println(inputNames);
    return Arrays.asList(inputNames.split(","));
  }

  public int inputTryCount() {
    System.out.println("시도할 회수를 입력하세요.");
    String inputNumber = Console.readLine();
    ValidationUtils.validateUserInput(inputNumber);
    System.out.println(inputNumber);
    return Integer.parseInt(inputNumber);
  }
}