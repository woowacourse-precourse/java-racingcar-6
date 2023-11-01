package racingcar.view.console;

import java.util.List;

public interface ConsoleView {

  void printCarNamesInputMessage();

  void printAttemptInputMessage();

  void printResultMessage();

  void printRacingResult(String result);

  void printFinalWinners(List<String> finalWinners);

  void printErrorMessage(String errorMessage);

  String getCarNames();

  int getAttempt();
}
