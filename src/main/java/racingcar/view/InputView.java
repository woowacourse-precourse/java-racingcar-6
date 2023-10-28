package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.FrequencyValidator;

public class InputView {

  private static FrequencyValidator frequencyValidator;

  public InputView(){
    frequencyValidator = new FrequencyValidator();
  }
  public String inputCarName() {
    OutputView.printInputNameMessage();
    return Console.readLine();
  }

  public int inputFrequency() {
    OutputView.printInputFrequencyMessage();
    String frequency = Console.readLine();
    frequencyValidator.isCorrectFrequencyNumber(frequency);
    frequencyValidator.isNegativeNumber(frequency);
    return Integer.parseInt(frequency);
  }

}
