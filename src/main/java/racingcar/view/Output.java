package racingcar.view;

import java.util.List;

public class Output {

  public void printCurrentPositions(List<String> carNames, List<Integer> carPositions) {
    for (int i = 0; i < carNames.size(); i++) {
      System.out.println(carNames.get(i) + " : " + "-".repeat(carPositions.get(i)));
    }
    System.out.println();
  }

  public static void printFinalWinners(List<String> winnerNames) {
    String winners = String.join(", ", winnerNames);
    System.out.println("최종 우승자 : " + winners);
  }
}
