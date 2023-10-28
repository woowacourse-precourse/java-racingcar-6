package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class CarDistanceManager {

  private int createRandomNumber() {
    return Randoms.pickNumberInRange(0, 9);
  }
}
