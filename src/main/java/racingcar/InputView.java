package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
  private final ExceptionHandler exceptionHandler;
  private static final String CAR_NAME_REQUEST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

  private static final String TRIAL_NUM_REQUEST = "시도할 회수는 몇회인가요?";

  public InputView() {
    exceptionHandler = new ExceptionHandler();
  }

  public List<String> carName() {
    System.out.println(CAR_NAME_REQUEST);
    return exceptionHandler.carNameException(Console.readLine());
  }

  public int trialNum() {
    System.out.println(TRIAL_NUM_REQUEST);
    return exceptionHandler.trialNumException(Console.readLine());
  }
}
