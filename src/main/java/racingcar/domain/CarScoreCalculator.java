package racingcar.domain;

import java.util.List;

public class CarScoreCalculator {
  private static final String WINNER_SEPARATE = ", ";

  public static String calculateFinalWinner(CarStatus carStatus) {
    int maxPosition = carStatus.getMaxPosition();
    List<String> finalWinners = carStatus.getCarNamesAtPosition(maxPosition);

    if (finalWinners.size() == 1) {
      return finalWinners.get(0);
    } else {
      return String.join(WINNER_SEPARATE, finalWinners);
    }
  }
}