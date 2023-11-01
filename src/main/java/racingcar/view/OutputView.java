package racingcar.view;

import static racingcar.message.PrintMessage.FINAL_WINNER;
import static racingcar.message.PrintMessage.START_MESSAGE;
import static racingcar.message.PrintMessage.START_TRY_NUM;
import static racingcar.message.PrintMessage.TRY_RESULT;

import racingcar.domain.CarScoreCalculator;
import racingcar.domain.CarStatus;

public class OutputView {
  public void printInputRacing() {
    System.out.println(START_MESSAGE.getMessage());
  }

  public void printInputTryNumber() {
    System.out.println(START_TRY_NUM.getMessage());
  }

  public void printTryResult() {
    System.out.println(TRY_RESULT.getMessage());
  }

  public void printRacingStatus(CarStatus status) {
    System.out.println(status.toRacingLog());
  }

  public void printFinalWinner(CarStatus status) {
    System.out.println(FINAL_WINNER.getMessage() + CarScoreCalculator.calculateFinalWinner(status));
  }
}
