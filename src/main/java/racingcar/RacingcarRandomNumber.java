package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingcarRandomNumber {

  public List<Integer> generate(int numOfCars) {
    List<Integer> randomNumList = new ArrayList<>();
    while (numOfCars > 0) {
      randomNumList.add(Randoms.pickNumberInRange(0, 9));
      numOfCars--;
    }
    return randomNumList;
  }
}
