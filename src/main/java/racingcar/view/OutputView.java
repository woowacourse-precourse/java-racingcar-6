package racingcar.view;

import racingcar.model.Cars;

public class OutputView {

  public static void printRoundResultNotice() {
    System.out.println(ViewNotice.ROUND_RESULT_NOTICE);
  }

  public static void printRoundResult(Cars cars) {
    System.out.println(cars);
  }

  public static void printRacingCarGameWinner(Cars cars) {
    System.out.println("최종 우승자 : " + cars.getWinnerByDistance());
  }
}

