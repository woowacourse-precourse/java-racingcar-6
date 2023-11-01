package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingcarGame {

  public List<Integer> evaluateTrial(List<Integer> locations, List<Integer> randomNumList) {
    for (int i = 0; i < randomNumList.size(); i++) {
      if (randomNumList.get(i) >= 4) {
        locations.set(i, locations.get(i) + 1);
      }
    }
    return locations;
  }

}
