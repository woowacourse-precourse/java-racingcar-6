package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.support.RandomNumberGenerator;

public class CarMoveRandomGenerator implements RandomNumberGenerator<Boolean> {
  private static final int MIN_RANDOM_NUMBER = 0;
  private static final int MAX_RANDOM_NUMBER = 9;
  private static final int MIN_NUMBER_FOR_CAR_MOVE = 4;

  public Boolean generateRandomNumber() {
    int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

    return randomNumber >= MIN_NUMBER_FOR_CAR_MOVE;
  }
}
