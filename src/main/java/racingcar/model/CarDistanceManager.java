package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CarDistanceManager {

  public static int createRandomNumber() {
    return Randoms.pickNumberInRange(0, 9);
  }

  public static void selectAction(List<Integer> distance) {
    for (int i = 0; i < distance.size(); i++) {
      if (createRandomNumber() >= 4) {
        int currentDistance = distance.get(i);
        distance.set(i, currentDistance + 1);
      }
    }
  }


}
