package racingcar.view;

import java.util.List;

public class OutputView {

  private static final String START_RACE_GAME = "실행 결과";
  private static final String CAR_POSITION_DELIMITER = " : ";
  private static final String CAR_POSITION_MARK = "-";
  private static final String FINAL_HEAD_OF_RACE_DELIMITER = ", ";
  private static final String FINAL_HEAD_OF_RACE_PREFIX_MESSAGE = "최종 우승자 : ";

  public void printStartRaceGame() {
    System.out.println(START_RACE_GAME);
  }

  public void printCarPositionResults(List<CarPositionResult> results) {
    results.forEach(result -> {
      System.out.println(result.carName() + CAR_POSITION_DELIMITER + mark(result.position()));
    });
    System.out.println();
  }

  private String mark(int position) {
    return CAR_POSITION_MARK.repeat(position);
  }

  public void printFinalHeadOfRace(List<String> headOfRaceCarNames) {
    System.out.println(FINAL_HEAD_OF_RACE_PREFIX_MESSAGE +
        String.join(FINAL_HEAD_OF_RACE_DELIMITER, headOfRaceCarNames));
  }
}
