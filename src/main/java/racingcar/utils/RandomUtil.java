package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

  public static int getRandomNumber(int minValue, int maxValue) {
    int RandomNum = Randoms.pickNumberInRange(minValue, maxValue);
    return RandomNum;
  }
}
