package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarDistanceManager {

  public int createRandomNumber() {
    return Randoms.pickNumberInRange(0, 9);
  }

  public void selectAction(List<Integer> distance) {
    for (int i = 0; i < distance.size(); i++) {
      if (createRandomNumber() >= 4) {
        int currentDistance = distance.get(i);
        distance.set(i, currentDistance + 1);
      }
    }
  }

  public List<Integer> carDistance(List<String> carNamesList) {
    List<Integer> carDistanceList = new ArrayList<>();
    for (int i = 0; i < carNamesList.size(); i++) {
      carDistanceList.add(0);
    }
    return carDistanceList;
  }

}
