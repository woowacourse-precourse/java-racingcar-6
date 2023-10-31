package racingcar.view;

import static racingcar.constant.ViewConstants.ROUND_RESULT_NOTICE;

import racingcar.model.Cars;

public class OutputView {

  public static void printRoundResultNotice() {
    System.out.println(ROUND_RESULT_NOTICE);
  }

  public static void printRoundResult(final Cars cars) {
    System.out.println(cars);
  }

  public static void printRacingCarGameWinner(final Cars cars) {
    System.out.println("최종 우승자 : " + cars.getWinnerByDistance());
  }
}

