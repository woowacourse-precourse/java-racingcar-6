package racingcar.view.console;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.Message;

public class ApplicationConsoleView implements ConsoleView {

  private static final String DELIMITER = ", ";
  private static final String NEW_LINE = "\n";

  @Override
  public void printCarNamesInputMessage() {
    print(Message.INPUT_CAR_NAMES);
  }

  @Override
  public void printAttemptInputMessage() {
    print(Message.INPUT_ATTEMPT);
  }

  @Override
  public void printResultMessage() {
    print(NEW_LINE + Message.RACING_RESULT_MESSAGE_PREFIX);
  }

  @Override
  public void printRacingResult(String result) {
    print(result);
  }


  @Override
  public void printFinalWinners(List<String> finalWinners) {
    print(Message.WINNERS_MESSAGE_PREFIX + String.join(DELIMITER, finalWinners));
  }

  @Override
  public void printErrorMessage(String errorMessage) {
    print(errorMessage);
  }

  @Override
  public String getCarNames() {
    return getInput();
  }

  @Override
  public int getAttempt() {
    String trial = getInput();
    validateNumeric(trial);
    return Integer.parseInt(trial);
  }

  private void validateNumeric(String input) {
    try {
      Integer.parseInt(input);
    } catch (NumberFormatException nef) {
      throw new IllegalArgumentException();
    }
  }


  private String getInput() {
    return Console.readLine();
  }

  private void print(String value) {
    System.out.print(value);
  }
}
