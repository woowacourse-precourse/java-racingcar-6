package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

  private final static int MIN_NUMBER = 0;
  private final static int MAX_NUMBER = 9;

  public static int generateRandomNumber() {
    return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
  }
}
