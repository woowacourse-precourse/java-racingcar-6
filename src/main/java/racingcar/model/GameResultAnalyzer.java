package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameResultAnalyzer {
  public int findMaxDistance(List<Integer> distance) {
    int max = distance.get(0);
    for (int i = 1; i < distance.size(); i++) {
      if (distance.get(i) > max) {
        max = distance.get(i);
      }
    }
    return max;
  }

  public List<Integer> selectWinner(List<Integer> distance, int max) {
    List<Integer> winners = new ArrayList<>();
    for (Integer integer : distance) {
      if (integer == max) {
        winners.add(1);
      } else {
        winners.add(0);
      }
    }
    return winners;
  }

}
