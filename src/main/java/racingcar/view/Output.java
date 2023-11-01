package racingcar.view;

import java.util.List;

public class Output {
  private static final String POSITION_SYMBOL = "-";
  private static final String FINAL_WINNER_LABEL = "최종 우승자 : ";

  public void printCurrentPositions(List<String> carNames, List<Integer> carPositions) {
    for (int i = 0; i < carNames.size(); i++) {
      System.out.println(carNames.get(i) + " : " + POSITION_SYMBOL.repeat(carPositions.get(i)));
    }
    System.out.println();
  }

  public void printFinalWinners(List<String> winnerNames) {
    String winners = String.join(", ", winnerNames);
    System.out.println(FINAL_WINNER_LABEL + winners);
  }
}
