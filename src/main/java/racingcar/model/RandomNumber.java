package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
  private int number = 0;

  public RandomNumber() {
    this.number = generateRandomNumber();
  }

  private int generateRandomNumber() {
    // 랜덤 숫자 생성
    return Randoms.pickNumberInRange(0, 9);
  }

  public int getNumber() {
    return number;
  }
}
