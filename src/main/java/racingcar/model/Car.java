package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

  private static final int GO = 1;
  private static final int MIN_NUM = 0;
  private static final int MAX_NUM = 9;
  private static final int MOVE_THRESHOLD = 4;
  private String name;
  private int movement = 0;

  public Car(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getMovement() {
    return movement;
  }

  private int generateRandomNum() {
    return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
  }

  private boolean shouldMove(int randomNum) {
    return randomNum >= MOVE_THRESHOLD;
  }

  public void setMovement() {
    if(shouldMove(generateRandomNum())){
      movement += GO;
    }
  }
}
