package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
  public static String inputCarName() {
    OutputView.printInputNameMessage();
    return Console.readLine();
  }

  public static String inputFrequency() {
    OutputView.printInputFrequencyMessage();
    return Console.readLine();
  }

}
