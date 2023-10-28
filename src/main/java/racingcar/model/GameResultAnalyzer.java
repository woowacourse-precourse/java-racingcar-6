package racingcar.model;

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

}
