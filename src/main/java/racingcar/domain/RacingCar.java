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

  public void printNameAndPosition() {
    System.out.print(name + " : ");
    for(int i = 0; i < position; i++) {
      System.out.print('-');
    }
    System.out.println();
  }

}
