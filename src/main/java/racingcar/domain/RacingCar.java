package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
  private final String name;
  private int position = 0;

  public RacingCar(String name) {
    this.name = name;
  }

  public void decideMovePosition() {
    if(Randoms.pickNumberInRange(0, 9) > 3) {
      position++;
    }
  }

}
