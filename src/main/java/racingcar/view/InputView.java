package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
  public String inputCarName() {
    OutputView.printInputNameMessage();
    return Console.readLine();
  }

  public int inputFrequency() {
    OutputView.printInputFrequencyMessage();
    String frequency = Console.readLine();
    return Integer.parseInt(frequency);
  }

}
